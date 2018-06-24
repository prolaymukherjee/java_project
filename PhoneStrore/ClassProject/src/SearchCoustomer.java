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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchCoustomer extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCoustomer frame = new SearchCoustomer();
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
	private JTable table;
	
	public SearchCoustomer() {
		
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select name,city,time,payment,catagory from CoustomerAdd where "+selection+"=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		textField.setBounds(441, 27, 227, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.ORANGE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSearch.setBounds(348, 35, 96, 20);
		contentPane.add(lblSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 89, 359, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"name", "city", "time", "payment", "catagory"}));
		comboBox.setBounds(55, 35, 161, 34);
		contentPane.add(comboBox);
	}

}
