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

public class DeleteCoustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCoustomer frame = new DeleteCoustomer();
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
	private JButton btnDeletedata;
	
	
	public DeleteCoustomer() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeletecoustomerinfo = new JButton("DeleteCoustomerInfo");
		btnDeletecoustomerinfo.addActionListener(new ActionListener() {
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
		btnDeletecoustomerinfo.setForeground(Color.RED);
		btnDeletecoustomerinfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDeletecoustomerinfo.setBounds(455, 39, 207, 37);
		contentPane.add(btnDeletecoustomerinfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 100, 418, 328);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(10, 111, 57, 17);
		contentPane.add(label);
		
		label_1 = new JLabel("city");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(10, 157, 46, 22);
		contentPane.add(label_1);
		
		label_2 = new JLabel("time");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(10, 208, 46, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("payment");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(10, 248, 81, 29);
		contentPane.add(label_3);
		
		label_4 = new JLabel("catagory");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(10, 299, 81, 22);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 108, 136, 29);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 157, 136, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 204, 136, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 251, 136, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 303, 136, 29);
		contentPane.add(textField_4);
		
		btnDeletedata = new JButton("DELETEDATA");
		btnDeletedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						
						String query="delete from CoustomerAdd where name='"+ textField.getText()+"' ";
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Coustomer Data Is Deleted");
						
						pst.close();
						
						
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				
			}
		});
		btnDeletedata.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDeletedata.setForeground(Color.RED);
		btnDeletedata.setBounds(44, 369, 159, 29);
		contentPane.add(btnDeletedata);
	}

}
