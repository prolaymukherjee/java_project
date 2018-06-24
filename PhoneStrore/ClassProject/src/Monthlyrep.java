import java.awt.BorderLayout;
import java.text.*;
import java.awt.print.*;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Monthlyrep extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monthlyrep frame = new Monthlyrep();
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
	
	public Monthlyrep() {
		
		connection=SConnection.DConnector1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"jan", "feb", "mar", "apri", "may", "jun", "july", "aug", "sep", "oct", "nov", "dec"}));
		comboBox.setBounds(97, 32, 80, 29);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("MonthlyReport");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						
						String query="select * from Monthly";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (Exception ea) {
						ea.printStackTrace();
					}
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(362, 32, 177, 39);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 113, 600, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				MessageFormat header =new MessageFormat("Report Print");
		        MessageFormat footer =new MessageFormat("Page{0,number,integer}");
		      
		        
		        /*import
				  import java.text.*;
                import java.awt.print.*;
				 */
		        
		        
		        
		             try{
		               table.print(JTable.PrintMode.NORMAL, header, footer);
		              }
		        catch(java.awt.print.PrinterException e)
		        {
		        System.err.format("Cannot print %s%n", e.getMessage());
		        }
				
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBounds(255, 332, 135, 39);
		contentPane.add(btnNewButton_1);
	}

}
