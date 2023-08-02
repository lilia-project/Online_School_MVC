package org.mvc.repository;

import org.mvc.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Lecture lecture SET lecture.name = :#{#updatedLecture.name}, " +
            " lecture.lectureDate = :#{#updatedLecture.lectureDate} " +
            " lecture.courseId = :#{#updatedLecture.courseId} " +
            " lecture.personId = :#{#updatedLecture.personId} " +
            " lecture.description = :#{#updatedLecture.description} " +
            "WHERE lecture.id = :#{#updatedLecture.id}")
    void updateLecture(Lecture lecture);

    @Transactional
    @Query("GET Lecture lecture WHERE lecture.courseId = courseId")
    List<Lecture> getByCourseId(Integer courseId);

    @Transactional
    @Query("DELETE Lecture lecture WHERE lecture.id = id")
    void deleteById(Integer id);
}