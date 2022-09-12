package org.example.testAugust.reply;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.board.Board;
import org.example.testAugust.board.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final BoardService boardService;
    private final ReplyService replyService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long id, @RequestParam String reply) {
        Board board = this.boardService.getBoardRequest(id);
        this.replyService.create(board, reply);
        return String.format("redirect:/board/detail/%s", id);
    }
}
