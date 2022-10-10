package org.example.testAugust.board;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    //게시판 목록
    @RequestMapping("/boardList")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page) {
        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "/board/boardList";
    }

    //게시판 상세보기
    @RequestMapping(value = "/getBoard/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Board board = this.boardService.getBoardRequest(id);
//        this.boardService.updateView(id);
        model.addAttribute("board", board);
        return "/board/getBoard";
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

    //게시판 새글쓰기
    @GetMapping("/insert")
    public String insertBoard() {
        return "/board/insertBoard";
    }

    //게시판 새글쓰기
    @PostMapping("/insert")
    public String insertBoard(@RequestParam String category, @RequestParam String title, @RequestParam String nickname, @RequestParam String content) {
        this.boardService.insertBoard(category, title, nickname, content);
        return "redirect:/board/boardList";
    }

//    @PostMapping("/search")
//    public String searchBoard(@RequestParam String boardSearch, RedirectAttributes reAt, @RequestParam(value="page", defaultValue = "0") int page) {
//        List<Board> paging = this.boardService.searchTitle(boardSearch);
//        reAt.addFlashAttribute("paging", paging);
//        return "redirect:/board/list";
//    }
}
