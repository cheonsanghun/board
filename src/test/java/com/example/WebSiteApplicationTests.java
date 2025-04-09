package com.example;

import com.example.question.Question;
import com.example.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@EnableJpaRepositories(basePackages = "com.example.question") // ★ 이거 추가!
class WebSiteApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		/*Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장

		List<Question> all = this.questionRepository.findAll();
		assertEquals(6, all.size());//6의경우 데이터베이스에 저장되어 값들의 수를 비교 현재 데이터베이스에 6개가 저장되어있기에 6으로 설정
		//JUnit의 assertEquals 메서드를 사용하는데, 이 메서드는 테스트에서 예상한 결과와 실제 결과가 동일한지를 확인하는 목적으로 사용
		//assertEquals(기댓값, 실젯값)와 같이 작성하고 기댓값과 실젯값이 동일한지를 조사
		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());

		Optional<Question> oq = this.questionRepository.findById(1); Optional로 하는 이유는 값이 존재하는지 확인하기 위해서
		//questionRepository를 사용하여 데이터베이스에서 id가 1인 질문을 조회
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		*/
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
	}


}
