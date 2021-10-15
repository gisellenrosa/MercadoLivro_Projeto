package com.mercadolivro.services

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerServices(val customerRepository: CustomerRepository, val bookService: BookService) {
    val customers = mutableListOf<CustomerModel>()

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return  customerRepository.findByNameContaining(it)
            //ignorecase true vai ignorar letras maiusculas ou minusculas na aplicação
        }
        return customerRepository.findAll().toList() // pq é uma mutableList
    }

    fun postCustomer(customer: CustomerModel){
      customerRepository.save(customer) // customer chamando DB
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun putCustomerById( customer: CustomerModel) {
      if (!customerRepository.existsById(customer.id!!)) {
          throw Exception()
      }
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)){
            throw java.lang.Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO

        customerRepository.save(customer)
    }


}