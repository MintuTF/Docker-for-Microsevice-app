package edu.miu.authserver.util.payload;

//import javax.validation.constraints.*;
import edu.miu.authserver.model.Address;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
//    @NotBlank
//    @Size(min = 3, max = 20)
    private String username;
 
//    @NotBlank
//    @Size(max = 50)
//    @Email
    private String email;
    
    private Set<String> roles;
    
//    @NotBlank
//    @Size(min = 6, max = 40)
    private String password;

    private String name;

    private Address address;

    private String status;
    private String firstName;
    private String lastName;


  

}
