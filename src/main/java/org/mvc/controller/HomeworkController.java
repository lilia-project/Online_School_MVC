package org.mvc.controller;

import org.mvc.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeworkController {
    private final HomeworkService homeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping("/add")
    public String addHomework(@RequestParam Integer lectureId,
                              @RequestParam String task) {
        homeworkService.createNewHomework(lectureId, task);
        return "redirect:/all-students";
    }
}
