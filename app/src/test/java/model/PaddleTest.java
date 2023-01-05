package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.awt.event.KeyEvent;
import static org.mockito.Mockito.*;

public class PaddleTest {
  private Paddle sut;

  @BeforeEach void setUp() {
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

  @Test void shouldReturnPaddleHeightOfTwenty() {
    int expected = 20;
    int actual = sut.getHeight();

    assertEquals(expected, actual);
  }

  @Test void shouldReturnThreeHundredTwentyFiveForPaddleXPosition() {
    int expected = 325;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnTwentyForPaddleYPosition() {
    int expected = 20;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroForInitalXDirection() {
    int expected = 0;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }
}
