package edu.miu.authserver.util.DTO;

import edu.miu.authserver.model.ERole;
import edu.miu.authserver.model.Role;
import edu.miu.authserver.repository.UserRoleRepository;
import edu.miu.authserver.util.payload.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


public class RoleAdapter {
    @Autowired
    public static UserRoleRepository roleRepository;

    private  static final String ADMIN="ADMIN";
    private  static final String AGENT="AGENT";
   private  static final String  PASSANGER="PASSANGER";

    public static ERole convertEnumTOString(SignupRequest signupRequest) {
        Set<String> strRoles = signupRequest.getRoles();
        if (strRoles.contains( ADMIN)) {
            return ERole.ADMIN;
        }
        if (strRoles.contains(AGENT)) {
            return ERole.AGENT;
        }
        return ERole.PASSANGER;


    }

    public static Set<Role> converTORolesSet(SignupRequest signupRequest) {
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        System.out.println("clean data 09");
        if(strRoles.contains(ADMIN)) {
            Role adminRole = roleRepository.findByName(ERole.ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 //           Role adminRole =new Role(ERole.ADMIN);
            roles.add(adminRole);
        }
        if(strRoles.contains(AGENT)){
                        Role userRole = roleRepository.findByName(ERole.AGENT)
                               .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          //  Role userRole =new Role(ERole.USER);
                        roles.add(userRole);

        }
        if(strRoles.contains(PASSANGER)){
            Role userRole = roleRepository.findByName(ERole.PASSANGER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            //  Role userRole =new Role(ERole.USER);
            roles.add(userRole);

        }

        return roles;
    }

}
