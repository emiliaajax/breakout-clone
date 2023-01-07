package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BallTest {
  private static final int FRAME_WIDTH = 800;
  private static final int BALL_WIDTH = 20;
  private static final int BALL_HEIGHT = 20;
  private static final int BALL_X_POS = 390;
  private static final int BALL_Y_POS = 450;

  private Ball sut;

  @BeforeEach void setUp () {
    sut = new Ball();
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new Ball());
  }

  @Test void shouldReturnBallWidth() {
    int expected = BALL_WIDTH;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnBallHeight() {
    int expected = BALL_HEIGHT;
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
    int expected = BALL_X_POS;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyForBallYPosition() {
    int expected = BALL_Y_POS;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void ballShouldMoveWhenFunctionIsCalled() {
    sut.move();
    int[] expected = {BALL_X_POS + 1, BALL_Y_POS - 1};
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
    for (int i = 0; i < BALL_Y_POS + 10; i++) {
      sut.move();
    }
    int expected = 1;
    int actual = sut.getYDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheRightWall() {
    for (int i = 0; i < FRAME_WIDTH; i++) {
      sut.move();
    }
    int expected = -1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldChangeDirectionWhenHittingTheLeftWall() {
    for (int i = 0; i < FRAME_WIDTH * 2; i++) {
      sut.move();
    }
    int expected = 1;
    int actual = sut.getXDirection();
    assertEquals(expected, actual);
  }

  @Test void ballShouldResetToInitialWhenMethodCalled() {
    sut.reset();
    int[] expected = {BALL_X_POS, BALL_Y_POS, 1, -1};
    int[] actual = {sut.getXPos(), sut.getYPos(), sut.getXDirection(), sut.getYDirection()};
    assertArrayEquals(expected, actual);
  }
}
