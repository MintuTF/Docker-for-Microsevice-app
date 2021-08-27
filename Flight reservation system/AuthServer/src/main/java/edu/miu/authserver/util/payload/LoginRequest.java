package edu.miu.authserver.util.payload;


import lombok.Data;

@Data
public class LoginRequest {

	private String username;
	private String password;


}
