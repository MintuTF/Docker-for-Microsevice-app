package edu.miu.authserver.service;


import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.util.payload.LoginRequest;
import edu.miu.authserver.util.payload.SignupRequest;
import edu.miu.authserver.util.payload.response.JwtResponse;
import edu.miu.authserver.util.payload.response.UserAccessResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserAccessService {
    UserAccessResponse createUser(SignupRequest signupRequest);
    JwtResponse loginUser(LoginRequest loginRequest);
    void deleteUser(UserAccess userAccess);
    UserAccess updateUser(UserAccess userAccess);
}
