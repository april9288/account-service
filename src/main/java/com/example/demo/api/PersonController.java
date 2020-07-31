package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPersonController(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> selectAllUsers() {
        return personService.selectAllUsers();
    }

    @GetMapping(path = "{id}")
    public Person selectById(@PathVariable("id") UUID id) {
        return personService.selectById(id)
                .orElse(null);
    }

    @PutMapping
    public int updateById(@RequestBody Person person) {
        return personService.updatePerson(person.getId(), person);
    }

    @DeleteMapping(path = "{id}")
    public int deleteById(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }
}
