import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchMobile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMobile frame = new SearchMobile();
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
	private JLabel lblSearch;
	private JComboBox comboBox;
	
	public SearchMobile() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(293, 78, 405, 337);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label.setBounds(10, 92, 136, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("price");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_1.setBounds(10, 124, 77, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("number");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_2.setBounds(10, 163, 77, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("color");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_3.setBounds(10, 202, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("ime");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_4.setBounds(10, 244, 106, 14);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(68, 90, 138, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(68, 124, 138, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(68, 163, 138, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(68, 201, 138, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(68, 243, 138, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				

				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select name,price,number,color,ime from MobileAd where "+selection+"=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField_5.getText());
					ResultSet rs=pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
				
			
		});
		textField_5.setBounds(376, 21, 242, 33);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.GREEN);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearch.setBounds(293, 23, 77, 24);
		contentPane.add(lblSearch);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"name", "price", "number", "color", "ime"}));
		comboBox.setBounds(68, 21, 138, 28);
		contentPane.add(comboBox);
	}
}
