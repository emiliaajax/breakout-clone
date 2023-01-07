package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import model.Paddle;
import java.awt.event.KeyEvent;

public class PaddleAdapterTest {
  private Paddle mockPaddle;
  private KeyEvent mockEvent;
  private PaddleAdapter sut;

  @BeforeEach void setUp() {
    mockPaddle = mock(Paddle.class);
    mockEvent = mock(KeyEvent.class);

    sut = new PaddleAdapter(mockPaddle);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new PaddleAdapter(mockPaddle));
  }

  @Test void testKeyPressed() {
    sut.keyPressed(mockEvent);

    verify(mockPaddle).onKeyPress(mockEvent);
  }
}
