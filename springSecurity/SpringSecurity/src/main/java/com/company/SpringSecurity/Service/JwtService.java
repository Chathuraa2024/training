package com.company.SpringSecurity.Service;

import com.company.SpringSecurity.JwtUtil;
import com.company.SpringSecurity.Module.Role;
import com.company.SpringSecurity.Module.User;
import com.company.SpringSecurity.Repositories.UserRepositories;
import com.company.SpringSecurity.dto.RequestDto.loginRequest;
import com.company.SpringSecurity.dto.ResponseDto.loginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepositories.findByUserNameEquals(username);
       if(user != null){
           return new org.springframework.security.core.userdetails.User(
                   user.getUserName(),
                   user.getPassword(),
                   getAuthority(user)
           );
       }else{
           throw new UsernameNotFoundException("user not found" + username);
       }

    }
//simplegrantedAuthoirty -- authorities set
    private Set getAuthority(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoles()));
        });

        return authorities;

    }

    public loginResponse loginpage(loginRequest loginUser) throws Exception{
        String userName = loginUser.getUsername();
        String userPassword = loginUser.getUserPassword();

        authenticate(userName,userPassword);
        UserDetails userDetails = loadUserByUsername(userName);
        String newgenarated = jwtUtil.generateToken(userDetails);
        Optional<User> user = userRepositories.findById(userName);

        loginResponse logUser = new loginResponse(user,newgenarated);
        return logUser;

    }
    private void authenticate(String userName,String userPassword) throws  Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));

        }catch (BadCredentialsException e){
            throw new Exception(e.getMessage());
        }
    }
}
