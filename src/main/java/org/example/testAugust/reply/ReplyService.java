package org.example.testAugust.reply;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.board.Board;
import org.example.testAugust.member.OppuMember;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public interface ReplyService {

    public void create(Board board, String content, OppuMember writer);
}
