package com.skypro.examinerservice.repository;

import com.skypro.examinerservice.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
