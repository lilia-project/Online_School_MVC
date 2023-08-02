package org.mvc.service;


import org.mvc.entity.Homework;
import org.mvc.handler.EntityNotFoundException;
import org.mvc.repository.HomeworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {
    private final HomeworkRepo homeworkRepo;

    @Autowired
    public HomeworkService(HomeworkRepo homeworkRepo) {
        this.homeworkRepo = homeworkRepo;
    }

    public void createNewHomework(Integer lectureId, String task) {

        Homework homework = new Homework();
        homework.setLectureId(lectureId);
        homework.setTask(task);
        homeworkRepo.saveAndFlush(homework);
    }

    public Homework getRequireById(int homeworkId) throws EntityNotFoundException {

        Optional<Homework> homework = Optional.of(homeworkRepo.getById(homeworkId));
        if (homework.isEmpty()) {
            throw new EntityNotFoundException("entity not found");
        }
        return homework.get();
    }

    public List<Homework> findAllByLectureId(int lectureId) {
        return homeworkRepo.getByLectureId(lectureId);
    }

    public void deleteById(int homeworkId) throws EntityNotFoundException {
        Optional<Homework> homework = Optional.of(homeworkRepo.getById(homeworkId));
        if (homework.isEmpty()) {
            throw new EntityNotFoundException("entity not found");
        } else {
            homeworkRepo.deleteById(homework.get().getId());
        }
    }

}


