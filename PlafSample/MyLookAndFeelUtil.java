import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

public class MyLookAndFeelUtil {
  public static void gradationFill(
      Color c1, Color c2,
      int x, int y, int width, int height,
      Graphics g) {
    Paint p = new GradientPaint(
      (float)x, (float)y, c1,
      (float)x, (float)(y + height), c2);
    fill(p, x, y, width, height, g);
  }

  public static void fill(
      Paint p,
      int x, int y, int width, int height,
      Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setPaint(p);
    g2d.fill(new Rectangle(x, y, width, height));
  }
}