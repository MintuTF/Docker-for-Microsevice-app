package edu.miu.authserver.util.DTO;

import edu.miu.authserver.model.Role;
import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.repository.UserAccessRepository;
import edu.miu.authserver.service.UserRoleService;
import edu.miu.authserver.util.payload.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public class UserAccessAdapter {
    @Autowired
    private static  UserAccessRepository userAccessRepository;
    @Autowired
    private static  UserRoleService userRoleService;
    @Autowired
    private static PasswordEncoder encoder;
 //   public static UserAccess CleanSignUpData(SignupRequest signupRequest){
//        System.out.println("clean data 09");
//        Set<Role> roles=RoleAdapter.converTORolesSet(signupRequest);
//        System.out.println("clean data 09");
//        UserAccess userAccess=
//                new UserAccess(signupRequest.getUsername(),
//                        signupRequest.getName(),encoder.encode(signupRequest.getPassword()), signupRequest.getEmail());
//        System.out.println("clean data 09");
//        for(Role role:roles){
//            System.out.println("clean data loop");
//            role.addPerson(userAccess);
//             userAccess.addRoles(role);
//            System.out.println("clean data loop1");
//        }
//
//        System.out.println("clean data 02");
//        return userAccess;
 //   }
}
