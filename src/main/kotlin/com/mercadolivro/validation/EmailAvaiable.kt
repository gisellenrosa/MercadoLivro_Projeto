package com.mercadolivro.validation

import com.mercadolivro.validation.EmailAvaiableValidator.EmailAvaiableValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailAvaiableValidator::class])
@Target(AnnotationTarget.FIELD)
annotation class EmailAvaiable(
    val message: String = "Email já cadastrado",
    val groups: Array<KClass<*>> =[],
    val payload: Array<KClass<out Payload>> = [] ,
)
