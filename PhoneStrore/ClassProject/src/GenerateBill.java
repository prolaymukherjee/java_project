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


public class GenerateBill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateBill frame = new GenerateBill();
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
	private JTextField textField_5;
	
	public GenerateBill() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGeneratebillload = new JButton("GenerateBillLoad");
		btnGeneratebillload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 try {
						
						String query="select * from BillAd";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				
			}
		});
		btnGeneratebillload.setForeground(Color.RED);
		btnGeneratebillload.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnGeneratebillload.setBounds(416, 25, 201, 34);
		contentPane.add(btnGeneratebillload);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 87, 416, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"id", "date", "name", "number", "price", "paid"}));
		comboBox.setBounds(56, 25, 114, 34);
		contentPane.add(comboBox);
		
		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(23, 118, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 155, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 192, 60, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(23, 222, 72, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(23, 257, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPaid = new JLabel("paid");
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaid.setBounds(23, 282, 60, 28);
		contentPane.add(lblPaid);
		
		textField = new JTextField();
		textField.setBounds(101, 113, 127, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 148, 127, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 183, 127, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 224, 127, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 256, 127, 24);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(101, 288, 127, 24);
		contentPane.add(textField_5);
		
		JButton btnGeneratebill = new JButton("GenerateBill");
		btnGeneratebill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
						
						String query="insert into BillAd (id,date,name,number,price,paid) values (?,?,?,?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						pst.setString(6, textField_5.getText());
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Generated Data Saved Successfully");
						
						pst.close();
						
						
					} catch (Exception ez) {
						ez.printStackTrace();
					}
				
				
			}
		});
		btnGeneratebill.setForeground(Color.BLUE);
		btnGeneratebill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnGeneratebill.setBounds(56, 351, 152, 48);
		contentPane.add(btnGeneratebill);
	}
}
