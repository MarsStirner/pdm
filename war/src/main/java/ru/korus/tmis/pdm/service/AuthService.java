package ru.korus.tmis.pdm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface AuthService {

    boolean checkTokenCookies(HttpServletRequest request, HttpServletResponse response);

    String createToken(String username, String password);

    boolean checkAdminPassword(String password);

}
