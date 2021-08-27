package edu.miu.authserver.model;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String name;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)//(mappedBy = "people")
    private Set<Role> roles =new HashSet<>();


    public UserAccess(String username,String name, String password,String email ) {
      this.username=username;
        this.name = name;
        this.password = password;
        this.email=email;

    }

//    public boolean addRoles(Role role){
//        boolean status=false;
//        System.out.println("add roless");
//        if (roles.add(role)){
//            System.out.println("add roless");
//            role.addOnePeson(this);
//            status=true;
//        }
//        return status;
//    }

    public boolean addOneRole(Role role){
        return this.roles.add(role);
    }


}
