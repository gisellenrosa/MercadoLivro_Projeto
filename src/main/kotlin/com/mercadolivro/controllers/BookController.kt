package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.controllers.requests.PutBookRequest
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.model.BookModel
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
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerServices.findById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}