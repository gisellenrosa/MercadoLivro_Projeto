package com.mercadolivro.services

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerServices(val customerRepository: CustomerRepository) {
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

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun putCustomerById( customer: CustomerModel) {
      if (!customerRepository.existsById(customer.id!!)) {
          throw Exception()
      }
        customerRepository.save(customer)
    }

    fun deleteCustomerById(id: Int) {
        customers.removeIf { it.id == id }
    }


}