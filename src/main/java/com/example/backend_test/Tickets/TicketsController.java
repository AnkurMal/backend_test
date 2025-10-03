package com.example.backend_test.Tickets;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketsController {
    @Autowired
    private TicketsRepository ticketsRepository;

    @GetMapping("/tickets")
    public Tickets getTickets(@RequestParam String username) {
        return ticketsRepository.findByUsername(username);
    }

    @PostMapping("/update")
    public Map<String, Object> getMethodName(@RequestBody Tickets newTicket) {
        Tickets existing = ticketsRepository.findByUsername(newTicket.getUsername());
        newTicket.setId(existing.getId());
        ticketsRepository.save(newTicket);

        return Map.of("success", true);
    }

}
