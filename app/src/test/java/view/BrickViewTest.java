package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;

import model.Brick;

public class BrickViewTest {
  private Brick mockBrick;
  private Graphics graphics;
  private BrickView sut;

  @BeforeEach void setUp() {
    mockBrick = mock(Brick.class);
    graphics = mock(Graphics.class);
    sut = new BrickView(mockBrick);
  }

  @Test void constructor() {
    assertDoesNotThrow(() -> new BrickView(mockBrick));
  }

  @Test void verifyThatBrickIsPainted() {
    when(mockBrick.getWidth()).thenReturn(30);
    when(mockBrick.getHeight()).thenReturn(20);
    when(mockBrick.getXPos()).thenReturn(50);
    when(mockBrick.getYPos()).thenReturn(50);

    sut.paint(graphics);

    verify(graphics).fillRect(50, 50, 30, 20);
  }
}
