/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tools.dockingpane;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DockingPane test");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        DockingPane dockingPane = new DockingPane();


        dockingPane.addDoc("test", new JLabel("test test."));

        frame.setLayout(new BorderLayout());
        frame.add(dockingPane, BorderLayout.CENTER);
    }
}
