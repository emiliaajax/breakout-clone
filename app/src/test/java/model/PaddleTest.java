package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaddleTest {
	@Test void constructor () {
    assertDoesNotThrow(() -> new Paddle());
  }
}
