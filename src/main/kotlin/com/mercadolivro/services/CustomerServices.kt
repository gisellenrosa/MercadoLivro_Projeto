package com.mercadolivro.services

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service


@Service
class CustomerServices {
    val customers = mutableListOf<CustomerModel>()

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return  customers.filter { it.name.contains(name, ignoreCase = true) }

            //ignorecase true vai ignorar letras maiusculas ou minusculas na aplicação
        }
        return customers
    }

    fun postCustomer(customer: CustomerModel){

        val id = if(customers.isEmpty()){
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()
        customers.add(customer)
    }

    fun getCustomerById(id: String): CustomerModel {
        return customers.filter{ it.id == id }.first()
        // se o it.id ( id do elemento/registro for igual ao id do PathVariable então pega ele
    }

    fun putCustomerById( customer: CustomerModel) {
        customers.filter{ it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email


        }
    }

    fun deleteCustomerById(id: String) {
        customers.removeIf { it.id == id }
    }


}