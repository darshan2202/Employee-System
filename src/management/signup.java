package management;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;


public class signup extends MainFront {

    JFrame signupframe;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField user;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.signupframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		Color c =new Color(255, 242, 242);
		Color c1=new Color(244, 124, 124);
	  
		signupframe = new JFrame();
		signupframe.setResizable(false);
		signupframe.setAutoRequestFocus(false);
		signupframe.setBounds(100, 100, 716, 722);
		signupframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signupframe.getContentPane().setBackground(c);
		signupframe.getContentPane().setLayout(null);
		signupframe.setTitle("Create account");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(116, 48, 485, 560);
		signupframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setBounds(55, 27, 172, 51);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(c1);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 127, 162, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(227, 122, 215, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setForeground(new Color(105, 105, 105));
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(55, 267, 162, 21);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Must be more than 8 characters");
		passwordField.setBounds(227, 262, 215, 29);
		panel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Username");
		lblNewLabel_3.setForeground(new Color(105, 105, 105));
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(55, 196, 159, 21);
		panel.add(lblNewLabel_3);
		
		user = new JTextField();
		user.setToolTipText("Include numbers too");
		user.setBounds(226, 191, 216, 29);
		panel.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Repeat Password\r\n");
		lblNewLabel_2_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(55, 332, 162, 21);
		panel.add(lblNewLabel_2_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Confirm password");
		passwordField_1.setBounds(227, 327, 215, 29);
		panel.add(passwordField_1);
		
		final JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username,password,name,repeat;
				username=user.getText();
				password=passwordField.getText();
				name=textField.getText();
				repeat=passwordField_1.getText();
				if(repeat.equals(password))
				{
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
					String query="INSERT INTO login values(?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, name);
					int x=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton,x+" Account is created");	
					con.close();
					signupframe.dispose();
					MainFront login=new MainFront();
					login.frame.setVisible(true);
				}
				catch(Exception error)
				{
					error.printStackTrace();
				}	
			
				}
				else
				{
					JOptionPane.showMessageDialog(passwordField_1,"Password does not match");
				}
			}
			
		});
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(c1);
		btnNewButton.setForeground(c);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(227, 424, 215, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("\u2190 LOG IN");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupframe.dispose();
				MainFront login=new MainFront();
				login.frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setToolTipText("Go back to login");
		btnNewButton_1_1.setForeground(SystemColor.controlDkShadow);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBackground(new Color(255, 242, 242));
		btnNewButton_1_1.setBounds(55, 426, 159, 40);
		panel.add(btnNewButton_1_1);
		
	}

}
