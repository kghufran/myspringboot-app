package com.ghufran.myspringboot.myspringbootapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    // Get All persons

    @GetMapping(path = "/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    // Create a Person
    @PostMapping("/persons")
    public Person createNote(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    // Get Person by Id
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long personID){
        return personRepository.findById(personID)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personID));
    }

    // Update Person by id
    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable(value = "id") Long personID, @Valid @RequestBody Person personToUpdate){
        Person person = personRepository.findById(personID)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personID));

        person.setFirstName(personToUpdate.getFirstName());
        person.setLastName(personToUpdate.getLastName());

        Person updatedPerson = personRepository.save(person);
        return updatedPerson;
    }

    // Delete Person by id
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long Id){
        Person person = personRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", Id));

        personRepository.delete(person);

        return ResponseEntity.ok().build();
    }
}
