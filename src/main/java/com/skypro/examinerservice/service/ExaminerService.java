package com.skypro.examinerservice.service;

import com.skypro.examinerservice.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
