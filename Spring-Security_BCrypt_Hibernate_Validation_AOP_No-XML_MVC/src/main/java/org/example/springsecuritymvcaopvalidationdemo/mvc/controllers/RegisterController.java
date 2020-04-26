package org.example.springsecuritymvcaopvalidationdemo.mvc.controllers;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.example.springsecuritymvcaopvalidationdemo.mvc.models.UserRegistration;
import org.example.springsecuritymvcaopvalidationdemo.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private Logger logger = Logger.getLogger(RegisterController.class.getSimpleName());


    @GetMapping("new-user")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new UserRegistration());
        return "registration-form";
    }

    @PostMapping("processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("newUser") UserRegistration newUser,
                                          BindingResult bindingResult, Model model) {
        logger.info("Processing registration form for "+ newUser.getUsername());

        // form validation
        if(bindingResult.hasErrors()) {
            logger.warning("Registration form has errors.");
            newUser = UserRegistration.getUserRegistrationWithNoPassword(newUser);
            model.addAttribute("newUser", newUser);
            logger.info("Returning filled registration form with no password." + newUser.toString());
            return "registration-form";
        }

        logger.info("Registration form passed validation.");

        // check if users with same username or email exist
        List<User> existingUsers = userService.findByUsernameOrEmail(newUser.getUsername(), newUser.getEmail());
        if(!Objects.isNull(existingUsers) && !existingUsers.isEmpty()) {
            logger.info("Existing users found: " + existingUsers.size());
            newUser = UserRegistration.getNewUserWithEmptyAlreadyUsedFields(newUser, existingUsers);
            model.addAttribute("newUser", newUser);
            model.addAttribute("registrationError", determineRegistrationErrorMessage(newUser));
            logger.info("Returning filled registration form with no password and username or email." + newUser.toString());
            return "registration-form";
        }

        logger.info("New user does not already exist.");
        userService.save(newUser);
        logger.info("Successfully created user: " + newUser.getUsername());

        return "registration-confirmation";
    }


    private String determineRegistrationErrorMessage(UserRegistration userRegistration) {
        String username = userRegistration.getUsername();
        String email = userRegistration.getEmail();

        if(username.isEmpty() && email.isEmpty()) {
            return "Username and email are already used.";
        }
        if(username.isEmpty()) {
            return "Username is already used.";
        }
        if(email.isEmpty()) {
            return "Email is already used.";
        }
        throw new IllegalStateException("Username or email where supposed to have empty value for user" +
                " that tries to register with already used username or email. Non empty username or email found instead.");
    }
}
