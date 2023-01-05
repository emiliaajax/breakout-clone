package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BallTest {
  private Ball sut;

  @BeforeEach void setUp () {
    sut = new Ball();
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new Ball());
  }

  @Test void shouldReturnBallWidthOfTen() {
    int expected = 10;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnBallHeightOfTen() {
    int expected = 10;
    int actual = sut.getHeight();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnOneForBallInitialHorizontalDirection() {
    int expected = 1;
    int actual = sut.getXDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnMinusOneForBallInitialVerticalDirection() {
    int expected = -1;
    int actual = sut.getYDirection();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallXPosition() {
    int expected = 50;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallYPosition() {
    int expected = 50;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void ballShouldMoveWhenFunctionIsCalled() {
    sut.move();
    int[] expected = {51, 49};
    int[] actual = {sut.getXPos(), sut.getYPos()};
    assertArrayEquals(expected, actual);
  }

  @Test void xDirectionShouldBeMinusOneWhenDirectionIsChanged() {
    sut.changeXDir();
    int expected = -1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void yDirectionShouldBeOneWhenDirectionIsChanged() {
    sut.changeYDir();
    int expected = 1;
    int actual = sut.getYDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheCeiling() {
    for (int i = 0; i < 60; i++) {
      sut.move();
    }
    int expected = 1;
    int actual = sut.getYDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheRightWall() {
    for (int i = 0; i < 800; i++) {
      sut.move();
    }
    int expected = -1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheLeftWall() {
    for (int i = 0; i < 1600; i++) {
      sut.move();
    }
    int expected = 1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldResetToInitialWhenMethodCalled() {
    sut.reset();
    int[] expected = {50, 50, 1, -1};
    int[] actual = {sut.getXPos(), sut.getYPos(), sut.getXDirection(), sut.getYDirection()};
    assertArrayEquals(expected, actual);
  }
}
