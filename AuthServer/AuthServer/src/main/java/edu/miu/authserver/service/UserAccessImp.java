package edu.miu.authserver.service;


import edu.miu.authserver.model.ERole;
import edu.miu.authserver.model.Role;
import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.repository.UserAccessRepository;
import edu.miu.authserver.util.DTO.RoleAdapter;
import edu.miu.authserver.util.DTO.UserAccessAdapter;
import edu.miu.authserver.util.payload.LoginRequest;
import edu.miu.authserver.util.payload.SignupRequest;
import edu.miu.authserver.util.payload.response.JwtResponse;
import edu.miu.authserver.util.payload.response.PersonResponse;
import edu.miu.authserver.util.payload.response.UserAccessResponse;
import edu.miu.authserver.util.security.jwt.JwtUtils;
import edu.miu.authserver.util.userdetails.UserDetailsimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserAccessImp implements UserAccessService {
      @Autowired
      private UserAccessRepository userAccessRepository;
      @Autowired
      private UserRoleService userRoleService;
     @Autowired
      private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
   private JwtUtils jwtUtils;

    @Override
    public UserAccessResponse createUser(SignupRequest signupRequest) {
       // Set<Role> roles= RoleAdapter.converTORolesSet(signupRequest);


        UserAccess userAccess=
                new UserAccess(signupRequest.getUsername(),
                        signupRequest.getName(),encoder.encode(signupRequest.getPassword()), signupRequest.getEmail());
        Role role=userRoleService.findRoleByName
                (RoleAdapter.convertEnumTOString
                        (signupRequest)).get();
     //   role.addPerson(userAccess);

       // userAccess.addRoles(role);
      UserAccess person=   userAccessRepository.save(userAccess);
      //  return new UserAccessResponse(saved.getId(),userAccess.getUsername(), userAccess.getName(), userAccess.getPassword(), userAccess.getEmail());
        UserAccessResponse personResponse=new UserAccessResponse(person.getId(), person.getUsername(), person.getName(), person.getPassword(),
               person.getEmail() );
        return personResponse;
    }

    @Override
    public JwtResponse loginUser(LoginRequest loginRequest) {

        System.out.println("user");

        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        System.out.println(authentication);
        // set to the context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //get current user or principal
        UserDetailsimp userDetailsimp=(UserDetailsimp) authentication.getPrincipal();
        System.out.println(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);


        List<String> roles = userDetailsimp.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        JwtResponse jwtResponse=  new JwtResponse(jwt,userDetailsimp);
        return jwtResponse;

    }

    @Override
    public void deleteUser(UserAccess userAccess) {
          userAccessRepository.delete(userAccess);
    }

    @Override
    public UserAccess updateUser(UserAccess userAccess) {
        return null;
    }
}
