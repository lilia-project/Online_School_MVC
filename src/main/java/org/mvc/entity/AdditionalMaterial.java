package org.mvc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AdditionalMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int lectureId;

    @Column(columnDefinition = "text", name = "resource_type")
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "lectureid")
    private Lecture lecture;

    public AdditionalMaterial() {
    }

    public AdditionalMaterial(Integer id, String name, int lectureId) {
        this.id = id;
        this.name = name;
        this.lectureId = lectureId;
    }

    @Override
    public String toString() {
        return "\n AdditionalMaterial{" +
                " id=" + id +
                " name='" + name + '\'' +
                " lectureId=" + lectureId +
                " resourceType=" + resourceType +
                '}';
    }
}
