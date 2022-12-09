// package view;

// import javax.swing.JFrame;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class GameUITest {
//   class JFrameStub extends JFrame {
//     private int x;
//     private int y;
//     private int width;
//     private int height;
//     private String title;
//     private boolean resizable;
//     private boolean visible;
//     private String EXIT_ON_CLOSE = "Exited";

//     @Override
//     public void setBounds(int x, int y, int width, int height) {
//       this.x = x;
//       this.y = y;
//       this.width = width;
//       this.height = height;
//     }

//     @Override
//     public int getWidth() {
//       return width;
//     }

//     @Override
//     public void setTitle(String title) {
//       this.title = title;
//     }

//     @Override
//     public void setResizable(boolean resizable) {
//       this.resizable = resizable;
//     }

//     @Override
//     public void setVisible(boolean visible) {
//       this.visible = visible;
//     }
//   }

//   @Test void constructor () {
//     assertDoesNotThrow(() -> new GameUI(new JFrameStub()));
//   }

//   @Test void shouldReturnEightHundredForWidthOfFrame () {
//     GameUI sut = new GameUI(new JFrameStub());
//     final int expected = 800;
//     final int actual = sut.getFrame().getWidth();

//     assertEquals(expected, actual);
//   }
// }
