package wl.ncb.tudf.view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.Window.Type;

public class AnimateProgress extends JDialog {
	public AnimateProgress() {
		setBackground(Color.RED);
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("\u0E01\u0E33\u0E25\u0E31\u0E07\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25..");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
	}



	  private static int DELAY = 200;

	  Insets insets;

	  Color colors[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
	      Color.BLUE, Color.MAGENTA };

	  public void paint(Graphics g) {
	    super.paint(g);
	    if (insets == null) {
	      insets = getInsets();
	    }
	    // Calculate each time in case of resize
	    int x = insets.left;
	    int y = insets.top;
	    int width = getWidth() - insets.left - insets.right;
	    int height = getHeight() - insets.top - insets.bottom;
	    int start = 0;
	    int steps = colors.length;
	    int stepSize = 360 / steps;
	    synchronized (colors) {
	      for (int i = 0; i < steps; i++) {
	        g.setColor(colors[i]);
	        g.fillArc(x, y, width, height, start, stepSize);
	        start += stepSize;
	      }
	    }
	  }

	  public void go() {
	    TimerTask task = new TimerTask() {
	      public void run() {
	        Color c = colors[0];
	        synchronized (colors) {
	          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
	          colors[colors.length - 1] = c;
	        }
	        repaint();
	      }
	    };
	    Timer timer = new Timer();
	    timer.schedule(task, 0, DELAY);
	  }

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	/*public AnimateProgress() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}*/

}
