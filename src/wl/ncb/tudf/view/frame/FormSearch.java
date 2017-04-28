package wl.ncb.tudf.view.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FormSearch extends JInternalFrame {
  private 	JLabel lblUserName;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSearch frame = new FormSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	public FormSearch(String username) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnHelloworld = new JButton("HelloWorld");
		btnHelloworld.setBounds(151, 78, 153, 25);
		getContentPane().add(btnHelloworld);
		
		 lblUserName = new JLabel("");
		lblUserName.setBounds(222, 13, 186, 16);
		lblUserName.setText(username);
		getContentPane().add(lblUserName);

	}

}
