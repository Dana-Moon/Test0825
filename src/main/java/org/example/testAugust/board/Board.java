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

    //유저 닉네임 (이후 회원가입 시 이동할 예정)
    @Column(length = 200, unique = true)
    private String nickname;

    //게시글 카테고리
    private String Category;

    //게시글 제목
    private String title;

    //게시글 작성자
    private String writer;

    //게시글 내용
    private String content;

//    private Long views;
//
//    private int recommendNumber;
//
//    private int reportNumber;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList;
}
