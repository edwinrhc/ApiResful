package org.erhc.app.validation;

import org.erhc.app.Entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null,"Es requerido");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", null, "Es requerido, por favor");
        }

        if(product.getPrice()== null){
            errors.rejectValue("price", null,"No puede ser nulo,OK");
        }else if(product.getPrice()< 500){
            errors.rejectValue("price", null,"Debe ser un valor numerico mayor o igual a 500");
        }
    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
