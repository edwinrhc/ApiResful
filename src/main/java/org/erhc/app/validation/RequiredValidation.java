package org.erhc.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequiredValidation implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      /*  if(value != null && !value.isEmpty() && !value.isBlank()){
            return true;
        }
        return false;*/
        return StringUtils.hasText(value);
    }
}
