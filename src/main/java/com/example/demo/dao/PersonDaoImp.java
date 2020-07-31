package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDaoImp implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public int insertPerson(Person person) {
        UUID randomId = UUID.randomUUID();
        DB.add(new Person(randomId, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return DB.stream().filter(db -> db.getId().equals(id)).findFirst();
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        Optional<Person> personToUpdate = selectPerson(id);
        if(personToUpdate.isPresent()){
            int index = DB.indexOf(personToUpdate.get());
            DB.set(index, person);
            return 1;
        }
        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personToDelete = selectPerson(id);
        if(personToDelete.isPresent()) {
            DB.remove(personToDelete.get());
            return 1;
        }
        return 0;
    }
}
