package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;

import model.Brick;

public class BrickPanelTest {
  private Brick mockBrick;
  private Graphics graphics;
  private BrickPanel sut;

  @BeforeEach void setUp() {
    mockBrick = mock(Brick.class);
    sut = new BrickPanel(mockBrick);
    graphics = mock(Graphics.class);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new BrickPanel(mockBrick));
  }

  @Test void paintComponent() {
    when(mockBrick.getWidth()).thenReturn(30);
    when(mockBrick.getHeight()).thenReturn(20);
    when(mockBrick.getXPos()).thenReturn(50);
    when(mockBrick.getYPos()).thenReturn(50);

    sut.paintComponent(graphics);

    verify(graphics).fillOval(50, 50, 30, 20);
  }
}
