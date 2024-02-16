package com.company.SpringSecurity.Service;

import com.company.SpringSecurity.Module.Role;
import com.company.SpringSecurity.Module.User;
import com.company.SpringSecurity.Repositories.RoleRepository;
import com.company.SpringSecurity.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepositories userRepositories;



    public ResponseEntity<String> userRegister(User user) {
        ResponseEntity<String> response = null;
        try{
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            userRepositories.save(user);
            if(userRepositories.existsById(user.getUserName())){
                response = ResponseEntity.status(HttpStatus.CREATED).body("Success for register");
            }
        }catch (Exception e){
            response= ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return response;
    }


//    public String addUser(User user) {
//        if(userRepositories.existsById(user.getUserId())){
//            user.setPassword(encode.encode(user.getPassword()));
//            userRepositories.save(user);
//            return "success";
//        }else {
//            throw new RuntimeException("user in database");
//        }
//    }

    public void initRoleAndUser(){
        Role adminRole = new Role();
        Role userRole = new Role();
        if (!roleRepository.existsById("Admin")){
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("ADMIN");
            roleRepository.save(adminRole);
        }
        if (!roleRepository.existsById("User")){
            userRole.setRoleName("User");
            userRole.setRoleDescription("USER");
            roleRepository.save(userRole);
        }
        User user = new User();
        if(!userRepositories.existsById("admin1")){

            user.setUserName("admin1");
            user.setFirstName("kamal");
            user.setPassword(passwordEncoder.encode("12345"));
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            user.setRoles(adminRoles);
            userRepositories.save(user);
        }
        if(!userRepositories.existsById("user1")){

            user.setUserName("user1");
            user.setFirstName("sachin");
            user.setPassword(passwordEncoder.encode("246910"));
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);
            user.setRoles(user.getRoles());
            userRepositories.save(user);
        }


    }
}