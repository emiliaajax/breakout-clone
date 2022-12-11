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
}
