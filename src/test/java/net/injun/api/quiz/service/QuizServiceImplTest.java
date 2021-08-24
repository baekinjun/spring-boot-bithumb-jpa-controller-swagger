package net.injun.api.quiz.service;

import net.injun.api.quiz.domain.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    //데이터 받는 부분은 목객체 생성 x
    private QuizServiceImpl quizService;

    //데이터 공급해주는 부분이 목객체 생성
    @Mock
    GeneratorServiceImpl generatorService;

    @BeforeEach
    void setUp() {
        quizService = new QuizServiceImpl(generatorService);
    }

    @Test
    @DisplayName("50 * 30 = 1500")
    void createQuiz() {
        //목객체에 데이터 주입
        given(generatorService.randomFactor()).willReturn(50, 30);

        Quiz quiz = quizService.createQuiz();

        assertThat(quiz.getFactorA(), is(50));
        assertThat(quiz.getFactorB(), is(30));
        assertThat(quiz.getResult(), is(1500));
    }
}