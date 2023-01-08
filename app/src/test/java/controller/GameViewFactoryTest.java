package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class GameViewFactoryTest {
  @Test void constructor() {
    assertDoesNotThrow(() -> new GameViewFactory());
  }

  @Test void testCreateBallView() {
    GameViewFactory sut = new GameViewFactory();

    assertNotNull(sut.createBallView());
   }
}
