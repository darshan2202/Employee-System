package management;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Add_details {

	 JFrame addframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_details window = new Add_details();
					window.addframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addframe = new JFrame();
		
		Color c =new Color(255, 242, 242);
		Color c1=new Color(244, 124, 124);
		Color c2=new Color(239, 159, 159);
		addframe.setResizable(false);
		addframe.setBounds(100, 100, 716, 722);
		addframe.getContentPane().setBackground(c);
		addframe.setTitle("Add details");
		addframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(133, 108, 454, 530);
		panel.setBackground(Color.WHITE);
		addframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Emp ID");
		lblNewLabel_1.setBounds(51, 102, 85, 34);
		lblNewLabel_1.setForeground(c2);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 106, 214, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(51, 147, 107, 45);
		lblNewLabel_2.setForeground(new Color(239, 159, 159));
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 156, 214, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("EMPLOYEE DETAILS");
		lblNewLabel_3.setBounds(51, 37, 232, 34);
		lblNewLabel_3.setForeground(c1);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setBounds(51, 197, 107, 45);
		lblNewLabel_4.setForeground(new Color(239, 159, 159));
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 206, 214, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("<html>Employee<br> Title</html>");
		lblNewLabel_5.setBounds(51, 253, 107, 45);
		lblNewLabel_5.setForeground(new Color(239, 159, 159));
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(186, 255, 214, 34);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Front End Engineer", "Back End Engineer", "Network Architect", "Manager", "Consultant", "IT Support Manager"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setBounds(51, 309, 107, 45);
		lblNewLabel_7.setForeground(new Color(239, 159, 159));
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(186, 316, 214, 24);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Email Address");
		lblNewLabel_7_1.setBounds(51, 359, 127, 45);
		lblNewLabel_7_1.setForeground(new Color(239, 159, 159));
		lblNewLabel_7_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(lblNewLabel_7_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(186, 366, 214, 24);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		final JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setBounds(187, 460, 213, 34);
		btnNewButton_1.setForeground(Color.WHITE);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,first,last,title,address,email;
				id=textField_1.getText();
				first=textField_2.getText();
				last=textField_3.getText();
				title=(String) comboBox.getSelectedItem();
				address=textField_4.getText();
				email=textField_5.getText();
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
					String query="INSERT INTO employee values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					PreparedStatement ps1=con.prepareStatement("SELECT empid from employee where empid=?");
					ps1.setString(1, id);
					ResultSet rs= ps1.executeQuery();
					if(rs.next() && !id.equals(""))
					{
						JOptionPane.showMessageDialog(btnNewButton_1,"Data already exists...");
						addframe.setVisible(false);
						navigate a=new navigate();
						a.navigateframe.setVisible(true);
						con.close();
					}
					else
					{
						if(id.equals(""))
						{
							JOptionPane.showMessageDialog(btnNewButton_1," Fill empid!");
							con.close();
							
						}
						else {
						ps.setString(1, id);
						ps.setString(2, first);
						ps.setString(3, last);
						ps.setString(4, title);
						ps.setString(5, address);
						ps.setString(6, email);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton_1," Details are added !");	
						con.close();
						}
					}
					
				}
				catch(Exception error)
				{
					error.printStackTrace();
				}	
			}
			
		});
		btnNewButton_1.setBackground(c1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u2190 Back");
		btnNewButton_2.setBounds(51, 460, 89, 35);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addframe.setVisible(false);
				navigate a=new navigate();
				a.navigateframe.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(SystemColor.controlDkShadow);
		btnNewButton_2.setBackground(new Color(255, 242, 242));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);

			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(315, 415, 85, 34);
		panel.add(btnNewButton_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 95, 700, 2);
		addframe.getContentPane().add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(133, 28, 454, 56);
		panel_1.setBackground(new Color(248, 248, 255));
		addframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		final JButton btnNewButton = new JButton("Q");
		btnNewButton.setBounds(395, 14, 45, 29);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
				    String query="SELECT empid from employee where empid=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, id);
					ResultSet rs= ps.executeQuery();
					if(rs.next() && !id.equals(""))
					{
						JOptionPane.showMessageDialog(btnNewButton,"Data already exists...");
						con.close();
					}
					else
					{
	                        JOptionPane.showMessageDialog(btnNewButton, "Data does not exists. Fill employee details.");
					}
				}
					catch(Exception error)
					{
						error.printStackTrace();
					}	
					
				}
			
		});
		btnNewButton.setBackground(c1);
		
		textField = new JTextField();
		textField.setBounds(172, 14, 213, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("EMP ID");
		lblNewLabel.setBounds(47, 13, 68, 37);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
