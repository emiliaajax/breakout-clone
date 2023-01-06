package view;

import model.Paddle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Graphics;

public class PaddleViewTest {
  private Paddle mockPaddle;
  private Graphics graphics;
  private PaddleView sut;

  @BeforeEach void setUp() {
    mockPaddle = mock(Paddle.class);
    graphics = mock(Graphics.class);
    sut = new PaddleView(mockPaddle);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new PaddleView(mockPaddle));
  }

  @Test void verifyThatPaddleIsPainted() {
    when(mockPaddle.getWidth()).thenReturn(150);
    when(mockPaddle.getHeight()).thenReturn(20);
    when(mockPaddle.getXPos()).thenReturn(325);
    when(mockPaddle.getYPos()).thenReturn(20);

    sut.paint(graphics);

    verify(graphics).fillRect(325, 20, 150, 20);
  }
}
