package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BrickTest {
  private Brick sut;

  @BeforeEach void setUp() {
    sut = new Brick();
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new Brick());
  }

  @Test void shouldReturnBrickWidthOfThirty() {
    int expected = 30;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnBrickHeightOfTwenty() {
    int expected = 20;
    int actual = sut.getHeight();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroAsInitialXPos() {
    int expected = 0;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroAsInitialYPos() {
    int expected = 0;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnHundredAsNewXPosWhenInputIsHundred() {
    int expected = 100;
    sut.setXPos(100);
    int actual = sut.getXPos();
    
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
