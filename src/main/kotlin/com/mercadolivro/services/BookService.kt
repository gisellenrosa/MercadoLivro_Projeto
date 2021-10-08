package com.mercadolivro.services

import com.mercadolivro.model.BookModel
import com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun create(book: BookModel) {
    bookRepository.save(book)
    }

}
