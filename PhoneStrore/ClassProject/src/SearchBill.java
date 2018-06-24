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

public class SearchBill extends JFrame {

	private JPanel contentPane;
	
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	private JScrollPane scrollPane;
	
	public SearchBill() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 476);
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
					String query="select id,date,name,number,price,paid from BillAd where "+selection+"=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		textField.setBounds(448, 29, 213, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.MAGENTA);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSearch.setBounds(360, 33, 78, 25);
		contentPane.add(lblSearch);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"id", "date", "name", "number", "price", "paid"}));
		comboBox.setBounds(105, 37, 127, 36);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 90, 442, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
