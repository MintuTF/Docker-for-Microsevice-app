package edu.miu.authserver.repository;


import edu.miu.authserver.model.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess,Long> {
     UserAccess findUserAccessByUsername(String name);
     UserAccess findUserAccessByPassword(String password);
     UserAccess findUserAccessByEmail(String email);

}
