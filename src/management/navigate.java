package management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class navigate {

	 JFrame navigateframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					navigate window = new navigate();
					window.navigateframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public navigate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		navigateframe = new JFrame();
		Color c =new Color(255, 242, 242);
		Color c1=new Color(244, 124, 124);
		navigateframe.getContentPane().setBackground(c);
		navigateframe.setResizable(false);
		navigateframe.setBounds(100, 100, 716, 722);
		navigateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		navigateframe.getContentPane().setLayout(null);
		navigateframe.setTitle("Choose Operations");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(104, 0, 502, 683);
		navigateframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navigateframe.dispose();
				Add_details temp= new Add_details();
				temp.addframe.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("To add records");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(c1);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(113, 66, 284, 71);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEE EMPLOYEE DETAILS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navigateframe.setVisible(false);
				Show_details temp1=new Show_details();
				temp1.showframe.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(c1);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(113, 187, 284, 71);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE DETAILS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_details u=new Update_details();
				u.updateframe.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setToolTipText("Update data");
		btnNewButton_2.setForeground(c1);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(113, 313, 284, 71);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE RECORDS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navigateframe.dispose();
				Delete_details del=new Delete_details();
				del.deleteframe.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(c1);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(113, 448, 284, 71);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navigateframe.setVisible(false);
				MainFront login=new MainFront();
				login.frame.setVisible(true);
				
			}
		});
		btnNewButton_4.setBackground(c1);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(189, 598, 129, 38);
		panel.add(btnNewButton_4);
	}
}
