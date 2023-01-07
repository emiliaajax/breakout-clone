package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.awt.event.KeyEvent;
import static org.mockito.Mockito.*;

public class PaddleTest {
  private static final int FRAME_WIDTH = 800;
  private static final int PADDLE_WIDTH = 150;
  private static final int PADDLE_HEIGHT = 20;
  private static final int PADDLE_INIT_X_POS = 325;
  private static final int PADDLE_INIT_Y_POS = 520;

  private Paddle sut;

  @BeforeEach void setUp() {
    sut = new Paddle();
  }

	@Test void constructor() {
    assertDoesNotThrow(() -> new Paddle());
  }

  @Test void shouldReturnPaddleWidthOfHundredFifty() {
    int expected = PADDLE_WIDTH;
    int actual = sut.getWidth();

    assertEquals(expected, actual);
  }

  @Test void shouldReturnPaddleHeightOfTwenty() {
    int expected = PADDLE_HEIGHT;
    int actual = sut.getHeight();

    assertEquals(expected, actual);
  }

  @Test void shouldReturnThreeHundredTwentyFiveForPaddleXPosition() {
    int expected = PADDLE_INIT_X_POS;
    int actual = sut.getXPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnTwentyForPaddleYPosition() {
    int expected = PADDLE_INIT_Y_POS;
    int actual = sut.getYPos();
    
    assertEquals(expected, actual);
  }

  @Test void shouldReturnZeroForInitalXDirection() {
    int expected = 0;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }

  @Test void testOnKeyRelease_leftKey() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);

    sut.moveLeft();
    sut.onKeyRelease(mockEvent);

    int expected = 0;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }

  @Test void testOnKeyRelease_rightKey() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

    sut.moveRight();
    sut.onKeyRelease(mockEvent);

    int expected = 0;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }

  @Test void testOnKeyPress_leftKey() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);

    sut.onKeyPress(mockEvent);

    int expected = -2;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }

  @Test void testOnKeyPress_rightKey() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

    sut.onKeyPress(mockEvent);

    int expected = 2;
    int actual = sut.getXDirection();

    assertEquals(expected, actual);
  }

  @Test void paddlePositionShouldNotChangeWhenKeyIsNotPressed() {
    sut.move();

    int expected = PADDLE_INIT_X_POS;
    int actual = sut.getXPos();

    assertEquals(expected, actual);
  }

  @Test void paddlePositionShouldDecreaseOnLeftKeyPress() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);

    sut.onKeyPress(mockEvent);
    sut.move();

    int expected = PADDLE_INIT_X_POS - 1;
    int actual = sut.getXPos();

    assertEquals(expected, actual);
  }

  @Test void paddlePositionShouldIncreaseOnRightKeyPress() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

    sut.onKeyPress(mockEvent);
    sut.move();

    int expected = PADDLE_INIT_X_POS + 1;
    int actual = sut.getXPos();

    assertEquals(expected, actual);
  }

  @Test void paddleShouldStopMovingWhenHittingTheRightWall() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

    for (int i = 0; i < PADDLE_INIT_X_POS + 200; i++) {
      sut.onKeyPress(mockEvent);
      sut.move();
    }

    int expected = FRAME_WIDTH - PADDLE_WIDTH;
    int actual = sut.getXPos();

    assertEquals(expected, actual);
  }

  @Test void paddleShouldStopMovingWhenHittingTheLeftWall() {
    KeyEvent mockEvent = mock(KeyEvent.class);
    when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);

    for (int i = 0; i < PADDLE_INIT_X_POS + 200; i++) {
      sut.onKeyPress(mockEvent);
      sut.move();
    }

    int expected = 0;
    int actual = sut.getXPos();

    assertEquals(expected, actual);
  }

  @Test void paddleShouldResetToInitialWhenMethodCalled() {
    sut.reset();
    int[] expected = {PADDLE_INIT_X_POS, PADDLE_INIT_Y_POS, 0};
    int[] actual = {sut.getXPos(), sut.getYPos(), sut.getXDirection()};
    assertArrayEquals(expected, actual);
  }
}
