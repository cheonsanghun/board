package com.example.question;

import java.util.List;

import com.example.answer.AnswerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입, 의존성 주입을 위한 생성자 자동 생성에 사용
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionDto> getDtoList() {
        return questionRepository.findAll()
                .stream()//스트림 형으로 변화해야함
                .map(q -> new QuestionDto(
                        q.getId(),
                        q.getSubject(),
                        q.getContent(),
                        q.getCreateDate(),
                        q.getAnswerList().stream()
                                .map(a -> new AnswerDto(
                                        //답변이 리스트 형으로 되어있기에 answerDto를 통해 받은 값들을 다시 .map으로 받음
                                        a.getId(),
                                        a.getContent(),
                                        a.getCreateDate(),
                                        a.getQuestion().getId()
                                        //답변 아이디만을 갖기 위함임 answer에서Question은 다대1의 관계이기에 각 답변의 아이디값만이 필요하기 때문
                                )).toList()
                )).toList();
    }


}
