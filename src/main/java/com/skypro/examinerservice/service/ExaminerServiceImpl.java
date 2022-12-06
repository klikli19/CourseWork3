package com.skypro.examinerservice.service;

import com.skypro.examinerservice.exception.ExceedsNumberQuestionsInListException;
import com.skypro.examinerservice.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <=0) {
            throw new ExceedsNumberQuestionsInListException("Количество вопросов превышает количество вопросов в списке");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
