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

public class DeleteMobile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMobile frame = new DeleteMobile();
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
	private JTable table;
	
	public DeleteMobile() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeleteDataFrom = new JButton("Delete Data From Store");
		btnDeleteDataFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
             try {
					
					String query="select * from MobileAd";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnDeleteDataFrom.setForeground(Color.RED);
		btnDeleteDataFrom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDeleteDataFrom.setBounds(408, 25, 257, 33);
		contentPane.add(btnDeleteDataFrom);
		
		JLabel label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label.setBounds(10, 100, 136, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("price");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_1.setBounds(10, 132, 77, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("number");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_2.setBounds(10, 171, 77, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("color");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_3.setBounds(10, 215, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("ime");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_4.setBounds(10, 252, 106, 14);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 98, 138, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 132, 138, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 171, 138, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(69, 214, 138, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(69, 251, 138, 28);
		contentPane.add(textField_4);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
						
						String query="delete from MobileAd where name='"+ textField.getText()+"' ";
						PreparedStatement pst=connection.prepareStatement(query);
						
				
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Data Is Deleted");
						
						pst.close();
						
						
					} catch (Exception e3) {
						e3.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(69, 323, 123, 33);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 100, 402, 321);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
