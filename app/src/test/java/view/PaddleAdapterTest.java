package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import model.Paddle;

public class PaddleAdapterTest {
  private Paddle mockPaddle;

  @BeforeEach void setUp() {
    mockPaddle = mock(Paddle.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new PaddleAdapter(mockPaddle));
  }
}
