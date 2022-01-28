package com.mercadolivro.controllers.requests

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class PostBookRequest (
    @field:NotEmpty(message= "O nome precisa ser preenchido")
    var name: String,
    @field:NotNull(message ="o valor de preço precisa ser informado")
    var price: BigDecimal,

    @field:NotNull(message ="o customer precisa ser informado")
    @JsonAlias("customer_id")
    var customerId: Int
)