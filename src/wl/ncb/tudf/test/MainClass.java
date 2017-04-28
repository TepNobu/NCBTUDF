package wl.ncb.tudf.test;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MainClass {
  public static void main(String args[]) {
    JFrame f = new JFrame("Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLayeredPane desktop = new JDesktopPane();
    desktop.setOpaque(false);
    desktop.add(new SelfInternalFrame("1"), JLayeredPane.POPUP_LAYER);
    f.add(desktop, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);
  }

}

class SelfInternalFrame extends JInternalFrame {
  public SelfInternalFrame(String s) {
    getContentPane().add(new JLabel(s), BorderLayout.CENTER);
    setBounds(50, 50, 100, 100);
    setResizable(true);
    setClosable(true);
    setMaximizable(true);
    setIconifiable(true);
    setTitle(s);
    setVisible(true);
  }
}