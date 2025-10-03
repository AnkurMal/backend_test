package com.example.backend_test.Credentials;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_test.Tickets.Tickets;
import com.example.backend_test.Tickets.TicketsRepository;

@RestController
public class CredentialsController {
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private TicketsRepository ticketsRepository;

    @PostMapping("/login")
    public String loginUser(@RequestBody Credentials credentials) {
        var res = credentialsRepository.findByUsername(credentials.getUsername());

        if (res == null)
            return "{ \"username\": false }";
        else if (res.getPassword().equals(credentials.getPassword()))
            return "{ \"username\": true, \"password\": true }";
        else
            return "{ \"username\": true, \"password\": false }";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Credentials credentials) {
        var res = credentialsRepository.findByUsername(credentials.getUsername());

        if (res != null)
            return "{ \"success\": false }";
        else {
            Tickets tickets = new Tickets(credentials.getUsername(), new ArrayList<>());

            credentialsRepository.save(credentials);
            ticketsRepository.save(tickets);

            return "{ \"success\": true }";
        }
    }

}
