package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DtoPassenger {
    @Email
    @NotBlank(message = "O email não pode ser vazio")
    @Column(unique = true, nullable = false)
    private String emailPassenger;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 4)
    private String passwordPassenger;
}
