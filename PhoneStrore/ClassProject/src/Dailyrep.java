import java.awt.BorderLayout;
import java.text.*;
import java.awt.print.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;
import javax.swing.text.Document;
import javax.swing.text.ParagraphView;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
public class Dailyrep extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dailyrep frame = new Dailyrep();
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
	
	public Dailyrep() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.GREEN);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 35));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "26", "29", "30"}));
		comboBox.setBounds(108, 46, 90, 39);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("DailyReport");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               try {
					
					String query="select * from DailyR";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ea) {
					ea.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(333, 46, 183, 41);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 139, 588, 151);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header =new MessageFormat("Report Print");
		        MessageFormat footer =new MessageFormat("Page{0,number,integer}");
		      
		        
		        
		        /*import
				  import java.text.*;
                  import java.awt.print.*;
				 */
		        
		        
		        try{
		             table.print(JTable.PrintMode.NORMAL, header, footer);
		           }
		        catch(java.awt.print.PrinterException ex)
		        {
		        System.err.format("Cannot print %s%n", ex.getMessage());
		        }
				
			}
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		btnNewButton_1.setBounds(240, 343, 135, 49);
		contentPane.add(btnNewButton_1);
	}
}
