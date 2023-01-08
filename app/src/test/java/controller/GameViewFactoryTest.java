package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import model.Ball;

public class GameViewFactoryTest {
  @Test void constructor() {
    assertDoesNotThrow(() -> new GameViewFactory());
  }

  @Test void testCreateBallView() {
    GameViewFactory sut = new GameViewFactory();
    Ball mockBall = mock(Ball.class);

    assertNotNull(sut.createBallView(mockBall));
   }
}
