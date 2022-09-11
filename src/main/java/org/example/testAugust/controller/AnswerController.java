package org.example.testAugust.controller;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.entity.Question;
import org.example.testAugust.service.AnswerService;
import org.example.testAugust.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String reply) {
        Question question = this.questionService.getQuestionRequest(id);
        this.answerService.create(question, reply);
        return String.format("redirect:/question/detail/%s", id);
    }
}
