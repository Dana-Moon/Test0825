package org.example.testAugust.board;

import lombok.Getter;
import lombok.Setter;
import org.example.testAugust.reply.Reply;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, unique = true)
    private String nickname;

    private String Category;

    private String title;

    private String writer;

    private String content;

    private Long views;

    private int recommendNumber;

    private int reportNumber;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList;
}
