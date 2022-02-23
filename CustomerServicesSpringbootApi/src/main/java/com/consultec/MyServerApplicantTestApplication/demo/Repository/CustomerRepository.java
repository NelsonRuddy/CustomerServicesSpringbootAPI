package com.consultec.MyServerApplicantTestApplication.demo.Repository;

import com.consultec.MyServerApplicantTestApplication.demo.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //query to search a record by username or status
    @Query("select c from Customer c where c.userName LIKE :search% or c.status LIKE :search%")
    Optional<List<Customer>> findByUserNameOrStatus(@Param("search") String search);

}
