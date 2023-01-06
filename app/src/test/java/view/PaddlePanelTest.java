package view;

import model.Paddle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaddlePanelTest {
  private Paddle mockPaddle;

  @BeforeEach void setUp() {
    mockPaddle = mock(Paddle.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new PaddlePanel(mockPaddle));
  }
}
