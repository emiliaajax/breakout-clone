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
}
