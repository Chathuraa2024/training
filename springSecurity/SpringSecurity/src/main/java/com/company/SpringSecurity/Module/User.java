package com.company.SpringSecurity.Module;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "user")
public class User {
    @Id
    private String userName;
    private String firstName;
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();
}
