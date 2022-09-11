package org.example.testAugust.service;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.DataNotFoundException;
import org.example.testAugust.entity.Question;
import org.example.testAugust.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Optional<Question> getQuestion(Question question) {
        return questionRepository.findById(question.getId());
    }

    public Question getQuestionRequest(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question noe found");
        }
    }
}
