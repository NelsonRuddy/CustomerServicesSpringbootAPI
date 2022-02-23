package com.consultec.MyServerApplicantTestApplication.demo.Entities;

import com.consultec.MyServerApplicantTestApplication.demo.Repository.Enum.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Customer")
public class Customer {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "username")
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String address;
    @Column(name = "datecreated")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private Status status;



}
