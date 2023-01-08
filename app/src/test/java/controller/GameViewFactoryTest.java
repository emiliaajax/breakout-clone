package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class GameViewFactoryTest {
  @Test void constructor() {
    assertDoesNotThrow(() -> new GameViewFactory());
  }
}
