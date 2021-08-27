package edu.miu.authserver.repository;



import edu.miu.authserver.model.ERole;
import edu.miu.authserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository

public interface UserRoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName(ERole name);
    Optional<Role> findByName(ERole name);
}
