package edu.miu.authserver.util.userdetails;



import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.repository.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceimp implements UserDetailsService {

    @Autowired
    private UserAccessRepository userAccessRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess user=userAccessRepository.findUserAccessByUsername(username);


        if(user==null)
            throw new UsernameNotFoundException("user not found with username:"+username);

        return UserDetailsimp.build(user);
    }
}
