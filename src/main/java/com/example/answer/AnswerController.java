package com.example.answer;

import com.example.question.Question;
import com.example.question.QuestionRepository;
import com.example.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")//POST 요청을 처리
    public String create(Model model, @PathVariable("id") Integer questionId, @RequestParam(value="content") String content) {
        Question question = this.questionService.getQuestionId(questionId);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", questionId);
    }
}
