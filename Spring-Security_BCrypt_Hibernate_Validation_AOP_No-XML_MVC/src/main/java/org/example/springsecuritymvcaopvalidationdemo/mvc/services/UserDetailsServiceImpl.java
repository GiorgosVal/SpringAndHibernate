package org.example.springsecuritymvcaopvalidationdemo.mvc.services;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.Role;
import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getSimpleName());

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(Objects.isNull(user)) {
            logger.info("User not found.");
            throw new UsernameNotFoundException("Username not found.");
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
    }

    /**
     * Util method to map the roles of the user to Spring framework authorities.
     * @param user
     * @return
     */
    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(Role role : user.getRoles()) {
            logger.info("UserRole : " + role);
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        logger.info("authorities : " + authorities);
        return authorities;

    }

    /**
     * Alternative to the getGrantedAuthorities method. It can be called like mapRolesToAuthorities(user.getRoles())
     * inside the org.springframework.security.core.userdetails.User constructor.
     * @param roles
     * @return
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
