package org.example.springrestdemo.mvc.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.springrestdemo.validation.Email;
import org.example.springrestdemo.validation.FieldMatch;
import org.example.springrestdemo.validation.Password;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@ToString
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "The password fields must match."),
        @FieldMatch(first = "email", second = "emailConfirmation", message = "The email fields must match.")
})
public class UserRegistration {

    private static Logger logger = Logger.getLogger(org.example.springrestdemo.mvc.models.UserRegistration.class.getSimpleName());

    @NotNull(message = "required field")
    @Pattern(regexp = "^[a-zA-Z0-9_]{2,50}$", message = "Invalid username. Valid characters are letters, numbers and underscore (_).")
    private String username;

    @NotNull(message = "required field")
    @Password
    private String password;

    @NotNull(message = "required field")
    @Password
    private String passwordConfirmation;

    @NotNull(message = "required field")
    @Pattern(regexp = "^[a-zA-Z]{2,50}$", message = "invalid name")
    private String firstName;

    @NotNull(message = "required field")
    @Pattern(regexp = "^[a-zA-Z]{2,50}$", message = "invalid name")
    private String lastName;

    @NotNull(message = "required field")
    @Email
    private String email;

    @NotNull(message = "required field")
    @Email
    private String emailConfirmation;

    public UserRegistration() {
    }

    public static org.example.springrestdemo.mvc.models.UserRegistration getUserRegistrationWithNoPassword(org.example.springrestdemo.mvc.models.UserRegistration userRegistration) {
        userRegistration.setPassword("");
        userRegistration.setPasswordConfirmation("");
        return userRegistration;
    }

    public static org.example.springrestdemo.mvc.models.UserRegistration getUserRegistrationWithNoPasswordAndUsername(org.example.springrestdemo.mvc.models.UserRegistration userRegistration) {
        userRegistration.setUsername("");
        userRegistration.setPassword("");
        userRegistration.setPasswordConfirmation("");
        return userRegistration;
    }

    public static org.example.springrestdemo.mvc.models.UserRegistration getUserRegistrationWithNoPasswordAndEmail(org.example.springrestdemo.mvc.models.UserRegistration userRegistration) {
        userRegistration.setEmail("");
        userRegistration.setEmailConfirmation("");
        userRegistration.setPassword("");
        userRegistration.setPasswordConfirmation("");
        return userRegistration;
    }

    public static org.example.springrestdemo.mvc.models.UserRegistration getNewUserWithEmptyAlreadyUsedFields(org.example.springrestdemo.mvc.models.UserRegistration newUser, List<User> existingUsers) {
        for(User existingUser : existingUsers) {
            if(newUser.getUsername().equals(existingUser.getUsername())) {
                logger.info("Username is already used.");
                newUser.setUsername("");
            }
            if(newUser.getEmail().equals(existingUser.getEmail())) {
                logger.info("Email is already used.");
                newUser.setEmail("");
                newUser.setEmailConfirmation("");
            }
            newUser.setPassword("");
            newUser.setPasswordConfirmation("");
        }
        return newUser;
    }
}
