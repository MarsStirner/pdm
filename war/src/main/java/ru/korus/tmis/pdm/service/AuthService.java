package ru.korus.tmis.pdm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    boolean checkTokenCookies(HttpServletRequest request, HttpServletResponse response);

    String createToken(String username, String password);
}
