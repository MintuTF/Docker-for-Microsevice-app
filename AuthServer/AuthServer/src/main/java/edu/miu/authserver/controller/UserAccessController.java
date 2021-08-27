package edu.miu.authserver.controller;



import edu.miu.authserver.model.UserAccess;
import edu.miu.authserver.service.AuthService;
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

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")

public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    @Autowired
    private AuthService authService;



    @PostMapping ("/public/signin")
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


    @PostMapping("/public/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest,HttpServletRequest servletRequest) {

        ResponseEntity<?> responseEntity=null;
        try {

            responseEntity =authService.createPerson(signupRequest,servletRequest);

                      //  responseEntity=new ResponseEntity<>("successfull created", HttpStatus.OK);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @GetMapping("signup/test")
    public ResponseEntity<?> test() {

        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }
    @GetMapping("*/{id}")
    public ResponseEntity<?> testAuth(@PathVariable String id, HttpServletRequest request) {

      ResponseEntity<?> responseEntity=  authService.findOnePerson(id,request);

        return responseEntity;

    }
    @GetMapping("*")
    public ResponseEntity<?> testAuthAll(@PathVariable String id, HttpServletRequest request) {

        ResponseEntity<?> responseEntity=  authService.findOnePerson(id,request);

        return responseEntity;

    }


//    @GetMapping("*/*")
//    public ResponseEntity<?> testAuth(@PathVariable String id, HttpServletRequest request) {
//
//        ResponseEntity<?> responseEntity=  authService.findOnePerson(id,request);
//
//        return responseEntity;
//
//    }




}
