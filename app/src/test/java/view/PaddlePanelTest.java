package view;

import model.Paddle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Graphics;

public class PaddlePanelTest {
  private Paddle mockPaddle;
  private PaddlePanel sut;
  private Graphics graphics;

  @BeforeEach void setUp() {
    mockPaddle = mock(Paddle.class);
    sut = new PaddlePanel(mockPaddle);
    graphics = mock(Graphics.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new PaddlePanel(mockPaddle));
  }

  @Test void verifyThatPaddleIsPainted() {
    when(mockPaddle.getWidth()).thenReturn(150);
    when(mockPaddle.getHeight()).thenReturn(20);
    when(mockPaddle.getXPos()).thenReturn(325);
    when(mockPaddle.getYPos()).thenReturn(20);

    sut.paintComponent(graphics);

    verify(graphics).fillRect(325, 20, 150, 20);
  }
}
