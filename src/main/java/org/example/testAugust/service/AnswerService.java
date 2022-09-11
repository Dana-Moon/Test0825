package org.example.testAugust.service;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.entity.Answer;
import org.example.testAugust.entity.Question;
import org.example.testAugust.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
