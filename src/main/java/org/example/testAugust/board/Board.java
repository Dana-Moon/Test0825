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
//    @Column(nullable = false)
    private String category;

    //게시글 제목
//    @Column(nullable = false)
    private String title;

    //게시글 작성자
//    @Column(nullable = false)
    private String writer;

    //게시글 내용
//    @Column(columnDefinition = "TEXT")
    private String content;

    //게시글 조회수
//    @Column(columnDefinition = "integer default 0", nullable = false)
//    private int view;
//
//    //게시글 추천수
//    private int recommendNumber;
//
//    //게시글 신고수
//    private int reportNumber;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList;
}
