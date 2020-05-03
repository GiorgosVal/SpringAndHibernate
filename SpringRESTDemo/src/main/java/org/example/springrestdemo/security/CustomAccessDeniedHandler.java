package org.example.springrestdemo.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    Logger logger = Logger.getLogger(CustomAccessDeniedHandler.class.getSimpleName());

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!Objects.isNull(authentication)) {
            logger.warning("User: " + authentication.getName() +
                    " attempted to access the protected URL: "
                    + httpServletRequest.getRequestURI());
        }
        
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/api/access-denied");
    }
}
