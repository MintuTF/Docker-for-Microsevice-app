package edu.miu.authserver.util.payload.response;


import edu.miu.authserver.util.userdetails.UserDetailsimp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
    private String password;


	public JwtResponse(String accessToken,UserDetailsimp detailsimp ) {
		this.token = accessToken;
		this.username=detailsimp.getUsername();
		this.password=detailsimp.getPassword();

	}


}
