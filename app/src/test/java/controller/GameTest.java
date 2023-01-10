package controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;

import model.Ball;
import model.Brick;
import model.Paddle;
import view.GameUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

public class GameTest {
	private static final int PADDLE_Y_POS = 520;
	private static final int BALL_HEIGHT = 20;
	private static final int BALL_WIDTH = 20;
	private static final int PADDLE_WIDTH = 150;
	private static final int PADDLE_X_POS = 200;
	private static final int BRICK_Y_POS = 100;
	private static final int BRICK_WIDTH = 80;
	private static final int BRICK_X_POS = 360;
	private static final int BRICK_HEIGHT = 40;

	private Ball mockBall;
	private Brick[] mockBricks;
	private Brick mockBrick;
	private Paddle mockPaddle;
	private GameUI mockGameUI;
	private Timer mockTimer;
	private Game sut;

	@BeforeEach void setUp() {
		mockBall = mock(Ball.class);
		mockPaddle = mock(Paddle.class);
		mockGameUI = mock(GameUI.class);
		mockTimer = mock(Timer.class);

		Brick[] mockBricks = new Brick[1];

		for (int i = 0; i < mockBricks.length; i++) {
			mockBricks[i] = mock(Brick.class);
		}

		mockBrick = mockBricks[0];

		sut = new Game(mockBall, mockBricks, mockPaddle, mockGameUI, mockTimer);
	}

  @Test void constructor() {
		assertDoesNotThrow(() -> new Game(mockBall, mockBricks, mockPaddle, mockGameUI, mockTimer));
	}

	@Test void testStart() throws InterruptedException {
		sut.start();

		ArgumentCaptor<TimerTask> timerTaskCaptor = ArgumentCaptor.forClass(TimerTask.class);

		verify(mockTimer).scheduleAtFixedRate(timerTaskCaptor.capture(), eq(0L), eq(10L));

		TimerTask timerTask = timerTaskCaptor.getValue();
		timerTask.run();

		verify(mockBall).move();
		verify(mockPaddle).move();
		verify(mockGameUI).repaint();
	}

	@Test void testStartSchedulesTimerTask() {
		sut.start();

		verify(mockTimer).scheduleAtFixedRate(any(TimerTask.class), eq(0L), eq(10L));
	}

	@Test void ballShouldNotBounceWhenCollidingWithDestroyedBrick() {
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS + BRICK_WIDTH / 2);

		when(mockBrick.isDestroyed()).thenReturn(true);
		
		sut.checkCollision();

		verify(mockBall, never()).changeYDir();
		verify(mockBrick, never()).destroy();
	}

	@Test void ballShouldBounceWhenCollidingWithPaddle() {
		when(mockBall.getYPos()).thenReturn(PADDLE_Y_POS - BALL_HEIGHT);
		when(mockPaddle.getYPos()).thenReturn(PADDLE_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBall.getXPos()).thenReturn(PADDLE_X_POS + PADDLE_WIDTH / 2);
		when(mockPaddle.getXPos()).thenReturn(PADDLE_X_POS);
		when(mockPaddle.getWidth()).thenReturn(PADDLE_WIDTH);

		sut.checkCollision();

		verify(mockBall).changeYDir();
	}

	@Test void ballShouldNotChangeDirectionWhenPassingPaddle_onRightSide() {
		when(mockBall.getYPos()).thenReturn(PADDLE_Y_POS - BALL_HEIGHT);
		when(mockPaddle.getYPos()).thenReturn(PADDLE_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBall.getXPos()).thenReturn(PADDLE_X_POS + PADDLE_WIDTH * 2);
		when(mockPaddle.getXPos()).thenReturn(PADDLE_X_POS);
		when(mockPaddle.getWidth()).thenReturn(PADDLE_WIDTH);

		sut.checkCollision();

		verify(mockBall, never()).changeYDir();
	}

	@Test void ballShouldNotChangeDirectionWhenPassingPaddle_onLeftSide() {
		when(mockBall.getYPos()).thenReturn(PADDLE_Y_POS - BALL_HEIGHT);
		when(mockPaddle.getYPos()).thenReturn(PADDLE_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBall.getXPos()).thenReturn(PADDLE_X_POS - PADDLE_WIDTH * 2);
		when(mockPaddle.getXPos()).thenReturn(PADDLE_X_POS);
		when(mockPaddle.getWidth()).thenReturn(PADDLE_WIDTH);

		sut.checkCollision();

		verify(mockBall, never()).changeYDir();
	}


	@Test void ballShouldBounceWhenCollidingWithBrick_onTopOfBrick() {
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS - BALL_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS + BRICK_WIDTH / 2);

		when(mockBrick.isDestroyed()).thenReturn(false);
		
		sut.checkCollision();

		verify(mockBall).changeYDir();
		verify(mockBrick).destroy();
	}

	@Test void ballShouldBounceWhenCollidingWithBrick_onBottomOfBrick() {
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS + BRICK_WIDTH / 2);

		when(mockBrick.isDestroyed()).thenReturn(false);
		
		sut.checkCollision();

		verify(mockBall).changeYDir();
		verify(mockBrick).destroy();
	}

	@Test void ballShouldBounceWhenCollidingWithBrick_onLeftSideOfBrick() {
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS - BALL_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getWidth()).thenReturn(BALL_WIDTH);

		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT / 2);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBrick.isDestroyed()).thenReturn(false);

		sut.checkCollision();

		verify(mockBall).changeXDir();
		verify(mockBrick).destroy();
	}

	@Test void ballShouldBounceWhenCollidingWithBrick_onRightSideOfBrick() {
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS + BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);

		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT / 2);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBrick.isDestroyed()).thenReturn(false);

		sut.checkCollision();

		verify(mockBall).changeXDir();
		verify(mockBrick).destroy();
	}

	@ParameterizedTest
	@MethodSource("ballXAndYPositions")
	void ballShouldNotBounceWhenMissingABrick_passingByBesideBrick(int ballXPos, int ballYPos) {
		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getXPos()).thenReturn(ballXPos);

		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getYPos()).thenReturn(ballYPos);

		when(mockBrick.isDestroyed()).thenReturn(false);

		sut.checkCollision();

		verify(mockBall, never()).changeXDir();
		verify(mockBrick, never()).destroy();
	}

	private static Stream<Arguments> ballXAndYPositions() {
		return Stream.of(
			Arguments.of(BRICK_X_POS + BRICK_WIDTH * 2, BRICK_Y_POS),
			Arguments.of(BRICK_X_POS - BRICK_WIDTH * 2, BRICK_Y_POS + BRICK_HEIGHT)
		);
	}
	
	@ParameterizedTest
	@MethodSource("ballYPositions")
	void ballShouldNotBounceWhenMissingABrick_passingByAboveOrBelowBrick(int ballYPos) {
		when(mockBall.getYPos()).thenReturn(ballYPos);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBall.getXPos()).thenReturn(BRICK_X_POS - BALL_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS);
		when(mockBall.getWidth()).thenReturn(BALL_WIDTH);

		when(mockBrick.isDestroyed()).thenReturn(false);
		
		sut.checkCollision();

		verify(mockBall, never()).changeYDir();
		verify(mockBrick, never()).destroy();
	}

	private static Stream<Arguments> ballYPositions() {
		return Stream.of(
			Arguments.of(BRICK_Y_POS - BRICK_HEIGHT * 2),
			Arguments.of(BRICK_Y_POS + BRICK_HEIGHT * 2)
		);
	}
}
