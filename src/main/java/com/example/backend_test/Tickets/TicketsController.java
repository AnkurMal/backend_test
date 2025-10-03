package com.example.backend_test.Tickets;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketsController {
    @Autowired
    private TicketsRepository ticketsRepository;

    @GetMapping("/tickets")
	public Tickets getTickets(@RequestBody Map<String, String> body) {
		return ticketsRepository.findByUsername(body.get("username"));
	}
}
