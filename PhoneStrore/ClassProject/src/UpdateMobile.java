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
public class UpdateMobile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMobile frame = new UpdateMobile();
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
	
	
public void refreshTable(){
		
		try {
			
			String query="select * from MobileAd";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public UpdateMobile() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Update Mobile Store Data");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					
				 try {
						
						String query="select * from MobileAd1";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					refreshTable();
				}
				
			
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		button.setBounds(464, 33, 179, 33);
		contentPane.add(button);
		
		JLabel label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label.setBounds(10, 108, 102, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("price");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_1.setBounds(10, 140, 77, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("number");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_2.setBounds(10, 179, 77, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("color");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_3.setBounds(10, 222, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("ime");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_4.setBounds(6, 258, 106, 14);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 106, 138, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 140, 138, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 181, 138, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 221, 138, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 258, 138, 28);
		contentPane.add(textField_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 try {
					
					String query="Update MobileAd1 set name='"+textField.getText()+"' , price='"+textField_1.getText()+"' , number='"+textField_2.getText()+"' , color='"+textField_3.getText()+"' , ime='"+textField_4.getText()+"' where  name='"+textField.getText()+"'";
					
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Update Data Successfully");
					
					pst.close();
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
                 refreshTable(); 
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnUpdate.setBounds(77, 337, 106, 33);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 108, 373, 298);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		refreshTable();
	}
}
