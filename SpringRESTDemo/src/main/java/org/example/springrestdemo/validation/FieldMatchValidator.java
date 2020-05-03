package org.example.springrestdemo.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        try {
            final Object first = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
            final Object second = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);

            isValid = (Objects.isNull(first) && Objects.isNull(second))
                    || (!Objects.isNull(first) && first.equals(second));
        } catch (final Exception ignore) {

        }

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
