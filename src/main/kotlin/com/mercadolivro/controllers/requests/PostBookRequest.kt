package com.mercadolivro.controllers.requests

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

class PostBookRequest (
    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int,
) {

}