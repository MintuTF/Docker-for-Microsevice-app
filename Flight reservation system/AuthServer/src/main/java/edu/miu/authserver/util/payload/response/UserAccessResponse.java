package edu.miu.authserver.util.payload.response;

import lombok.Data;

@Data
public class UserAccessResponse {
    private long id;
    private String username;
    private String name;
    private String password;
    private String email;
  //  private String role;

    public UserAccessResponse(long id,String username, String name, String password, String email) {
        this.id=id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;

    }
}
