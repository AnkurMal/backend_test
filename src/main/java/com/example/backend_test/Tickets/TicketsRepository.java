package com.example.backend_test.Tickets;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TicketsRepository extends MongoRepository<Tickets, String> {
    Tickets findByUsername(String username);
}
