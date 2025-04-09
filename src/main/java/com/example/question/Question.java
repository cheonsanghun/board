package com.example.question;

import java.util.List;

import com.example.answer.Answer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity//데이터베이스의 테이블과 1:1로 매핑되는 자바 클래스 즉, 이 클래스 하나가 실제 DB 테이블 하나
public class Question {
    @Id// id 속성을 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 데이터를 저장할 때 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장  고유한 번호를 생성하는 방법을 지정하는 부분
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")//열 데이터의 유형이나 성격을 정의할 때 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    //1대다로 데이터베이스에서 자료를 매칭할 때 하나의 Question이 여러 개의 Answer를 가진다.
    //이때, mappedBy = "question"은 반대쪽인 Answer에 있는 question 필드를 기준으로 연결된다는 뜻
    //cascade = CascadeType.REMOVE는 질문이 삭제 될 시 answer의 값또한 같이 삭제 된다는 뜻
    private List<Answer> answerList;


}
