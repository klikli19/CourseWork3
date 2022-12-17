package com.skypro.examinerservice.controller;

import com.skypro.examinerservice.model.Question;
import com.skypro.examinerservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService service;


    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping("add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question tmp = new Question(question, answer);
        return service.remove(tmp);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }
}
