package org.mvc.controller;

import org.mvc.entity.Person;
import org.mvc.entity.Role;
import org.mvc.handler.EntityNotFoundException;
import org.mvc.repository.PersonMenu;
import org.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@Controller
public class PersonController {
    private final PersonService personService;
    private final PersonMenu personMenu;

    @Autowired
    public PersonController(PersonService personService, Menu menu, PersonMenu personMenu) {
        this.personService = personService;
        this.personMenu = personMenu;
    }

    @GetMapping("/form")
    public String showPersonForm(Model model) {
        model.addAttribute("menu", personMenu.getMenuItems());
        return "formsperson";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Role role,
                            @RequestParam String phone,
                            @RequestParam String email) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setRole(role);
        person.setPhone(phone);
        person.setEmail(email);
        personService.createNewPerson(person);
        return "redirect:/all-students";
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("menu", personMenu.getMenuItems());
        return "index";
    }

    @GetMapping("/student/{id}")
    public String getStudent(Model model, @PathVariable String lastName) throws EntityNotFoundException {
        final Person person = personService.getByLastName(lastName);
        model.addAttribute("person", person);
        model.addAttribute("menu", personMenu.getMenuItems());
        return "person";
    }

    @GetMapping("/all-students")
    public String home(Model model, Integer courseId, Role role) {
        model.addAttribute("menu", personMenu.getMenuItems());
        model.addAttribute("students", personService.outAllByCourseId(courseId, role));
        return "students";
    }

}
