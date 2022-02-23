package com.consultec.MyServerApplicantTestApplication.demo.Controllers;

import com.consultec.MyServerApplicantTestApplication.demo.DTO.CustomerDTO;
import com.consultec.MyServerApplicantTestApplication.demo.DTO.CustomerMapper;
import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;
import com.consultec.MyServerApplicantTestApplication.demo.Services.CustomerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerImpl customerImpl;


    private final CustomerMapper customerMapper;

    //Get all the customers
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    private List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> customers = customerImpl.getAllCustomer();
        return customers;
    }

    //Get a Customer by id
    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    private CustomerDTO getCustomer(@PathVariable("id") long id) {

        CustomerDTO customer = customerImpl.getCustomerById(id);

        return customer;
    }

    //Search custumer by username or status
    @GetMapping(value = "/buscar/{search}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<Customer>> findByNameOrStatus(@PathVariable("search") String search) {

        return customerImpl.findByuserNameOrStatus(search);
    }

    //Delete a customer
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    private void deleteCustomer(@PathVariable("id") long id) {

        customerImpl.delete(id);
    }

    //Save or update a Customer.
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    private CustomerDTO save(@RequestBody CustomerDTO customerDTO) {

        customerImpl.saveOrUpdate(customerMapper.toCustomer(customerDTO));

        return customerDTO;
    }

    //Save or update a Customer.
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    private CustomerDTO update(@RequestBody CustomerDTO customerDTO) {

        customerImpl.saveOrUpdate(customerMapper.toCustomer(customerDTO));

        return customerDTO;
    }
}