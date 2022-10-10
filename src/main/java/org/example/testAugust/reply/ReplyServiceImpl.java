package org.example.testAugust.reply;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.board.Board;
import org.example.testAugust.member.OppuMember;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public void create(Board board, String content, OppuMember writer) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setBoard(board);
        reply.setWriter(writer);
        this.replyRepository.save(reply);
    }
}