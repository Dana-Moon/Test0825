package org.example.testAugust.reply;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.board.Board;
import org.example.testAugust.board.BoardService;
import org.example.testAugust.member.MemberService;
import org.example.testAugust.member.OppuMember;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final BoardService boardService;
    private final ReplyService replyService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(Model model,
                               @PathVariable("id") Long id,
                               @RequestParam String reply,
                               Principal principal) {
        Board board = this.boardService.getBoardRequest(id);
        OppuMember oppuMember = this.memberService.getMember(principal.getName());
        this.replyService.create(board, reply, oppuMember);
        return String.format("redirect:/board/getBoard/%s", id);
    }
}
