package org.example.testAugust.reply;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.board.Board;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    public void create(Board board, String content) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setBoard(board);
        this.replyRepository.save(reply);
    }
}
