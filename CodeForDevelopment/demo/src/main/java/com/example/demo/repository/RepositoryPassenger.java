package com.example.demo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Passenger;

public interface RepositoryPassenger extends JpaRepository<Passenger, UUID>{
    Passenger findByEmailPassengerAndPasswordPassenger(String emailPassenger, String passowordPassenger);
}
