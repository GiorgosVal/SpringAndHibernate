package org.example.springsecuritymvcaopvalidationdemo.security;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.RoleType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class.getSimpleName());
    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("Inside " + this.getClass().getSimpleName());

        String username = authentication.getName();
        logger.info("username=" + username);

        String targetUrl = determineTargetUrl(authentication);
        logger.info("Will redirect to target url :" + targetUrl);
        // forward to home page
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        List<String> grantedAuthorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if(grantedAuthorities.contains(ROLE_PREFIX + RoleType.ADMIN)) {
            logger.fine("Found authority " + ROLE_PREFIX + RoleType.ADMIN);
            return "/systems";
        }
        if(grantedAuthorities.contains(ROLE_PREFIX + RoleType.MANAGER)) {
            logger.fine("Found authority " + ROLE_PREFIX + RoleType.MANAGER);
            return "/leaders";
        }
        if(grantedAuthorities.contains(ROLE_PREFIX + RoleType.ASSOCIATE)) {
            logger.fine("Found authority " + ROLE_PREFIX + RoleType.ASSOCIATE);
            return "/associates";
        }
        if(grantedAuthorities.contains(ROLE_PREFIX + RoleType.EMPLOYEE)) {
            logger.fine("Found authority " + ROLE_PREFIX + RoleType.EMPLOYEE);
            return "/stuff";
        }
        if(grantedAuthorities.contains(ROLE_PREFIX + RoleType.CUSTOMER)) {
            logger.fine("Found authority " + ROLE_PREFIX + RoleType.CUSTOMER);
            return "/";
        }
        logger.severe("Granted authorities of user do not are not valid.");
        throw new IllegalStateException("Authentication object has not a mapped role.");
    }
}
