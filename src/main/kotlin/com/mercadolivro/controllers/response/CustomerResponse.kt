package com.mercadolivro.controllers.response

import com.mercadolivro.enums.CustomerStatus
import javax.persistence.*

class CustomerResponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
