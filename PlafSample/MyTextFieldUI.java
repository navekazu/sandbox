import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class MyTextFieldUI extends BasicTextFieldUI {
  private static final Color GRADATION_START =
      new Color(255, 255, 255, 0);
  private static final Color GRADATION_END =
      new Color(0, 0, 0, 64);

  private final JComponent comp;
  
  public MyTextFieldUI(JComponent comp) {
    if (comp == null) {
      throw new IllegalArgumentException(
        "comp should not be null.");
    }
    this.comp = comp;
  }
  
  public static ComponentUI createUI(JComponent c) {
    return new MyTextFieldUI(c);
  }

  protected void paintBackground(Graphics g) {
    super.paintBackground(g);
    Dimension size = comp.getSize();
    MyLookAndFeelUtil.gradationFill(
        GRADATION_START, GRADATION_END,
        0, 0, size.width, size.height,
        g);
  }
}