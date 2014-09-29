package ru.korus.tmis.pdm.springdomain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.springdomain.model.User;
import ru.korus.tmis.pdm.springdomain.service.AuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.09.14, 12:36 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "auth")
@Scope("session")
public class AuthController implements Serializable {

    @Autowired
    AuthService authService;

    private String errorMsg = null;

    private User userForm = new User("", "");

    @RequestMapping(method = RequestMethod.GET)
    public String viewAuth(Map<String, Object> model) {
        model.put("errorMsg", errorMsg);
        model.put("user", userForm);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAuth(@ModelAttribute("user") User user,
                              Map<String, Object> model,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        errorMsg = null;
        userForm = user;
        Cookie authCooke = new Cookie("authToken", "");
        authCooke.setMaxAge(0);
        response.addCookie(authCooke);
        request.getSession().setAttribute(AuthInterceptor.AUTH_SESSION, false);
        try {
            String token = authService.createToken(user.getLogin(), user.getPassword());
            if(token == null) {
                errorMsg = "доступ запрещен";
            } else {
                request.getSession().setAttribute(RootController.VIEW_STATE, ViewState.FIND);
                response.addCookie(new Cookie("authToken", token));
                request.getSession().setAttribute(AuthInterceptor.AUTH_SESSION, true);
                errorMsg = null;
            }
        } catch (Exception e) {
            errorMsg = "Internal server error";
            e.printStackTrace();
        }
        return ViewState.ROOT.redirect();
    }

}
