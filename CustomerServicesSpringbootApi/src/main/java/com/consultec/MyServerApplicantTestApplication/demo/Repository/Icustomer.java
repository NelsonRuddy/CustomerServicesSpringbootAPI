package com.consultec.MyServerApplicantTestApplication.demo.Repository;

import com.consultec.MyServerApplicantTestApplication.demo.DTO.CustomerDTO;
import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;

import java.util.List;
import java.util.Optional;

public interface Icustomer {

    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    Optional<List<Customer>> findByuserNameOrStatus(String search);
    void saveOrUpdate(Customer customer);
    void delete(Long id);

}
