package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.utilities.Crypting;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        25.09.2014, 14:14 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PdmXmlConfigService pdmXmlConfigService;

    public static final int MAX_IDLE_MINUTES = 10;

    private static class AuthData {

        private String login;

        private Date loginTime;
    }

    private static Map<String, AuthData> tokens = new HashMap<String, AuthData>();

    @Override
    public boolean checkTokenCookies(HttpServletRequest request, HttpServletResponse response) {
        AuthData authData = null;
        clearToken();
        Cookie[] cookies = request.getCookies();
        String tokenValue = null;
        if (cookies != null) {
            int countAuthToken = 0;
            for (int i = 0; i < cookies.length && countAuthToken < 2; ++i) {
                if ("authToken".equals(cookies[i].getName())) {
                    ++countAuthToken;
                    tokenValue = cookies[i].getValue();
                }
            }
            if (cookies != null && tokenValue != null && countAuthToken == 1) {
                authData = getAuthDataByToken(tokenValue);
            } else if (countAuthToken > 1) {
                clearCooke(response, cookies);
            }
        }
        return authData != null;
    }

    @Override
    public String createToken(String username, String password) {
        if (checkLoginAndPassword(username, password)) {
            return addToken(username);
        }
        return null;
    }

    @Override
    public String addToken(String username) {
        AuthData authData = new AuthData();
        authData.login = username;
        authData.loginTime = new Date();

        String token = null;
        for (int tryIndex = 0;
             tryIndex < 10 && tokens.get(token = Base64.encode(Crypting.getSecureRandomBytes(16))) != null; ++tryIndex)
            ;

        if (tokens.get(token) == null) {
            tokens.put(token, authData);
            return token;
        }
        return null;
    }

    @Override
    public boolean checkAdminPassword(String password) {
        try {
            String passwordKey = pdmXmlConfigService.getPasswordKey();
            String pass = pdmXmlConfigService.getAdminKeyByPassword(password);
            return passwordKey.equals(pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean logout(String token) {
        return tokens.remove(token) != null;
    }

    private boolean checkLoginAndPassword(String username, String password) {
        String adminName = pdmXmlConfigService.getUserName();
        return username.equals(adminName) && checkAdminPassword(password);
    }

    @Override
    public String checkToken(String token) {
        AuthData authDataByToken = getAuthDataByToken(token);
        return authDataByToken == null ? null : authDataByToken.login;
    }
    private AuthData getAuthDataByToken(String tokenValue) {
        AuthData authData = tokens.get(tokenValue);
        if (authData != null) {
            authData.loginTime = new Date();
        }
        return authData;
    }

    synchronized private void clearToken() {
        Date deadline = new Date((new Date()).getTime() - MAX_IDLE_MINUTES * 60 * 1000);
        for (Map.Entry<String, AuthData> token : tokens.entrySet()) {
            if (token.getValue().loginTime.before(deadline)) {
                tokens.remove(token.getKey());
            }
        }
    }

    private void clearCooke(HttpServletResponse response, Cookie[] cookies) {
        for (Cookie c : cookies) {
            c.setValue("");
            c.setPath("/");
            c.setMaxAge(0);
            response.addCookie(c);
        }
    }

}
