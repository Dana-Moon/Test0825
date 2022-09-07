package org.example.testAugust.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
