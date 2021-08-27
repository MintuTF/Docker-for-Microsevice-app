package edu.miu.authserver.util.payload.response;

import lombok.Data;

@Data
public class PersonResponse {
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private String role;
    private  String email;

    public PersonResponse(String username, String password, String status, String firstName,
                          String lastName, String role, String email) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }
}
