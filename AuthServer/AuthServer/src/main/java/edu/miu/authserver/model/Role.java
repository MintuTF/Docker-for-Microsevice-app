package edu.miu.authserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "people")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ERole name;
  //  @ManyToMany
   // private List<UserAccess> people=new ArrayList<>();

//    public Role(ERole name) {
//        this.name = name;
//    }
//    public boolean addPerson(UserAccess person){
//        boolean status=false;
//        if (people.add(person)){
//            person.addOneRole(this);
//            status=true;
//        }
//        return status;
//    }
//
//    public boolean addOnePeson(UserAccess person){
//        return  people.add(person);
//    }


}
