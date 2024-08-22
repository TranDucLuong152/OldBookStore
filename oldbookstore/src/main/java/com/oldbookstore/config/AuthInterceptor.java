package com.oldbookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.oldbookstore.entity.User;
import com.oldbookstore.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        User user = sessionService.get("user");

        if (user == null) {
            response.sendRedirect("/login?error=Please login!");
            return false;
        }

        if (!user.isRole() && uri.startsWith("/admin")) {
            response.sendRedirect("/login?error=Access denied!");
            return false;
        }

        return true;
    }
}
