package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    int insertPerson(Person person);

    List<Person> selectAllUsers();

    Optional<Person> selectPerson(UUID id);

    int updatePerson(UUID id, Person person);

    int deletePerson(UUID id);
}
