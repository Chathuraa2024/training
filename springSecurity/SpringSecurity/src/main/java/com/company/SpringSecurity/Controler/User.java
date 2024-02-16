package com.company.SpringSecurity.Controler;



import com.company.SpringSecurity.Repositories.UserRepositories;
import com.company.SpringSecurity.Service.JwtService;
import com.company.SpringSecurity.Service.UserServiceImpl;
import com.company.SpringSecurity.dto.RequestDto.loginRequest;
import com.company.SpringSecurity.dto.ResponseDto.loginResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/user-manage")
public class User {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepositories userRepositories;

   // @Autowired
//    private RoleRepository roleRepository;



    @PostMapping("login")
    public loginResponse loginUserAndCreateJwtToken(@RequestBody loginRequest loginUser) throws Exception{
        System.out.println(loginUser);
        return jwtService.loginpage(loginUser);
    }

//    @PostMapping("adduser")
//    public String addNewUser(@RequestBody com.company.SpringSecurity.Module.User user){
//        String msg = userService.addUser(user);
//        System.out.println(msg);
//        return msg;
//    }

    @PostMapping("register")
    public ResponseEntity<String> UserRegister(@RequestBody com.company.SpringSecurity.Module.User user){
        return userService.userRegister(user);
    }



    @PostConstruct
    public void userAndRole(){
        userService.initRoleAndUser();
    }

}
