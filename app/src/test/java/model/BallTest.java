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

  @Test void shouldReturnBallHeightOfTen() {
    Ball sut = new Ball();
    int expected = 10;
    int actual = sut.getHeight();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnOneForBallHorizontalDirection() {
    Ball sut = new Ball();
    int expected = 1;
    int actual = sut.getHorizontalDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnMinusOneForBallVerticalDirection() {
    Ball sut = new Ball();
    int expected = -1;
    int actual = sut.getVerticalDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallXPosition() {
    Ball sut = new Ball();
    int expected = 50;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }
}
