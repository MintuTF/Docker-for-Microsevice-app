package edu.miu.authserver.service;


import edu.miu.authserver.model.Person;
import edu.miu.authserver.util.Auth.UrlParser;
import edu.miu.authserver.util.payload.SignupRequest;
import edu.miu.authserver.util.payload.response.UserAccessResponse;
import edu.miu.authserver.util.security.jwt.JwtUtils;
import edu.miu.authserver.util.userdetails.UserDetailsimp;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring-boot-server.name}")
    private String serverName;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private  UserAccessImp userAccessImpl;


    // create header
    private HttpHeaders createHttpHeaders(HttpServletRequest request){
        return new org.springframework.http.HttpHeaders(){{
            String headerAuth = request.getHeader("Authorization");

            set( "Authorization", headerAuth );
        }};
    }



    public ResponseEntity<?>  findOnePerson(String id, HttpServletRequest servletRequest){
       String requestUrl=UrlParser.getURL(servletRequest);

        System.out.println(requestUrl);

//        Map<String, String > username= new HashMap<>();
//        username.put("username",authentication.getUsername());
     String url = getBaseServiceUrl()+requestUrl;
        System.out.println(url);
//        String url = "http://172.19.140.132:8080/api/persons/"+id;
      ResponseEntity<Object> rest= restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(createHttpHeaders(servletRequest)),Object.class);

        return new ResponseEntity<>(rest,HttpStatus.OK);
    }

    public ResponseEntity<?>  createPerson(SignupRequest signupRequest,HttpServletRequest servletRequest){

        // save to login me
        String url = getBaseServiceUrl()+"/api/persons/signup";

        HttpEntity<SignupRequest> requestEntity = new HttpEntity<>(signupRequest, createHttpHeaders(servletRequest));
        restTemplate.exchange(url, HttpMethod.POST,requestEntity,Object.class);
        System.out.println("====");
        UserAccessResponse response= userAccessImpl.createUser(signupRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }





    @Autowired
    private String getBaseServiceUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        serviceInstances.forEach(System.out::println);
        System.out.println(serviceInstances.get(0).getUri().toString());
        return serviceInstances.get(0).getUri().toString();
    }
}
