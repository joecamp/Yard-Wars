package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Quiz;

public class QuizTest {

	@Test
	public void quizTest1() {
		assertEquals(Quiz.isRight(-1, 1), false);
		assertEquals(Quiz.isRight(18, 1), false);
		assertEquals(Quiz.isRight(4, 0), true);
		assertEquals(Quiz.isRight(6, 2), false);
	}

}
