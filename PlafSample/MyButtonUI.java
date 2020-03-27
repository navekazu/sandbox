import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class MyButtonUI extends BasicButtonUI {
  private static final Color GRADATION_START =
      new Color(255, 255, 255, 0);
  private static final Color GRADATION_END =
      new Color(0, 0, 0, 64);

  public static ComponentUI createUI(JComponent c) {
    return new MyButtonUI();
  }

  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);
    MyLookAndFeelUtil.gradationFill(
        GRADATION_START, GRADATION_END,
        0, 0, c.getWidth(), c.getHeight(),
        g);
  }
}