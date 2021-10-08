package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.services.BookService
import com.mercadolivro.services.CustomerServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
    val bookService: BookService,
    val customerServices : CustomerServices
){
    @PostMapping
    fun createBook(@RequestBody request : PostBookRequest){
        val customer =  customerServices.getCustomerById(request.customerId)
        bookService.create(request.toBookModel(customer))
   }
}