package com.mercadolivro.controllers.mapper

import com.mercadolivro.controllers.requests.PostPurchaseRequest
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.services.BookService
import com.mercadolivro.services.CustomerServices
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerServices
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }

}