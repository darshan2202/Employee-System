package management;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
public class MainFront {

	 JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFront window = new MainFront();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFront() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		Color c =new Color(255, 242, 242);
		Color c1=new Color(244, 124, 124);
		Color c2=new Color(239, 159, 159);
		frame.getContentPane().setBackground(c);
		frame.setBounds(100, 100, 716, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 358, 683);
		panel.setBackground(c1);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setTitle("Welcome to Employee Management System");
		
		JLabel label1 = new JLabel("<html>EMPLOYEE<br> MANAGEMENT</html>");
		label1.setBounds(39, 94, 274, 86);
		panel.add(label1);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(c);
		label1.setFont(new Font("Tahoma", Font.BOLD, 37));
		
		JLabel lblNewLabel = new JLabel("<html>- Store Employee Details <br>- Update details <br>- Delete details <br>- Display details <br>- Filter data\r\n</html>");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel.setForeground(c);
		lblNewLabel.setBounds(23, 268, 290, 220);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN IN");
		lblNewLabel_1.setBounds(447, 100, 154, 55);
		lblNewLabel_1.setForeground(c1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(425, 295, 200, 29);
		textField.setToolTipText("Enter username");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(425, 259, 97, 25);
		lblNewLabel_2.setForeground(c2);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(425, 350, 97, 25);
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(c2);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JButton loginbutton = new JButton("LOG IN");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username_check = textField.getText();
				String password_check= passwordField.getText();
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
				    String query="SELECT username, password from login where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, username_check);
					ps.setString(2, password_check);
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(loginbutton,"Successfully Logged In");
						frame.setVisible(false);
						navigate n=new navigate();
						n.navigateframe.setVisible(true);
						con.close();
					}
					else
					{
	                        JOptionPane.showMessageDialog(loginbutton, "Wrong Username or Password");
					}
				}
					catch(Exception error)
					{
						error.printStackTrace();
					}	
					
				}
			
			
		});
		loginbutton.setBounds(425, 459, 200, 33);
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginbutton.setBackground(c1);
		loginbutton.setBorderPainted(false);
		loginbutton.setForeground(c);
		frame.getContentPane().add(loginbutton);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have an account?");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(425, 521, 182, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				signup s1= new signup();
				s1.signupframe.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(new Color(105, 105, 105));
		btnNewButton_1.setBackground(c);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(425, 572, 200, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(425, 386, 200, 29);
		frame.getContentPane().add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(386, 217, 277, 421);
		frame.getContentPane().add(panel_1);
	}
	
}
