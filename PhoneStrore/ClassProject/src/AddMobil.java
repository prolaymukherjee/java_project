import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;

public class AddMobil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMobil frame = new AddMobil();
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public void refreshTable(){
		
		try {
			
			String query="select * from MobileAd";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void fillcomboBox(){
		
        try {
			
			String query="select * from MobileAd";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				comboBox.addItem(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public AddMobil() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnload = new JButton("Mobile Store");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select * from MobileAd";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnload.setForeground(Color.RED);
		btnload.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnload.setBounds(438, 25, 179, 33);
		contentPane.add(btnload);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 79, 384, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEnterMobileName = new JLabel("name");
		lblEnterMobileName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEnterMobileName.setBounds(10, 97, 136, 21);
		contentPane.add(lblEnterMobileName);
		
		textField = new JTextField();
		textField.setBounds(136, 97, 138, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPrice.setBounds(20, 129, 77, 28);
		contentPane.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 136, 138, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumber = new JLabel("number");
		lblNumber.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNumber.setBounds(20, 181, 77, 21);
		contentPane.add(lblNumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 183, 138, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 222, 138, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(136, 273, 138, 28);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("color");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(20, 229, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(20, 280, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                try {
					
					String query="insert into MobileAd (name,price,number,color,ime) values (?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved Successfully");
					
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
                refreshTable();
			}
				
			
		});
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnAdd.setBounds(92, 344, 89, 33);
		contentPane.add(btnAdd);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		comboBox.setBounds(68, 25, 136, 33);
		contentPane.add(comboBox);
		
		refreshTable();
		fillcomboBox();
		
	}
}
