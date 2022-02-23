package com.consultec.MyServerApplicantTestApplication.demo;

import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;
import com.consultec.MyServerApplicantTestApplication.demo.Repository.CustomerRepository;
import com.consultec.MyServerApplicantTestApplication.demo.Repository.Enum.Status;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTestRepo {

    @Autowired
    CustomerRepository customerRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void getListOfEmployeesTest(){

        List<Customer> customers = customerRepository.findAll();

        Assertions.assertThat(customers.size()).isGreaterThan(0);

    }
    @Test
    @Order(2)
    @Rollback(value = false)
    public void getById(){

        Customer customer = customerRepository.findById(1L).get();

        if(customer.getId() > 0){
            Assertions.assertThat(customer.getId() > 0);
        }
    }
    @Test
    @Order(3)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Customer customer = customerRepository.findById(1L).get();

        customerRepository.delete(customer);

        Optional<List<Customer>> optionalCustomer = customerRepository.findByUserNameOrStatus("hackblack");



        if(optionalCustomer.isPresent()){
            optionalCustomer.get();
        }

        Assertions.assertThat(optionalCustomer.get().size()).isEqualTo(0);
    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void SearchByUsernameOrStatus(){

        Optional<List<Customer>> optionalEmployee = customerRepository.findByUserNameOrStatus("hackblack");

        if(optionalEmployee.isPresent()){
            Assertions.assertThat(optionalEmployee).isNotEmpty();
        }

    }


    @Test
    @Order(5)
    @Rollback(value = false)
    public void saveEmployeeTest(){


        Customer employee = Customer.builder()
               // .id(1L) descomentar para realizar update del id deseado.
                .name("Aliko")
                .lastName("Dangote")
                .userName("home")
                .password("asdsad")
                .email("ramesh@gmail.com")
                .address("villamella")
                .dateCreated(LocalDate.of(2020,02,19))
                .status(Status.ENABLED)
                .build();

        customerRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

}
