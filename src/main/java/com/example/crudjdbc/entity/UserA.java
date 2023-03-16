package com.example.crudjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
//@Table(name = "userA")
@NoArgsConstructor
@AllArgsConstructor
public class UserA {
    private int id;
    private String fname;
    private String lname;
    private String email;

}
