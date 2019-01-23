package com.ztbd.repositories_mongodb;

import com.ztbd.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserNoSQLRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}