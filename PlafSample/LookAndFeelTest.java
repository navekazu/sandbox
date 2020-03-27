import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LookAndFeelTest {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(new MyLookAndFeel());
    } catch (Exception e) {
    }
  
    JFrame frame = new JFrame("Look & Feel ÉTÉìÉvÉã");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    
    JTextField textField = new JTextField(10);
    JButton button = new JButton("åüçı");

    frame.getContentPane().add(panel);

    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.add(Box.createHorizontalGlue());
    panel.add(textField);
    panel.add(Box.createHorizontalStrut(5));
    panel.add(button);
    panel.add(Box.createHorizontalGlue());
    
    frame.pack();
    frame.setVisible(true);
  }
}
