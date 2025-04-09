package com.example.answer;

import java.time.LocalDateTime;

public class AnswerDto {
    private Integer id;
    private String content;
    private LocalDateTime createDate;
    private Integer question;//질문 아이디만 저장

    public AnswerDto(Integer id, String content, LocalDateTime createDate, Integer question) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public Integer getQuestion() {
        return question;
    }
}
