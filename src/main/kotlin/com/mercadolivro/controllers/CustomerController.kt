package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.extensions.toCustomerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.services.CustomerServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController ( val customerServices: CustomerServices) {

// Primeira forma sem PathParams
//    @GetMapping
//    fun getCustomer(): MutableList<CustomerModel> {
//       return customers
//    }

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
      return  customerServices.getAllCustomers(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postCustomer(@RequestBody customer: PostCustomerRequest ): String{
            customerServices.postCustomer(customer.toCustomerModel())
        return "Usuário Criado com Sucesso!"
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getCustomerById(@PathVariable id: Int): CustomerModel {
      return customerServices.getCustomerById(id)
    }

    @PutMapping("/{id}")
    fun putCustomerById(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest):String {
       customerServices.putCustomerById(customer.toCustomerModel(id))
        return "Usuário Alterado com Sucesso"

    }
    @DeleteMapping("/{id}")
    fun deleteCustomerById(@PathVariable id: Int):String {
        customerServices.deleteCustomerById(id)
        return "Usuário Deletado com Sucesso"

    }
}