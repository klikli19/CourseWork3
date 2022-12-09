package com.skypro.examinerservice;

import com.skypro.examinerservice.exception.QuestionNotFoundException;
import com.skypro.examinerservice.exception.QuestionOnListException;
import com.skypro.examinerservice.model.Question;
import com.skypro.examinerservice.service.JavaQuestionService;
import com.skypro.examinerservice.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class JavaQuestionServiceTest {
    private final QuestionService service = new JavaQuestionService();

    public static final String QUESTION = "test";
    public static final String ANSWER = "answer";

    public static final Question TEST = new Question("question", "answer");

    @Test
    public void addTest() {
        Question question = new Question(QUESTION, ANSWER);
        assertEquals(question, service.add("test", "answer"));
        assertThat(service.getAll()).contains(question);
    }

    @Test
    public void addTestException() {
        Assertions.assertThrows(QuestionOnListException.class, () -> {
            service.add(TEST);
        });
    }

    @Test
    public void remove() {
        Question question = new Question(QUESTION, ANSWER);
        service.add(question);
        assertEquals(question, service.remove(question));
    }

    @Test
    public void removeTestException() {
        Assertions.assertThrows(QuestionNotFoundException.class, () -> {
            service.remove(TEST);
        });
    }

    @Test
    public void getAllEmptyTest() {
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    public void getAllTest() {
        Question questionTest = new Question(QUESTION, ANSWER);
        service.add(questionTest);
        assertTrue(service.getAll().contains(questionTest));
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = new Question(QUESTION, ANSWER);
        service.add(question);
        assertEquals(question, service.getRandomQuestion());
    }

}
