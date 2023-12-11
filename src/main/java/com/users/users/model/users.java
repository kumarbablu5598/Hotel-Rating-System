package com.users.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "userservice")
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
    int age;
    String emailId;
    String userName;
    @Transient
    List<Rating> ratings = new ArrayList<Rating>();

}
