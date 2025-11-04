package com.example.vtibedtn2506_usermanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private Date birthday;
    private String address;
}
