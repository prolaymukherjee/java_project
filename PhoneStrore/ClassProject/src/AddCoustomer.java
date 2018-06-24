import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCoustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCoustomer frame = new AddCoustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	Connection connection=null;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public AddCoustomer() {
		
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCoustomerinfo = new JButton("CoustomerInfo");
		btnCoustomerinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
            try {
					
					String query="select * from CoustomerAdd";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCoustomerinfo.setForeground(Color.RED);
		btnCoustomerinfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnCoustomerinfo.setBounds(459, 23, 180, 34);
		contentPane.add(btnCoustomerinfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 85, 388, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblName.setBounds(23, 113, 57, 17);
		contentPane.add(lblName);
		
		JLabel lblCity = new JLabel("city");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(23, 148, 46, 22);
		contentPane.add(lblCity);
		
		JLabel lblTime = new JLabel("time");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTime.setBounds(23, 192, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblPayment = new JLabel("payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPayment.setBounds(23, 223, 81, 29);
		contentPane.add(lblPayment);
		
		JLabel lblCatagory = new JLabel("catagory");
		lblCatagory.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCatagory.setBounds(23, 263, 81, 22);
		contentPane.add(lblCatagory);
		
		textField = new JTextField();
		textField.setBounds(110, 110, 136, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 148, 136, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 188, 136, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 226, 136, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 267, 136, 29);
		contentPane.add(textField_4);
		
		JButton btnAddcoustomer = new JButton("ADDCOUSTOMER");
		btnAddcoustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 try {
						
						String query="insert into CoustomerAdd (name,city,time,payment,catagory) values (?,?,?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Coustomer Data Saved Successfully");
						
						pst.close();
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
	               
				}
				
				
				
			
		});
		btnAddcoustomer.setForeground(Color.RED);
		btnAddcoustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnAddcoustomer.setBounds(55, 348, 191, 41);
		contentPane.add(btnAddcoustomer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"name", "city", "time", "payment", "catagory"}));
		comboBox.setBounds(55, 37, 130, 34);
		contentPane.add(comboBox);
	}
}
