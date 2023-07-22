package com.narentech.kafkaservice.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Slf4j
@Getter
@Setter
@ToString
public class Employee implements Serializable {

    private  Long id;

    private static Long counter = 100L;
    @NotBlank(message = "Name Cannot be Empty!!")
    private String name;
    @NotBlank(message = "email Cannot be Empty!!")
    private String email;
    @NotBlank(message = "phoneNo Cannot be Empty!!")
    private String phoneNo;
    @NotBlank(message = "Dept Cannot be Empty!!")
    private String deptName;

    public Long getId() {
        return counter++;
    }
}
