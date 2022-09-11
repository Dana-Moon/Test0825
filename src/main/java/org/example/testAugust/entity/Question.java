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

    @Column(length = 200, unique = true)
    private String nickname;

    private String subject;

    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
