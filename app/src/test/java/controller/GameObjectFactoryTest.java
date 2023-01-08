package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class GameObjectFactoryTest {
  @Test void constructor() {
    assertDoesNotThrow(() -> new GameObjectFactory());
  }

  @Test void testCreateBall() {
    GameObjectFactory sut = new GameObjectFactory();

    assertNotNull(sut.createBall());
  }
}
