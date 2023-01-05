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

  @Test void shouldReturnOneForBallInitialHorizontalDirection() {
    Ball sut = new Ball();
    int expected = 1;
    int actual = sut.getXDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnMinusOneForBallInitialVerticalDirection() {
    Ball sut = new Ball();
    int expected = -1;
    int actual = sut.getYDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallXPosition() {
    Ball sut = new Ball();
    int expected = 50;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallYPosition() {
    Ball sut = new Ball();
    int expected = 50;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void ballShouldMoveWhenFunctionIsCalled() {
    Ball sut = new Ball();
    sut.move();
    int[] expected = {51, 49};
    int[] actual = {sut.getXPos(), sut.getYPos()};
    assertArrayEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheCeiling() {
    Ball sut = new Ball();
    for (int i = 0; i < 60; i++) {
      sut.move();
    }
    int expected = 1;
    int actual = sut.getYDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheRightWall() {
    Ball sut = new Ball();
    for (int i = 0; i < 800; i++) {
      sut.move();
    }
    int expected = -1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void xDirectionShouldBeMinusOneWhenDirectionIsChanged() {
    Ball sut = new Ball();
    sut.changeXDir();
    int expected = -1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void yDirectionShouldBeOneWhenDirectionIsChanged() {
    Ball sut = new Ball();
    sut.changeYDir();
    int expected = 1;
    int actual = sut.getYDirection();
    assertEquals(expected, actual);
  }
}
