package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Brick;

public class BrickPanelTest {
  private Brick mockBrick;

  @BeforeEach void setUp () {
    Brick mockBrick = mock(Brick.class);
  }

  @Test void constructor () {
    assertDoesNotThrow(() -> new BrickPanel(mockBrick));
  }
}
