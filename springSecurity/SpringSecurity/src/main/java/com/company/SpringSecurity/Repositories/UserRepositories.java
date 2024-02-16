package com.company.SpringSecurity.Repositories;

import com.company.SpringSecurity.Module.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends MongoRepository<User,String> {

    User findByUserNameEquals(String username);
}
