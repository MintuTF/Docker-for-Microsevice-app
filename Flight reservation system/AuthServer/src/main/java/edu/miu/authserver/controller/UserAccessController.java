package edu.miu.authserver.controller;



import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.service.UserAccessService;
import edu.miu.authserver.util.payload.LoginRequest;
import edu.miu.authserver.util.payload.SignupRequest;
import edu.miu.authserver.util.payload.response.JwtResponse;
import edu.miu.authserver.util.payload.response.UserAccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@Transactional
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;



    @PostMapping ("signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequest user) {

        System.out.println("======here");
        ResponseEntity<?> responseEntity=null;
        try {
            JwtResponse jwtResponse=userAccessService.loginUser(user);
            responseEntity =new ResponseEntity<>(jwtResponse, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;

    }


    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {

        ResponseEntity<?> responseEntity=null;
        try {

            UserAccessResponse getUser = userAccessService.createUser(signupRequest);
            if (getUser != null) {

                        responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @GetMapping("signup/test")
    public ResponseEntity<?> test() {

        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

}
