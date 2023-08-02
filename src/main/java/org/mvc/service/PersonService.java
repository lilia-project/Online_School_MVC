package org.mvc.service;


import org.mvc.entity.Person;
import org.mvc.entity.Role;
import org.mvc.handler.EntityNotFoundException;
import org.mvc.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public void createNewPerson(Person person) {
        personRepo.saveAndFlush(person);
    }

    public List<Person> outAllByCourseId(int courseId, Role role) {
        return personRepo.getByCourseIdAndRole(courseId, role);
    }

    public void delete(String lastName) {
        personRepo.deleteByLastName(lastName);
    }

    public Person getByLastName(String lastName) throws EntityNotFoundException {
        Optional<Person> person = personRepo.getByLastName(lastName);
        if (person.isEmpty()) {
            throw new EntityNotFoundException("entity not found");
        }
        return person.get();
    }

}

