package edu.miu.authserver.service;



import edu.miu.authserver.model.ERole;
import edu.miu.authserver.model.Role;
import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.repository.UserRoleRepository;
import edu.miu.authserver.util.payload.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserRoleService {
      @Autowired
      public UserRoleRepository roleRepository;

      public Role saveRole(Role role) {
            return  roleRepository.save(role);
      }

      public Optional<Role> findRoleByName(ERole name)
      {
            return  roleRepository.findByName(name);
      }

}
