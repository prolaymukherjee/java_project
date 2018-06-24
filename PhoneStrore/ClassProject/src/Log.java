import java.awt.EventQueue;
import java.sql.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Log {

	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
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
	
	Connection connection=null;
	private JTextField textFieldUn;
	private JPasswordField passwordField;
	
	public Log() {
		initialize();
		connection=SConnection.DConnector1();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(153, 60, 91, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldUn = new JTextField();
		textFieldUn.setBounds(248, 59, 147, 27);
		frame.getContentPane().add(textFieldUn);
		textFieldUn.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(153, 102, 91, 21);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 97, 147, 27);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select * from Lo where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldUn.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					
					int count=0;
					
					while(rs.next()){
						count+=1;
					}
					
					if(count==1){
						JOptionPane.showMessageDialog(null, "Login Successfully");
						frame.dispose();
						Main ma=new Main();
						ma.setVisible(true);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "UserName And PassWord Is Not Correct");
					}
					
					rs.close();
					pst.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnLogin.setBounds(287, 161, 89, 27);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblPhoneStoreLogin = new JLabel(" PHONE STORE LOGIN PAGE ");
		lblPhoneStoreLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPhoneStoreLogin.setForeground(Color.BLUE);
		lblPhoneStoreLogin.setBounds(153, 11, 264, 24);
		frame.getContentPane().add(lblPhoneStoreLogin);
		
	    label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/mo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-57, 11, 179, 215);
		frame.getContentPane().add(label);
	}
}
