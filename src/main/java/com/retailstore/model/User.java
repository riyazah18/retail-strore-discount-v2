package com.retailstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor // JPA requires a no-arg constructor
@AllArgsConstructor // Optional: for Lombok to generate an all-args constructor
@Builder // For builder pattern
@Table(name = "user_table") // Specify a different table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private UserType userType;
    private LocalDate joiningDate;
}
