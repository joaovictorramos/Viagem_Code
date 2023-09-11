package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Passenger;
import com.example.demo.repository.RepositoryPassenger;

@Service
public class ServicePassenger {
    @Autowired
    private RepositoryPassenger repositoryPassenger;

    public Passenger save(Passenger passenger){
        return repositoryPassenger.save(passenger);
    }

    public Passenger findByEmailPassengerAndPasswordPassenger(String emailPassenger, String passwordPassenger){
        return repositoryPassenger.findByEmailPassengerAndPasswordPassenger(emailPassenger, passwordPassenger);
    }
}