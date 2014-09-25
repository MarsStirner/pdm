package ru.korus.tmis.pdm.domain.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    boolean checkTokenCookies(HttpServletRequest request, HttpServletResponse response);
}
