package com.mercadolivro.controllers.requests

import com.mercadolivro.validation.EmailAvaiable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Nome deve ser informado!")
    var name: String,
    @field:Email(message = "Email deve ser valido")
    @EmailAvaiable
    var email: String
    )