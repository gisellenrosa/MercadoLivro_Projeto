package com.mercadolivro.enums

enum class Errors(val code: String, val message: String) {

    ML001("ML-001", "Invalid Request"),

    ML1001("ML-1001", "Book [%s] not exists"),
    ML1002("ML-1002", "Customer [%s] not exists"),


}