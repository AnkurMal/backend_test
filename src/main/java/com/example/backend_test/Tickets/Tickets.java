package com.example.backend_test.Tickets;

import java.util.List;

import org.bson.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@org.springframework.data.mongodb.core.mapping.Document("tickets")
@Data
public class Tickets {
    @Id
    private String id;
    private String username;
    private List<Document> messages;

    public Tickets(String username, List<Document> messages) {
        this.username = username;
        this.messages = messages;
    }

}
