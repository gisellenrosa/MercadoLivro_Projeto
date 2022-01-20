package com.mercadolivro.controllers.requests

import com.sun.istack.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest (
    @field:NotNull
    @field:Positive
    val custumerId : Long,

    @field:NotNull
    val bookIds : Set<Int>
)
