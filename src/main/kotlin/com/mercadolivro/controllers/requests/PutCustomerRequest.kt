package com.mercadolivro.controllers.requests

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest(
    @field:NotEmpty(message ="O nome precisa ser preenchido")
    var name: String,
    @field:Email(message="O email precisa ser válido!")
    var email: String
    )
