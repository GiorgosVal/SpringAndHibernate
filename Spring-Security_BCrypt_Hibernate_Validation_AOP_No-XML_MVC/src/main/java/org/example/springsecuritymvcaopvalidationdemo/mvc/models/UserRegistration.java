package org.example.springsecuritymvcaopvalidationdemo.mvc.models;

import lombok.Getter;
import lombok.Setter;
import org.example.springsecuritymvcaopvalidationdemo.validation.Email;
import org.example.springsecuritymvcaopvalidationdemo.validation.FieldMatch;
import org.example.springsecuritymvcaopvalidationdemo.validation.Password;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "The password fields must match."),
        @FieldMatch(first = "email", second = "emailConfirmation", message = "The email fields must match.")
})
public class UserRegistration {

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
}
