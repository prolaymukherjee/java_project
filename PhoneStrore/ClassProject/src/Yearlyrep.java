import java.awt.BorderLayout;

import java.text.*;
import java.awt.print.*;

import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Yearlyrep extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yearlyrep frame = new Yearlyrep();
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
	
	public Yearlyrep() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"}));
		comboBox.setBounds(95, 43, 91, 30);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("YearlyReport");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
						
						String query="select * from Yearly";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (Exception ea) {
						ea.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(323, 43, 169, 33);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 119, 636, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 /*import
				  import java.text.*;
                  import java.awt.print.*;
				 */
				MessageFormat header =new MessageFormat("Report Print");
		        MessageFormat footer =new MessageFormat("Page{0,number,integer}");
		      
		             try{
		               table.print(JTable.PrintMode.NORMAL, header, footer);
		              }
		             catch(java.awt.print.PrinterException ez)
		             {
		                  System.err.format("Cannot print %s%n", ez.getMessage());
		              }
				
				
			}
		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnNewButton_1.setBounds(217, 323, 142, 43);
		contentPane.add(btnNewButton_1);
	}

}
