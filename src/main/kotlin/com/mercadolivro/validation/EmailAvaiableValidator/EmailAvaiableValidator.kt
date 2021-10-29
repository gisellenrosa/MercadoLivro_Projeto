package com.mercadolivro.validation.EmailAvaiableValidator

import com.mercadolivro.services.CustomerServices
import com.mercadolivro.validation.EmailAvaiable
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvaiableValidator(var customerServices: CustomerServices): ConstraintValidator<EmailAvaiable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }
        return customerServices.emailAvaiable(value)
    }


}
