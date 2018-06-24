import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setForeground(new Color(128, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 361);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPhoneAdministration = new JMenu("  Phone Info");
		mnPhoneAdministration.setForeground(Color.RED);
		mnPhoneAdministration.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnPhoneAdministration);
		
		JMenuItem mntmAddNewMobil = new JMenuItem("Add New Mobile");
		mntmAddNewMobil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMobil adm=new AddMobil();
				adm.setVisible(true);
				
			}
		});
		mntmAddNewMobil.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnPhoneAdministration.add(mntmAddNewMobil);
		
		JMenuItem mntmSearchForMobil = new JMenuItem("Search  Mobile");
		mntmSearchForMobil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchMobile srcmo = new SearchMobile(); 
				srcmo.setVisible(true);
			}
		});
		mntmSearchForMobil.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnPhoneAdministration.add(mntmSearchForMobil);
		
		JMenuItem mntmUpdata = new JMenuItem("Updata Info");
		mntmUpdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateMobile updm=new UpdateMobile();
				updm.setVisible(true);
				
			}
		});
		mntmUpdata.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnPhoneAdministration.add(mntmUpdata);
		
		JMenuItem mntmDelete = new JMenuItem("Delete  Info");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteMobile demo=new DeleteMobile();
				demo.setVisible(true);
			}
		});
		mntmDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnPhoneAdministration.add(mntmDelete);
		
		JMenu mnCustomerAdministration = new JMenu("   Customer Details");
		mnCustomerAdministration.setForeground(new Color(128, 0, 128));
		mnCustomerAdministration.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnCustomerAdministration);
		
		JMenuItem mntmAddNewCustomer = new JMenuItem("Add New Customer");
		mntmAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddCoustomer addc=new AddCoustomer();
				addc.setVisible(true);
			}
		});
		mntmAddNewCustomer.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnCustomerAdministration.add(mntmAddNewCustomer);
		
		JMenuItem mntmSearchCustomer = new JMenuItem("Search Customer");
		mntmSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchCoustomer srcc=new SearchCoustomer();
				srcc.setVisible(true);
			}
		});
		mntmSearchCustomer.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnCustomerAdministration.add(mntmSearchCustomer);
		
		JMenuItem mntmUpdate = new JMenuItem("Update Details");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateCoustomer upc=new UpdateCoustomer();
				upc.setVisible(true);
			}
		});
		mntmUpdate.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnCustomerAdministration.add(mntmUpdate);
		
		JMenuItem mntmDelete_1 = new JMenuItem("Delete Details");
		mntmDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteCoustomer dec=new DeleteCoustomer();
				dec.setVisible(true);
			}
		});
		mntmDelete_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnCustomerAdministration.add(mntmDelete_1);
		
		JMenu mnBillAdministration = new JMenu("    Bill Information");
		mnBillAdministration.setForeground(Color.ORANGE);
		mnBillAdministration.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnBillAdministration);
		
		JMenuItem mntmGenerateBill = new JMenuItem("Generate Bill");
		mntmGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GenerateBill gebi=new GenerateBill();
				gebi.setVisible(true);
			}
		});
		mntmGenerateBill.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnBillAdministration.add(mntmGenerateBill);
		
		JMenuItem mntmSearchBill = new JMenuItem("Search Bill");
		mntmSearchBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchBill srcbi=new SearchBill();
				srcbi.setVisible(true);
			}
		});
		mntmSearchBill.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnBillAdministration.add(mntmSearchBill);
		
		JMenu mnSalesAdministration = new JMenu("   Sales Report");
		mnSalesAdministration.setForeground(Color.BLUE);
		mnSalesAdministration.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnSalesAdministration);
		
		JMenuItem mntmDailyReport = new JMenuItem("Daily Report");
		mntmDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dailyrep daire=new Dailyrep();
				daire.setVisible(true);
			}
		});
		mntmDailyReport.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnSalesAdministration.add(mntmDailyReport);
		
		JMenuItem mntmMonthlyReport = new JMenuItem("Monthly Report");
		mntmMonthlyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Monthlyrep more=new Monthlyrep();
				more.setVisible(true);
			}
		});
		mntmMonthlyReport.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnSalesAdministration.add(mntmMonthlyReport);
		
		JMenuItem mntmYearlyReport = new JMenuItem("Yearly Report");
		mntmYearlyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Yearlyrep yearep=new Yearlyrep();
				yearep.setVisible(true);
			}
		});
		mntmYearlyReport.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnSalesAdministration.add(mntmYearlyReport);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELLCOME TO OUR PHONE STORE MANAGMENT SYSTEAM");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(25, 143, 658, 95);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/ss.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(236, 22, 187, 135);
		contentPane.add(label);
	}
}
