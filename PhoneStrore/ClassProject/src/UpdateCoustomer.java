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


public class UpdateCoustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCoustomer frame = new UpdateCoustomer();
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
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnUpdateinfo;
	
	
	public UpdateCoustomer() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("UpdateCoustomerInfo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select * from CoustomerAdd";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(420, 26, 260, 53);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 115, 394, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(23, 116, 57, 17);
		contentPane.add(label);
		
		label_1 = new JLabel("city");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(23, 158, 46, 22);
		contentPane.add(label_1);
		
		label_2 = new JLabel("time");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(23, 208, 46, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("payment");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(23, 253, 81, 29);
		contentPane.add(label_3);
		
		label_4 = new JLabel("catagory");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(23, 306, 81, 22);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 109, 136, 29);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 164, 136, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 204, 136, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 253, 136, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(114, 306, 136, 29);
		contentPane.add(textField_4);
		
		btnUpdateinfo = new JButton("UpdateInfo");
		btnUpdateinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
						
						String query="update CoustomerAdd set name='"+textField.getText()+"',city='"+textField_1.getText()+"',time='"+textField_2.getText()+"',payment='"+textField_3.getText()+"',catagory='"+textField_4.getText()+"' where  name='"+textField.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Update Coustomer Data Successfully");
						
						pst.close();
						
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
	                 
				}
				
			
		});
		btnUpdateinfo.setForeground(Color.RED);
		btnUpdateinfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnUpdateinfo.setBounds(77, 369, 149, 36);
		contentPane.add(btnUpdateinfo);
	}

}
