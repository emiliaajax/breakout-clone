package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
  @Test void constructor () {
    assertDoesNotThrow(() -> new Ball());
  }

  @Test void shouldReturnBallWidthOfTen() {
    Ball sut = new Ball();
    int expected = 10;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }
}
