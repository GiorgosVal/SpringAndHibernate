package org.example.springsecuritymvcaopvalidationdemo.security.config;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.example.springsecuritymvcaopvalidationdemo.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class.getSimpleName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("Inside " + this.getClass().getSimpleName());

        String username = authentication.getName();
        logger.info("username=" + username);

        User user = userService.findByUsername(username);

        // place user in the session
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", user);

        // forward to home page
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
    }
}
