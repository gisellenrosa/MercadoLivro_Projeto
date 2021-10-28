package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.controllers.response.CustomerResponse
import com.mercadolivro.extensions.toCustomerModel
import com.mercadolivro.extensions.toResponse
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.services.CustomerServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController ( val customerServices: CustomerServices) {

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
      return  customerServices.getAllCustomers(name).map { it.toResponse()}
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postCustomer(@RequestBody customer: PostCustomerRequest ): String{
            customerServices.postCustomer(customer.toCustomerModel())
        return "Usuário Criado com Sucesso!"
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getCustomerById(@PathVariable id: Int): CustomerResponse {
      return customerServices.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerServices.findById(id)
        customerServices.update(customer.toCustomerModel(customerSaved))
    }
    @DeleteMapping("/{id}")
    fun deleteCustomerById(@PathVariable id: Int):String {
        customerServices.delete(id)
        return "Usuário Deletado com Sucesso"

    }
}