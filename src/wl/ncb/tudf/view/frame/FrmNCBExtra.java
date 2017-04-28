package wl.ncb.tudf.view.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Paint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import wl.ncb.tudf.test.GradientTranslucentWindowDemo;

public class FrmNCBExtra extends JInternalFrame {
	private JTextField txtHpNo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FrmNCBExtra(String pUserName) {
	
		    getContentPane().add(new JLabel(pUserName), BorderLayout.CENTER);
			setBounds(100, 2, 1024, 786);
		    setResizable(true);
		    setClosable(true);
		    setMaximizable(true);
		    setIconifiable(true);
		    setTitle(pUserName);
		    setVisible(true);
	     	getContentPane().setLayout(null);
	     	
	     	
	     	
	     	
	        // Determine what the GraphicsDevice can support.
	        GraphicsEnvironment ge = 
	            GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice gd = ge.getDefaultScreenDevice();
	        boolean isPerPixelTranslucencySupported = 
	            gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

	        //If translucent windows aren't supported, exit.
	        if (!isPerPixelTranslucencySupported) {
	            System.out.println(
	                "Per-pixel translucency is not supported");
	                System.exit(0);
	        }
	       

	     //   JFrame.setDefaultLookAndFeelDecorated(true);

	        // Create the GUI on the event-dispatching thread
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	FrmNCBExtra gtw = new
	            			FrmNCBExtra("test");

	                // Display the window.
	                gtw.setVisible(true);
	            }
	        });
	     	
	     	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(12, 110, 969, 58);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHpNo = new JLabel("\u0E40\u0E25\u0E02\u0E2A\u0E31\u0E0D\u0E0D\u0E32 :");
		lblHpNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHpNo.setBounds(12, 13, 88, 32);
		panel.add(lblHpNo);
		
		JButton btnFind = new JButton("\u0E14\u0E36\u0E07\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFind.setBounds(283, 17, 97, 30);
		panel.add(btnFind);
		
		txtHpNo = new JTextField();
		txtHpNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHpNo.setBounds(103, 18, 168, 30);
		panel.add(txtHpNo);
		txtHpNo.setColumns(10);
		
		JLabel label = new JLabel("#\u0E04\u0E49\u0E19\u0E2B\u0E32");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(12, 84, 88, 32);
		getContentPane().add(label);
		
		JPanel panel_1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 200;
                    final int G = 200;
                    final int B = 200;

                    Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                            0.0f, getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        panel_1.setLayout(new GridBagLayout());
		panel_1.setForeground(Color.WHITE);
	    panel_1.setBackground(new Color(205, 92, 92));
		panel_1.setBounds(12, 13, 969, 58);
		getContentPane().add(panel_1);
		
		JLabel lblncbmonthly = new JLabel("[/] \u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E1E\u0E34\u0E40\u0E28\u0E29\u0E2A\u0E48\u0E07NCB (Monthly)");
		lblncbmonthly.setForeground(new Color(0, 0, 128));
		lblncbmonthly.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblncbmonthly.setBounds(231, 13, 450, 32);
		panel_1.add(lblncbmonthly);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 230, 140));
		panel_2.setBounds(12, 209, 969, 516);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHpNo_1 = new JLabel("HP NO :");
		lblHpNo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHpNo_1.setBounds(12, 13, 61, 32);
		panel_2.add(lblHpNo_1);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_13.setColumns(10);
		textField_13.setBounds(74, 14, 168, 30);
		panel_2.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_14.setColumns(10);
		textField_14.setBounds(350, 14, 168, 30);
		panel_2.add(textField_14);
		
		JLabel lblBillsub = new JLabel("Bill/Sub :");
		lblBillsub.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillsub.setBounds(265, 13, 73, 32);
		panel_2.add(lblBillsub);
		
		JLabel label_2 = new JLabel("\u0E40\u0E25\u0E02\u0E1A\u0E31\u0E15\u0E23\u0E1B\u0E23\u0E30\u0E0A\u0E32\u0E0A\u0E19. :");
		label_2.setBounds(194, 81, 144, 32);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 82, 168, 30);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel label_3 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D :");
		label_3.setBounds(23, 120, 50, 32);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 121, 168, 30);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel label_4 = new JLabel("\u0E19\u0E32\u0E21\u0E2A\u0E01\u0E38\u0E25 :");
		label_4.setBounds(265, 120, 73, 32);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(350, 121, 168, 30);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel label_5 = new JLabel("\u0E27\u0E31\u0E19\u0E40\u0E01\u0E34\u0E14 :");
		label_5.setBounds(22, 165, 64, 32);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 167, 168, 30);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JLabel label_6 = new JLabel("\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E481 :");
		label_6.setBounds(23, 210, 58, 32);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(85, 210, 433, 70);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JLabel label_7 = new JLabel("\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E482 :");
		label_7.setBounds(22, 293, 50, 32);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(85, 293, 433, 70);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		panel_2.add(textField_6);
		
		JLabel label_8 = new JLabel("\u0E41\u0E02\u0E27\u0E07 :");
		label_8.setBounds(22, 376, 64, 32);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(85, 376, 168, 30);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		panel_2.add(textField_7);
		
		JLabel label_9 = new JLabel("\u0E40\u0E02\u0E15 :");
		label_9.setBounds(265, 376, 50, 32);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(316, 377, 168, 30);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		panel_2.add(textField_8);
		
		JLabel label_10 = new JLabel("\u0E08\u0E31\u0E07\u0E2B\u0E27\u0E31\u0E14 :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(22, 419, 64, 32);
		panel_2.add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBounds(85, 419, 168, 30);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_10.setColumns(10);
		textField_10.setBounds(316, 420, 168, 30);
		panel_2.add(textField_10);
		
		JLabel label_11 = new JLabel("\u0E23\u0E2B\u0E31\u0E2A :");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(265, 419, 50, 32);
		panel_2.add(label_11);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		panel_3.setBounds(524, 13, 433, 490);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E2D\u0E19\u0E38\u0E21\u0E31\u0E15\u0E34 :");
		label_1.setBounds(48, 13, 77, 32);
		panel_3.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(164, 14, 168, 30);
		panel_3.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JLabel lblnfv = new JLabel("\u0E22\u0E2D\u0E14\u0E01\u0E39\u0E49(NFV) :");
		lblnfv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnfv.setBounds(48, 92, 97, 32);
		panel_3.add(lblnfv);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_15.setColumns(10);
		textField_15.setBounds(164, 93, 168, 30);
		panel_3.add(textField_15);
		
		JLabel label_12 = new JLabel("\u0E22\u0E2D\u0E14\u0E2B\u0E19\u0E35\u0E49\u0E04\u0E07\u0E40\u0E2B\u0E25\u0E37\u0E2D :");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_12.setBounds(48, 129, 120, 32);
		panel_3.add(label_12);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_16.setColumns(10);
		textField_16.setBounds(164, 136, 168, 30);
		panel_3.add(textField_16);
		
		JLabel label_13 = new JLabel("\u0E04\u0E48\u0E32\u0E07\u0E27\u0E14 :");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(48, 174, 97, 32);
		panel_3.add(label_13);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_17.setColumns(10);
		textField_17.setBounds(164, 175, 168, 30);
		panel_3.add(textField_17);
		
		JLabel label_14 = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19\u0E07\u0E27\u0E14 :");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_14.setBounds(48, 213, 97, 32);
		panel_3.add(label_14);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_18.setColumns(10);
		textField_18.setBounds(164, 214, 168, 30);
		panel_3.add(textField_18);
		
		JLabel label_15 = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E08\u0E48\u0E32\u0E22\u0E25\u0E48\u0E32\u0E2A\u0E38\u0E14 :");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_15.setBounds(48, 253, 97, 32);
		panel_3.add(label_15);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_19.setColumns(10);
		textField_19.setBounds(164, 254, 168, 30);
		panel_3.add(textField_19);
		
		JLabel label_16 = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E40\u0E23\u0E34\u0E48\u0E21\u0E04\u0E49\u0E32\u0E07 :");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_16.setBounds(48, 293, 97, 32);
		panel_3.add(label_16);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_20.setColumns(10);
		textField_20.setBounds(164, 294, 168, 30);
		panel_3.add(textField_20);
		
		JLabel lblNcbStatus = new JLabel("NCB STATUS :");
		lblNcbStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNcbStatus.setBounds(48, 330, 106, 32);
		panel_3.add(lblNcbStatus);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_21.setColumns(10);
		textField_21.setBounds(164, 331, 168, 30);
		panel_3.add(textField_21);
		
		JLabel lblCoBorrow_1 = new JLabel("Co -Borrow :");
		lblCoBorrow_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCoBorrow_1.setBounds(48, 54, 106, 32);
		panel_3.add(lblCoBorrow_1);
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_22.setColumns(10);
		textField_22.setBounds(164, 55, 168, 30);
		panel_3.add(textField_22);
		
		JButton button = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 0));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(755, 177, 97, 30);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 0, 0));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(873, 177, 97, 30);
		getContentPane().add(button_1);

	}
}
