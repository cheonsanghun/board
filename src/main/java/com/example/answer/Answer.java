package com.example.answer;

import java.time.LocalDateTime;

import com.example.question.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne//다른 클래스를 사용하기 위한 엔티티
    //질문 하나에 답변이 여러개인데 이를 매칭하기 위한 엔티티 n대1 매칭방법
    private Question question;
}
