package org.example.testAugust.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoardRequest(id);
        model.addAttribute("board", board);
        return "/board/detail";
    }

    //detail 메소드에 GetMapping 해보기
//    @GetMapping("/questionDetail")
//    public String queryDetail(Question question, Model model) {
//        model.addAttribute("question", questionService.getQuestion(question));
//        return "/questionDetail";
//    }

    //detail 메소드에 RequestParam써보기 (계속 에러 나서 일단 넘김)
//    @GetMapping(value = "/question/detail/{id}")
//    public String detail(Model model, @RequestParam("id") Integer id) {
//        Question question = this.questionService.getQuestionRequest(id);
//        model.addAttribute("question", question);
//        return "questionDetail";
//    }

    @GetMapping("/insert")
    public String insertBoard() {
        return "/board/insertBoard";
    }

    @PostMapping("/insert")
    public String insertBoard(@RequestParam String category, @RequestParam String title, @RequestParam String nickname, @RequestParam String content) {
        this.boardService.insertBoard(category, title, nickname, content);
        return "redirect:/board/list";
    }
}
