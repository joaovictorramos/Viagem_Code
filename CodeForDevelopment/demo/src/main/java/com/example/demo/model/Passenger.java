package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idPassenger;

    @Email
    @NotBlank(message = "O email é obrigatório")
    @Column(unique = true, nullable = false)
    private String emailPassenger;

    @Size(min = 4)
    @NotBlank(message = "A senha é obrigatória")
    private String passwordPassenger;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastname;

    @Column(unique = true)
    private Long cpfPassenger;

    @Column(unique = true)
    private Long rgPassenger;

    @Column(nullable = true)
    private Long phonePassenger;

    @Column(nullable = true)
    private String profession;

    @Column(nullable = true)
    private String nationality;

    @Column(nullable = true)
    private String sex;

    @Column(nullable = true)
    private LocalDateTime registrationDate;

    @Column(nullable = true)
    private LocalDate birthDate;
}
