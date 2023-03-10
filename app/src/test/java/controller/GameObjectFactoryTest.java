package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameObjectFactoryTest {
  private GameObjectFactory sut;

  @BeforeEach void setUp() {
    sut = new GameObjectFactory();
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new GameObjectFactory());
  }

  @Test void testCreateBall() {
    assertNotNull(sut.createBall());
  }

  @Test void testCreatePaddle() {
    assertNotNull(sut.createPaddle());
  }

  @Test void testCreateBricks() {
    int input = 10;

    assertEquals(sut.createBricks(input).length, input);
  }
}
