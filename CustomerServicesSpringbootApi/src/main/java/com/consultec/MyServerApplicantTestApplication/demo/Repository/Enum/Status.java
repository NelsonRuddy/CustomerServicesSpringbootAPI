package com.consultec.MyServerApplicantTestApplication.demo.Repository.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Status {
    ENABLED("ENABLED"), DISABLED("DISABLED");
    private final String name;
}
