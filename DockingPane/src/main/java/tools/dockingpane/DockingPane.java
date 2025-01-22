package tools.dockingpane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class DockingPane extends JPanel {
    JDesktopPane desktopPane = new JDesktopPane();

    public DockingPane() {
        initComponent();
    }

    private void initComponent() {
        setLayout(new BorderLayout());

        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

    }

    public Component addDoc(String title, Component comp) {
        JInternalFrame f = new JInternalFrame(title, true);
        f.add(comp);
        f.pack();
        f.setVisible(true);

        desktopPane.add(f);
        return comp;
    }
}
