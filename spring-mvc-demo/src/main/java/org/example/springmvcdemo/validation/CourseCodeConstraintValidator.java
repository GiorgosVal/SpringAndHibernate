package org.example.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String[] courseCodes;

   /**
    * This method is called during the initialisation of the validator.
    *
    * @param constraint the value of the annotation (default is GIO)
    */
   public void initialize(CourseCode constraint) {
      courseCodes = constraint.value();
   }

   /**
    * Spring will call this method to validate the property. Here we write our validation business logic.
    *
    * @param obj the actual Form Data entered by the user
    * @param context to give additional error messages
    * @return
    */
   public boolean isValid(String obj, ConstraintValidatorContext context) {

      boolean result = false;

      if (!Objects.isNull(obj) && !obj.isEmpty()) {
         for (String code : courseCodes) {
            if (obj.toUpperCase().startsWith(code)) {
               result = true;
               break;
            }
         }
      }

      return result;
   }
}
