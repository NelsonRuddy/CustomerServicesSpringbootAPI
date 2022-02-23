package com.consultec.MyServerApplicantTestApplication.demo.Services;

import com.consultec.MyServerApplicantTestApplication.demo.DTO.CustomerDTO;
import com.consultec.MyServerApplicantTestApplication.demo.DTO.CustomerMapper;
import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;
import com.consultec.MyServerApplicantTestApplication.demo.Repository.CustomerRepository;
import com.consultec.MyServerApplicantTestApplication.demo.Repository.Icustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerImpl implements Icustomer {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    //getting all records
    @Override
    public List<CustomerDTO> getAllCustomer(){

        List<Customer> customers = customerRepository.findAll();

        return customerMapper.toCustomerDTOs(customers);

    }

    //getting a specific record
    @Override
    public CustomerDTO getCustomerById(Long id){

        Optional <Customer> customer = customerRepository.findById(id);

        return  customerMapper.toCustomerDTO(customer.get());

    }
   //method to search a record by username or status
   @Override
    public Optional<List<Customer>> findByuserNameOrStatus(String search){

        return customerRepository.findByUserNameOrStatus(search);

    }
   //saving or updating a record
   @Override
    public void saveOrUpdate(Customer customer)
    {
        customerRepository.save(customer);
    }

    //deleting a specific record
    @Override
    public void delete(Long id)
    {
        customerRepository.deleteById(id);
    }

}
