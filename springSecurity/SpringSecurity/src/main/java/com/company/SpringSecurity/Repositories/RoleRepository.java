package com.company.SpringSecurity.Repositories;

import com.company.SpringSecurity.Module.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {


}
