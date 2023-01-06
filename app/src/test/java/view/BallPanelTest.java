package view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BallPanelTest {
  @Test void constructor () {
    assertDoesNotThrow(() -> new BallPanel());
  }
}
