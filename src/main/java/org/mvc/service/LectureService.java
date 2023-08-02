package org.mvc.service;


import org.mvc.entity.Lecture;
import org.mvc.handler.EntityNotFoundException;
import org.mvc.repository.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    private final LectureRepo lectureRepo;
    private final HomeworkService homeworkService;

    @Autowired
    public LectureService(LectureRepo lectureRepo, HomeworkService homeworkService) {
        this.lectureRepo = lectureRepo;
        this.homeworkService = homeworkService;
    }

    public List<Lecture> findAllByCourseId(int courseId) {
        return lectureRepo.getByCourseId(courseId);

    }

    public void createLecture(String lectureName) {

        Lecture lecture = new Lecture();
        lecture.setName(lectureName);
        lecture.setCreatedAt(LocalDateTime.now());
        lecture.setLectureDate(LocalDateTime.now().plusDays((int) (Math.random() * 10)));
        lectureRepo.saveAndFlush(lecture);
    }

    public Optional<List<Lecture>> outputAll() {
        return Optional.of(lectureRepo.findAll());
    }

    public Lecture getRequireById(int lectureId) throws EntityNotFoundException {
        Optional<Lecture> lecture = Optional.of(lectureRepo.getById(lectureId));
        if (lecture.isEmpty()) {
            throw new EntityNotFoundException("entity not found");
        }
        addHomeworkIntoLecture(lecture.get());
        System.out.println(lecture.get());
        return lecture.get();
    }

    private void addHomeworkIntoLecture(Lecture lecture) {
        lecture.setHomeworkList(homeworkService.findAllByLectureId(lecture.getId()));
    }

    public void deleteById(int lectureId) {
        Optional<Lecture> lecture = Optional.of(lectureRepo.getById(lectureId));
        lectureRepo.deleteById(lecture.get().getId());
    }

}