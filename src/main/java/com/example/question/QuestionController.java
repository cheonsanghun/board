package com.example.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor//롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<QuestionDto> questionList = this.questionService.getDtoList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable Integer id) {
        //@PathVariable URL 경로(URI)에 있는 값을 변수로 받아오는 어노테이션
        Question question = this.questionService.getQuestionId(id);
        model.addAttribute("question", question);
        //Model model Spring에서 **컨트롤러 → 뷰(템플릿)**로 데이터를 전달하는 중간 저장소
        //key: "question"
        //value: question 객체 (엔티티 또는 DTO 등)
        return "question_detail";
    }
}
