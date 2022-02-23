package com.consultec.MyServerApplicantTestApplication.demo.DTO;


import com.consultec.MyServerApplicantTestApplication.demo.Repository.Enum.Status;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class CustomerDTO implements Serializable {


    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String address;
    private LocalDate dateCreated;
    private Status status;

}
