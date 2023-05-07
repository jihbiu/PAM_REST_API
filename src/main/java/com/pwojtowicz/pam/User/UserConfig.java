package com.pwojtowicz.pam.User;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;


@Configuration
@Order(1)
public class UserConfig {

    private final UserRepository userRepository;

    @Autowired
    public UserConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initializeUsers() {
        List<User> users = List.of(
                new User("Jan", "Kowalski", "jankowalski@example.com"),
                new User("Anna", "Nowak", "annanowak@example.com"),
                new User("Adam", "Kaczmarek", "adamkaczmarek@example.com"),
                new User("Ewa", "Marczak", "ewamarczak@example.com"),
                new User("Michał", "Wójcik", "michalwojcik@example.com")
        );

        userRepository.saveAll(users);

        List<User> userinion = userRepository.findAll();

    }

}
