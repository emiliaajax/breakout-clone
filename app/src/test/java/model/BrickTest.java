package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BrickTest {
  @Test void constructor () {
    assertDoesNotThrow(() -> new Brick());
  }

  @Test void shouldReturnBrickWidthOfThirty() {
    Brick sut = new Brick();
    int expected = 30;
    int actual = sut.getWidth();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnBrickHeightOfTwenty() {
    Brick sut = new Brick();
    int expected = 20;
    int actual = sut.getHeight();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroAsInitialXPos() {
    Brick sut = new Brick();
    int expected = 0;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroAsInitialYPos() {
    Brick sut = new Brick();
    int expected = 0;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnHundredAsNewXPosWhenInputIsHundred() {
    Brick sut = new Brick();
    int expected = 100;
    sut.setXPos(100);
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void brickShouldNotBeDestroyedWhenInitalized () {
    Brick sut = new Brick();
    boolean expected = false;
    boolean actual = sut.isDestroyed();
    assertEquals(expected, actual);
  }
}
