package org.example.springsecuritymvcaopvalidationdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private Pattern pattern;
    private Matcher matcher;
    private String message;

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[ !@#$%^&*()_=~\\[\\]{}|;:,.?])[A-Za-z\\d !@#$%^&*()_=~\\[\\]{}|;:,.?]{8,}$";

    @Override
    public void initialize(Password constraintAnnotation) {
        message = constraintAnnotation.message() + "Password must be at least 8 characters long and contain at least " +
                "1 lower case letter, 1 upper case letter, 1 number and 1 special character.";
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if(!Objects.isNull(password) && !password.isEmpty()) {
            pattern = Pattern.compile(PASSWORD_PATTERN);
            matcher = pattern.matcher(password);
            isValid = matcher.matches();
        }
        return isValid;
    }
}
