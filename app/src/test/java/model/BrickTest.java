package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BrickTest {
  private static final int BRICK_WIDTH = 80;
  private static final int BRICK_HEIGHT = 40;
  private static final int BRICK_X_POS = 0;
  private static final int BRICK_Y_POS = 0;
  private Brick sut;

  @BeforeEach void setUp() {
    sut = new Brick();
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new Brick());
  }

  @Test void shouldReturnBrickWidth() {
    int expected = BRICK_WIDTH;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnBrickHeight() {
    int expected = BRICK_HEIGHT;
    int actual = sut.getHeight();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnInitialXPos() {
    int expected = BRICK_X_POS;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnInitialYPos() {
    int expected = BRICK_Y_POS;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnHundredAsNewXPosWhenInputIsHundred() {
    int expected = 100;
    sut.setXPos(100);
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnFiftyAsNewYPosWhenInputIsFifty() {
    int expected = 50;
    sut.setYPos(50);
    int actual = sut.getYPos();

    assertEquals(expected, actual);
  }

  @Test void brickDestroyedShouldBeFalseWhenInitalized () {
    boolean expected = false;
    boolean actual = sut.isDestroyed();
    assertEquals(expected, actual);
  }

  @Test void destroyedShouldBeSetToTrueWhenDestroyMethodIsCalled () {
    boolean expected = true;
    sut.destroy();
    boolean actual = sut.isDestroyed();
    assertEquals(expected, actual);
  }
}
