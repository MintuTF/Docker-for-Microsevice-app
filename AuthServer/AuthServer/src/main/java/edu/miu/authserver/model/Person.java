package edu.miu.authserver.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Person {

    private long id;
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;

    private Set<Role> roles= new HashSet<>();

    private Address address;

    public Person(String username, String password,
                  String status, String firstName,
                  String lastName, String email, Address address) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address=address;


    }



}
