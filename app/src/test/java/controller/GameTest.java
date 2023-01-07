package controller;

import org.junit.jupiter.api.Test;

import model.Ball;
import model.Brick;
import model.Paddle;
import view.GameUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import java.util.Timer;

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

	@Test void testStart() {
		sut.start();

		verify(mockBall).move();
		verify(mockPaddle).move();
		verify(mockGameUI).repaint();
	}
}
