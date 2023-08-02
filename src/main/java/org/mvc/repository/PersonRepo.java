package org.mvc.repository;

import org.mvc.entity.Person;
import org.mvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Person person SET person.lastName = :#{#updatedPerson.lastName}, " +
            "person.firstName = :#{#updatedPerson.firstName}," +
            "person.role = :#{#updatedPerson.role}," +
            "person.phone = :#{#updatedPerson.phone}," +
            "person.email = :#{#updatedPerson.email}," +
            "person.courseId = :#{#updatedPerson.courseId}" +
            "WHERE person.id = :#{#updatedPerson.id}")
    void updatePerson(Person person);

    @Transactional
    @Query("GET Person person WHERE person.courseId = courseId")
    List<Person> getByCourseId(Integer courseId);

    @Transactional
    @Query("GET Person person WHERE person.courseId = courseId AND person.role = role")
    List<Person> getByCourseIdAndRole(Integer courseId, Role role);

    @Transactional
    @Query("GET Person person WHERE person.lastName = lastName")
    Optional<Person> getByLastName(String lastName);

    @Transactional
    @Query("GET Person person WHERE person.role = role")
    List<Person> getByRole(Role role);

    @Transactional
    @Query("DELETE Person person WHERE person.lastName = lastName")
    void deleteByLastName(String lastName);
}
