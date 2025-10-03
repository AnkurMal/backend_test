package com.example.backend_test.Credentials;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentialsRepository extends MongoRepository<Credentials, String> {
    Credentials findByUsername(String username);
}