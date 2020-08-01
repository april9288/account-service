package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDaoPostgres implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
//        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public int insertPerson(Person person) {
//        UUID randomId = UUID.randomUUID();
//        DB.add(new Person(randomId, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllUsers() {
        final String sql = "SELECT id, name FROM person";
        System.out.println("i am here");
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        }));
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE = ?";

        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int updatePerson(UUID id, Person person) {
//        Optional<Person> personToUpdate = selectPerson(id);
//        if(personToUpdate.isPresent()){
//            int index = DB.indexOf(personToUpdate.get());
//            DB.set(index, person);
//            return 1;
//        }
        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
//        Optional<Person> personToDelete = selectPerson(id);
//        if(personToDelete.isPresent()) {
//            DB.remove(personToDelete.get());
//            return 1;
//        }
        return 0;
    }


}
