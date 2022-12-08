package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
  @Test void constructor () {
    assertDoesNotThrow(() -> new Ball());
  }
}
