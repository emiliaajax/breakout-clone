package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaddleTest {
	@Test void constructor () {
    assertDoesNotThrow(() -> new Paddle());
  }

  @Test void shouldReturnPaddleWidthOfHundredFifty() {
    Paddle sut = new Paddle();
    int expected = 150;
    int actual = sut.getWidth();

    assertEquals(expected, actual);
  }
}
