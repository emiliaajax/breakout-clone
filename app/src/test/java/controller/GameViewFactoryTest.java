package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Ball;
import model.Brick;
import model.Paddle;

public class GameViewFactoryTest {
  private GameViewFactory sut;

  @BeforeEach void setUp() {
    sut = new GameViewFactory();
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GameViewFactory());
  }

  @Test void testCreateBallView() {
    Ball mockBall = mock(Ball.class);

    assertNotNull(sut.createBallView(mockBall));
  }

  @Test void testCreatePaddleView() {
    Paddle mockPaddle = mock(Paddle.class);

    assertNotNull(sut.createPaddleView(mockPaddle));
  }

  @Test void testCreateBrickViews() {
    Brick[] mockBricks = mock(Brick[].class);

    assertEquals(sut.createBrickViews(mockBricks).length, mockBricks.length);
  }
}
