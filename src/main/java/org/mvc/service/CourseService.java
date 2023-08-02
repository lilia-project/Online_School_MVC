package org.mvc.service;

import org.mvc.entity.Course;
import org.mvc.entity.Lecture;
import org.mvc.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepo courseRepo;
    private final LectureService lectureService;

    @Autowired
    public CourseService(CourseRepo courseRepo, LectureService lectureService) {
        this.courseRepo = courseRepo;
        this.lectureService = lectureService;
    }

    private void addLectureIntoCourse(Course course) {
        List<Lecture> list = lectureService.findAllByCourseId(course.getId());
        course.setLectures(list);
    }

    public void save(String name) {
        Course course = new Course();
        course.setName(name);
        courseRepo.saveAndFlush(course);
    }

    public void updateCourse(Course course, String name) {
        course.setName(name);
        courseRepo.updateCourse(course);
    }


    public List<Course> outputAll() {
        return courseRepo.findAll();
    }

    public Course getRequireById(int courseId) {
        Optional<Course> course = Optional.of(courseRepo.getById(courseId));
        return course.get();
    }

    public void deleteById(int courseId) {
        courseRepo.deleteById(courseId);
    }

}
