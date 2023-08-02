package org.mvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Homework {

    private int lectureId;
    private String task;
    transient private LocalDate deadline;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lectureid")
    private Lecture lecture;

    public Homework() {
    }

    public Homework(Integer id, int lectureId, String task) {
        this.id = id;
        this.lectureId = lectureId;
        this.task = task;
    }

    @Override
    public String toString() {
        return "\n homeworkId = " + id +
                "\n homeworkDeadline = " + deadline +
                "\n lecture's id = " + lectureId +
                "\n homework's name = '" + task + "'";
    }

}
