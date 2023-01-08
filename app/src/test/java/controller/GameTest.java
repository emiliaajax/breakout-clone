package controller;

import org.junit.jupiter.api.Test;
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

public class GameTest {
	private static final int PADDLE_Y_POS = 520;
	private static final int BALL_HEIGHT = 20;
	private static final int BALL_WIDTH = 20;
	private static final int PADDLE_WIDTH = 150;
	private static final int PADDLE_X_POS_TEST = 200;
	private static final int BRICK_Y_POS = 100;
	private static final int BRICK_WIDTH = 80;
	private static final int BRICK_X_POS_TEST = 360;
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

	@Test void checkCollision_betweenBallAndPaddle() {
		when(mockBall.getYPos()).thenReturn(PADDLE_Y_POS - BALL_HEIGHT);
		when(mockPaddle.getYPos()).thenReturn(PADDLE_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBall.getXPos()).thenReturn(PADDLE_X_POS_TEST + PADDLE_WIDTH / 2);
		when(mockBall.getWidth()).thenReturn(BALL_WIDTH);
		when(mockPaddle.getXPos()).thenReturn(PADDLE_X_POS_TEST);
		when(mockPaddle.getWidth()).thenReturn(PADDLE_WIDTH);

		sut.checkCollision();

		verify(mockBall, times(3)).getYPos();
		verify(mockPaddle).getYPos();
		verify(mockBall, times(2)).getHeight();

		verify(mockBall, times(4)).getXPos();
		verify(mockPaddle, times(2)).getXPos();
		verify(mockPaddle).getWidth();

		verify(mockBall).changeYDir();
	}

	@Test void checkCollision_betweenBallAndBrick_fromTop() {
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS - BALL_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getHeight()).thenReturn(BALL_HEIGHT);

		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS_TEST);
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS_TEST + BRICK_WIDTH / 2);
		
		sut.checkCollision();

		verify(mockBall, times(2)).getYPos();
		verify(mockBrick, times(1)).getYPos();
		verify(mockBall, times(2)).getHeight();

		verify(mockBrick, times(4)).getXPos();
		verify(mockBall, times(4)).getXPos();
		verify(mockBrick, times(2)).getWidth();

		verify(mockBall).changeYDir();
		verify(mockBrick).destroy();
	}

	@Test void checkCollision_betweenBallAndBrick_fromBottom() {
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT);
		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS_TEST);
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS_TEST + BRICK_WIDTH / 2);
		
		sut.checkCollision();

		verify(mockBall, times(3)).getYPos();
		verify(mockBrick, times(2)).getYPos();
		verify(mockBrick, times(1)).getHeight();

		verify(mockBrick, times(4)).getXPos();
		verify(mockBall, times(4)).getXPos();
		verify(mockBrick, times(2)).getWidth();

		verify(mockBall).changeYDir();
		verify(mockBrick).destroy();
	}

	@Test void checkCollision_betweenBallAndBrick_onLeftSideOfBrick() {
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS_TEST - BALL_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS_TEST);
		when(mockBall.getWidth()).thenReturn(BALL_WIDTH);

		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT / 2);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		sut.checkCollision();

		verify(mockBall).getXPos();
		verify(mockBrick).getXPos();
		verify(mockBall).getWidth();

		verify(mockBrick, times(4)).getYPos();
		verify(mockBall, times(5)).getYPos();
		verify(mockBrick, times(2)).getHeight();

		verify(mockBall).changeXDir();
		verify(mockBrick).destroy();
	}

	@Test void checkCollision_betweenBallAndBrick_onRightSideOfBrick() {
		when(mockBall.getXPos()).thenReturn(BRICK_X_POS_TEST + BRICK_WIDTH);
		when(mockBrick.getXPos()).thenReturn(BRICK_X_POS_TEST);
		when(mockBrick.getWidth()).thenReturn(BRICK_WIDTH);

		when(mockBrick.getYPos()).thenReturn(BRICK_Y_POS);
		when(mockBall.getYPos()).thenReturn(BRICK_Y_POS + BRICK_HEIGHT / 2);
		when(mockBrick.getHeight()).thenReturn(BRICK_HEIGHT);

		sut.checkCollision();

		verify(mockBall, times(2)).getXPos();
		verify(mockBrick, times(2)).getXPos();
		verify(mockBrick).getWidth();

		verify(mockBrick, times(4)).getYPos();
		verify(mockBall, times(5)).getYPos();
		verify(mockBrick, times(2)).getHeight();

		verify(mockBall).changeXDir();
		verify(mockBrick).destroy();
	}
}
