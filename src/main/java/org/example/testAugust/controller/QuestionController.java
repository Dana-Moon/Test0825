package org.example.testAugust.controller;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.entity.Question;
import org.example.testAugust.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "questionList";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestionRequest(id);
        model.addAttribute("question", question);
        return "questionDetail";
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
}
