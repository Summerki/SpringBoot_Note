package com.suki.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emplyee {
    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;
}
