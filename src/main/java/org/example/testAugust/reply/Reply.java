package org.example.testAugust.reply;

import lombok.Getter;
import lombok.Setter;
import org.example.testAugust.board.Board;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글 내용
    @Column
    private String content;

//    //댓글 추천수
//    private int recommendNumber;
//
//    //댓글 신고수
//    private int reportNumber;

    //baseEntity 상속받을 예정
    private LocalDateTime createDate;

    //게시글
    @ManyToOne
    private Board board;
}
