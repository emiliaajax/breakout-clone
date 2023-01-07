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

	private Ball mockBall;
	private Brick mockBrick;
	private Paddle mockPaddle;
	private GameUI mockGameUI;
	private Timer mockTimer;
	private Game sut;

	@BeforeEach void setUp() {
		mockBall = mock(Ball.class);
		mockBrick = mock(Brick.class);
		mockPaddle = mock(Paddle.class);
		mockGameUI = mock(GameUI.class);
		mockTimer = mock(Timer.class);

		sut = new Game(mockBall, mockBrick, mockPaddle, mockGameUI, mockTimer);
	}

  @Test void constructor() {
		assertDoesNotThrow(() -> new Game(mockBall, mockBrick, mockPaddle, mockGameUI, mockTimer));
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

		verify(mockBall).getYPos();
		verify(mockPaddle).getYPos();
		verify(mockBall).getHeight();

		verify(mockBall, times(2)).getXPos();
		verify(mockPaddle, times(2)).getXPos();
		verify(mockPaddle).getWidth();

		verify(mockBall).changeYDir();
	}

	@Test void checkCollision_betweenBallAndBrick_fromTop() {
		when(mockBall.getYPos()).thenReturn(100);
		when(mockBrick.getYPos()).thenReturn(100);
		when(mockBall.getHeight()).thenReturn(20);

		when(mockBrick.getWidth()).thenReturn(80);
		when(mockBrick.getXPos()).thenReturn(360);
		when(mockBall.getXPos()).thenReturn(400);
		
		sut.checkCollision();

		verify(mockBall).getYPos();
		verify(mockBrick).getYPos();
		verify(mockBall).getHeight();

		verify(mockBrick).getWidth();
		verify(mockBrick, times(2)).getXPos();
		verify(mockBall, times(2)).getXPos();

		verify(mockBall).changeYDir();
	}
}
