package com.uniqualifier.controller;

import com.uniqualifier.model.Question;
import com.uniqualifier.service.QuestionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/search")
    public List<Question> search(@RequestParam String keyword) {
        return questionService.searchQuestions(keyword);
    }
}
