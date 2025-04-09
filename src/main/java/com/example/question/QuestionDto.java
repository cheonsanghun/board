package com.example.question;

import com.example.answer.AnswerDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionDto {
    private final Integer id;
    private final String subject;
    private final String content;
    private final List<AnswerDto> answer;
    private final LocalDateTime createDate;

    public QuestionDto(Integer id, String subject, String content, LocalDateTime createDate, List<AnswerDto> answer) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
        this.answer = answer;
    }


}
