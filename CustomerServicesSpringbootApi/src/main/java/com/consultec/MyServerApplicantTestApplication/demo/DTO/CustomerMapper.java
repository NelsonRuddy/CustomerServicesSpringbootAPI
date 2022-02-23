package com.consultec.MyServerApplicantTestApplication.demo.DTO;

import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    Customer toCustomer(CustomerDTO customerDTO);

    CustomerDTO toCustomerDTO(Customer customerDTO);


}