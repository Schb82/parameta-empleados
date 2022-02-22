package com.parameta.empleado.DTOs;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class BirthdateValidator  implements ConstraintValidator<birthdateConstraint, Date> {

    @Override
    public void initialize(birthdateConstraint contactNumber) {
    }

    @Override
    public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext constraintValidatorContext) {

        Calendar dateInCalendar = Calendar.getInstance();
        dateInCalendar.setTime(valueToValidate);
        
        String value = valueToValidate.toString();

            return valueToValidate.toString() != null //&& valueToValidate.toString().matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$")
                    && Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) >= 18;

    }


}
