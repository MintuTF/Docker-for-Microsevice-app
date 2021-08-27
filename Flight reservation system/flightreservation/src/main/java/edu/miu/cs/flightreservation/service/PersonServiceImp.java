package edu.miu.cs.flightreservation.service;


import edu.miu.cs.flightreservation.Util.payload.RoleAdapter;
import edu.miu.cs.flightreservation.Util.payload.request.SignupRequest;
import edu.miu.cs.flightreservation.Util.payload.response.PersonResponse;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Role;
import edu.miu.cs.flightreservation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRoleService userRoleService;


   @Override
    public void createPerson(SignupRequest signupRequest) {
       System.out.println(signupRequest);
    Person person1=new Person(signupRequest.getUsername(),
           signupRequest.getPassword(),
           signupRequest.getStatus(), signupRequest.getFirstName(),
           signupRequest.getLastName(), signupRequest.getEmail()
            ,signupRequest.getAddress()
           );
       Role role=userRoleService.findRoleByName
               (RoleAdapter.convertEnumTOString
                       (signupRequest)).get();


             role.addPerson(person1);

              person1.addRoles(role);

       personRepository.save(person1);

    }

    @Override
    public Page<Person> getAllPerson(Pageable pageable ) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person getOnePersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    @Override
    public void deletePerson(Long id) {
     Person person=personRepository.findPersonById(id);
       personRepository.delete(person);

    }

    @Override
    public Person updatePerson(Long id, SignupRequest signupRequest) {


       Person person1=personRepository.findPersonById(id);
       person1.setFirstName(signupRequest.getFirstName());
       person1.setLastName(signupRequest.getLastName());
       person1.setAddress(signupRequest.getAddress());
       person1.setUsername(signupRequest.getUsername());
       person1.setStatus("ACTIVE");
       person1.setRoles(RoleAdapter.
               convertToEnumRole(signupRequest));


       return personRepository.save(person1);

    }

    @Override
    public PersonResponse getOnePersonById(Long id) {

       // System.out.println(HttpHeaders.AUTHORIZATION);


        Person person=personRepository.findPersonById(id);
        Set<Role> roles=person.getRoles();


            PersonResponse personResponse=new PersonResponse(person.getUsername(), person.getPassword(),
                    person.getStatus(), person.getFirstName(),
                    person.getLastName(),"PASSNGER",person.getEmail() );
            return personResponse;
    }
}
