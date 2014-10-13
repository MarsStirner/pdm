package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmConfigService;
import ru.korus.tmis.pdm.utilities.Crypting;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        25.09.2014, 14:14 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    PdmConfigService pdmConfigService;

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
                authData = checkToken(tokenValue);
            } else if (countAuthToken > 1) {
                clearCooke(response, cookies);
            }
        }
        return authData != null;
    }

    @Override
    public String createToken(String username, String password) {
        if(checkLoginAndPassword(username, password)) {
            AuthData authData = new AuthData();
            authData.login = username;
            authData.loginTime = new Date();

            String token = null;
            for(int tryIndex = 0;
                tryIndex < 10 && tokens.get(token = UUID.randomUUID().toString()) != null; ++tryIndex);

            if(tokens.get(token) == null) {
                tokens.put(token, authData);
                return token;
            }
        }
        return null;
    }

    private boolean checkLoginAndPassword(String username, String password) {
        try {
            String adminName = pdmConfigService.getUserName();
            String passwordKey = pdmConfigService.getPasswordKey();
            String pass = Base64.encode(Crypting.getKey256Bit(password, "admin_pass",64));
            return username.equals(adminName) && passwordKey.equals(pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }

    private AuthData checkToken(String tokenValue) {
        AuthData authData = tokens.get(tokenValue);
        if(authData != null) {
            authData.loginTime = new Date();
        }
        return authData;
    }

    private void clearToken() {
        Date deadline = new Date((new Date()).getTime() - MAX_IDLE_MINUTES *60*1000);
        for (Map.Entry<String, AuthData> token : tokens.entrySet()) {
            if(token.getValue().loginTime.before(deadline)) {
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
