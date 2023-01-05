package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class PaddleTest {
  private Paddle sut;

  @BeforeEach void setUp () {
    sut = new Paddle();
  }

	@Test void constructor() {
    assertDoesNotThrow(() -> new Paddle());
  }

  @Test void shouldReturnPaddleWidthOfHundredFifty() {
    int expected = 150;
    int actual = sut.getWidth();

    assertEquals(expected, actual);
  }
}
