package org.mvc.controller;

import org.mvc.entity.Course;
import org.mvc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService, Menu menu) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello";
    }

    @RequestMapping("/mvc")
    @ResponseBody
    public String mvc() {
        return "Hello in online school!";
    }

    @GetMapping("/course/{id}")
    public String getCourse(Model model, @PathVariable Integer id) {
        final Course course = courseService.getRequireById(id);
        model.addAttribute("course", course);
        return "course";
    }


    @PostMapping("/add")
    public String addCourse(@RequestParam String name) {
        courseService.save(name);
        return "redirect:/all-courses";
    }

    @GetMapping("/all-courses")
    public String home(Model model) {
        model.addAttribute("courses", courseService.outputAll());
        return "courses";
    }
}
