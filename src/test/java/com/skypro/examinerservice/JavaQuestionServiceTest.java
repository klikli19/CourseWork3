package com.skypro.examinerservice;

import com.skypro.examinerservice.model.Question;
import com.skypro.examinerservice.service.JavaQuestionService;
import com.skypro.examinerservice.service.QuestionService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class JavaQuestionServiceTest {
    private final QuestionService service = new JavaQuestionService();

    public static String QUESTION = "test";
    public static String ANSWER = "answer";

    @Test
    public void addTest() {
        Question question = new Question(QUESTION, ANSWER);
        assertEquals(question, service.add("test", "answer"));
        assertThat(service.getAll()).contains(question);
    }

    @Test
    public void remove() {
        Question question = new Question(QUESTION, ANSWER);
        service.add(question);
        assertEquals(question, service.remove(question));
    }

    @Test
    public void getAllTest() {
        Question question = new Question(null, null);
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = new Question(QUESTION, ANSWER);
        service.add(question);
        assertEquals(question, service.getRandomQuestion());
    }

}
