import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class moviemanager_gui {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moviemanager_gui window = new moviemanager_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public moviemanager_gui() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		frame.getContentPane().add(login, "name_197615222529489");
		login.setLayout(null);
		
		JLabel lblMovieManagementSoftware = new JLabel("Movie Management Software");
		lblMovieManagementSoftware.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblMovieManagementSoftware.setBounds(314, 70, 399, 50);
		login.add(lblMovieManagementSoftware);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(329, 208, 115, 37);
		login.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(329, 263, 115, 37);
		login.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(454, 214, 208, 32);
		login.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(454, 269, 208, 32);
		login.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				movie();
			}
		});
		btnLogin.setBounds(454, 331, 89, 23);
		login.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnClear.setBounds(573, 331, 89, 23);
		login.add(btnClear);
		
		JPanel movie_lookup = new JPanel();
		frame.getContentPane().add(movie_lookup, "name_197617944856377");
		movie_lookup.setLayout(null);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAccounts.setBounds(21, 11, 107, 32);
		movie_lookup.add(btnAccounts);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(874, 11, 107, 32);
		movie_lookup.add(btnLogOut);
		
		JLabel lblBarCodeNumber = new JLabel("BarCode Number:");
		lblBarCodeNumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBarCodeNumber.setBounds(34, 109, 144, 32);
		movie_lookup.add(lblBarCodeNumber);
		
		JLabel lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMovieName.setBounds(34, 200, 144, 32);
		movie_lookup.add(lblMovieName);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblGenre.setBounds(34, 240, 144, 32);
		movie_lookup.add(lblGenre);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCategory.setBounds(34, 283, 144, 32);
		movie_lookup.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPrice.setBounds(34, 326, 144, 32);
		movie_lookup.add(lblPrice);
		
		JLabel lblMovieStatus = new JLabel("Movie Status:");
		lblMovieStatus.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMovieStatus.setBounds(34, 411, 144, 32);
		movie_lookup.add(lblMovieStatus);
		
		JTextPane txtpnPoes = new JTextPane();
		txtpnPoes.setEditable(false);
		txtpnPoes.setBounds(172, 200, 304, 32);
		movie_lookup.add(txtpnPoes);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(172, 243, 304, 32);
		movie_lookup.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(172, 283, 304, 32);
		movie_lookup.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(172, 326, 304, 32);
		movie_lookup.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBounds(172, 411, 304, 32);
		movie_lookup.add(textPane_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 109, 304, 32);
		movie_lookup.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCheckMovie = new JButton("Look Up");
		btnCheckMovie.setBounds(499, 109, 107, 29);
		movie_lookup.add(btnCheckMovie);
		
		JButton btnProceed_1 = new JButton("Proceed");
		btnProceed_1.setBounds(417, 503, 89, 23);
		movie_lookup.add(btnProceed_1);
		
		JButton button_7 = new JButton("Cancel");
		button_7.setBounds(536, 503, 89, 23);
		movie_lookup.add(button_7);
		
		JButton button_15 = new JButton("Reports");
		button_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_15.setEnabled(false);
		button_15.setBounds(143, 11, 107, 32);
		movie_lookup.add(button_15);
		
		JPanel customer_details = new JPanel();
		frame.getContentPane().add(customer_details, "name_197621012963743");
		customer_details.setLayout(null);
		
		JButton button = new JButton("Accounts");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(22, 11, 107, 32);
		customer_details.add(button);
		
		JButton button_1 = new JButton("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(875, 11, 107, 32);
		customer_details.add(button_1);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerDetails.setBounds(400, 74, 190, 26);
		customer_details.add(lblCustomerDetails);
		
		JLabel lblAccountnumber = new JLabel("Account Number:");
		lblAccountnumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAccountnumber.setBounds(38, 134, 144, 32);
		customer_details.add(lblAccountnumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 134, 304, 32);
		customer_details.add(textField_2);
		
		JButton button_2 = new JButton("Look Up");
		button_2.setBounds(503, 134, 107, 29);
		customer_details.add(button_2);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFullName.setBounds(38, 225, 144, 32);
		customer_details.add(lblFullName);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBounds(176, 225, 304, 32);
		customer_details.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBounds(176, 268, 304, 72);
		customer_details.add(textPane_5);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(38, 265, 144, 32);
		customer_details.add(lblAddress);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setBounds(176, 351, 304, 74);
		customer_details.add(textPane_7);
		
		JLabel lblOutstandingMovies = new JLabel("Overdue Movies:");
		lblOutstandingMovies.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOutstandingMovies.setBounds(38, 351, 144, 32);
		customer_details.add(lblOutstandingMovies);
		
		JLabel lblMoneyOwed = new JLabel("Money owed:");
		lblMoneyOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMoneyOwed.setBounds(38, 436, 144, 32);
		customer_details.add(lblMoneyOwed);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEditable(false);
		textPane_8.setBounds(176, 436, 304, 32);
		customer_details.add(textPane_8);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(402, 517, 89, 23);
		customer_details.add(btnProceed);
		
		JButton button_6 = new JButton("Cancel");
		button_6.setBounds(521, 517, 89, 23);
		customer_details.add(button_6);
		
		JButton button_14 = new JButton("Reports");
		button_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_14.setEnabled(false);
		button_14.setBounds(149, 11, 107, 32);
		customer_details.add(button_14);
		
		JPanel checkout = new JPanel();
		frame.getContentPane().add(checkout, "name_197622637729269");
		checkout.setLayout(null);
		
		JButton button_3 = new JButton("Accounts");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(23, 11, 107, 32);
		checkout.add(button_3);
		
		JButton button_4 = new JButton("Log Out");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(876, 11, 107, 32);
		checkout.add(button_4);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckOut.setBounds(437, 74, 118, 26);
		checkout.add(lblCheckOut);
		
		JLabel lblAmountDue = new JLabel("Amount Due:");
		lblAmountDue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountDue.setBounds(40, 194, 144, 32);
		checkout.add(lblAmountDue);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 194, 304, 32);
		checkout.add(textField_3);
		
		JLabel lblAmountReceived = new JLabel("Amount Received:");
		lblAmountReceived.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountReceived.setBounds(40, 251, 144, 32);
		checkout.add(lblAmountReceived);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 251, 304, 32);
		checkout.add(textField_4);
		
		JLabel lblChangeOwed = new JLabel("Change owed:");
		lblChangeOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblChangeOwed.setBounds(40, 307, 144, 32);
		checkout.add(lblChangeOwed);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 307, 304, 32);
		checkout.add(textField_5);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(392, 418, 89, 23);
		checkout.add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(511, 418, 89, 23);
		checkout.add(btnCancel);
		
		JButton button_13 = new JButton("Reports");
		button_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_13.setEnabled(false);
		button_13.setBounds(150, 11, 107, 32);
		checkout.add(button_13);
		
		JPanel customer_selection = new JPanel();
		frame.getContentPane().add(customer_selection, "name_197625364594910");
		customer_selection.setLayout(null);
		
		JButton button_5 = new JButton("Accounts");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_5.setBounds(24, 11, 107, 32);
		customer_selection.add(button_5);
		
		JButton button_8 = new JButton("Log Out");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_8.setBounds(877, 11, 107, 32);
		customer_selection.add(button_8);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewCustomer.setBounds(113, 218, 288, 130);
		customer_selection.add(btnNewCustomer);
		
		JButton btnExistingCustomer = new JButton("Existing Customer");
		btnExistingCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExistingCustomer.setBounds(561, 218, 288, 130);
		customer_selection.add(btnExistingCustomer);
		
		JButton button_11 = new JButton("Reports");
		button_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_11.setEnabled(false);
		button_11.setBounds(151, 11, 107, 32);
		customer_selection.add(button_11);
		
		JPanel add_customer = new JPanel();
		frame.getContentPane().add(add_customer, "name_197626667220565");
		add_customer.setLayout(null);
		
		JButton button_9 = new JButton("Accounts");
		button_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_9.setBounds(23, 11, 107, 32);
		add_customer.add(button_9);
		
		JButton button_10 = new JButton("Log Out");
		button_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_10.setBounds(876, 11, 107, 32);
		add_customer.add(button_10);
		
		JLabel lblFullName_1 = new JLabel("Full Name:");
		lblFullName_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFullName_1.setBounds(54, 208, 144, 32);
		add_customer.add(lblFullName_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(192, 208, 304, 32);
		add_customer.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(192, 265, 304, 76);
		add_customer.add(textField_7);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress_1.setBounds(54, 265, 144, 32);
		add_customer.add(lblAddress_1);
		
		JButton btnProceed_2 = new JButton("Proceed");
		btnProceed_2.setBounds(406, 432, 89, 23);
		add_customer.add(btnProceed_2);
		
		JButton button_12 = new JButton("Cancel");
		button_12.setBounds(525, 432, 89, 23);
		add_customer.add(button_12);
		
		JLabel lblNewCustomer = new JLabel("New Customer");
		lblNewCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewCustomer.setBounds(428, 75, 163, 26);
		add_customer.add(lblNewCustomer);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAccountNumber.setBounds(54, 154, 144, 32);
		add_customer.add(lblAccountNumber);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(525, 154, 107, 32);
		add_customer.add(btnGenerate);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setBounds(192, 154, 304, 32);
		add_customer.add(textPane_6);
		
		JButton btnReports = new JButton("Reports");
		btnReports.setEnabled(false);
		btnReports.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReports.setBounds(145, 11, 107, 32);
		add_customer.add(btnReports);
		
		JPanel panel_6 = new JPanel();
		frame.getContentPane().add(panel_6, "name_197627964149593");
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7, "name_197629190492505");
		
		JPanel panel_8 = new JPanel();
		frame.getContentPane().add(panel_8, "name_197631926701873");
		
		JPanel panel_9 = new JPanel();
		frame.getContentPane().add(panel_9, "name_197633098508457");
		
		JPanel panel_10 = new JPanel();
		frame.getContentPane().add(panel_10, "name_197634266650315");
	}
	
	public void movie()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);
		
		JPanel movie_lookup = new JPanel();
		frame.getContentPane().add(movie_lookup, "name_197617944856377");
		movie_lookup.setLayout(null);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAccounts.setBounds(21, 11, 107, 32);
		movie_lookup.add(btnAccounts);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(874, 11, 107, 32);
		movie_lookup.add(btnLogOut);
		
		JLabel lblBarCodeNumber = new JLabel("BarCode Number:");
		lblBarCodeNumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBarCodeNumber.setBounds(34, 109, 144, 32);
		movie_lookup.add(lblBarCodeNumber);
		
		JLabel lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMovieName.setBounds(34, 200, 144, 32);
		movie_lookup.add(lblMovieName);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblGenre.setBounds(34, 240, 144, 32);
		movie_lookup.add(lblGenre);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCategory.setBounds(34, 283, 144, 32);
		movie_lookup.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPrice.setBounds(34, 326, 144, 32);
		movie_lookup.add(lblPrice);
		
		JLabel lblMovieStatus = new JLabel("Movie Status:");
		lblMovieStatus.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMovieStatus.setBounds(34, 411, 144, 32);
		movie_lookup.add(lblMovieStatus);
		
		JTextPane txtpnPoes = new JTextPane();
		txtpnPoes.setEditable(false);
		txtpnPoes.setBounds(172, 200, 304, 32);
		movie_lookup.add(txtpnPoes);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(172, 243, 304, 32);
		movie_lookup.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(172, 283, 304, 32);
		movie_lookup.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(172, 326, 304, 32);
		movie_lookup.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBounds(172, 411, 304, 32);
		movie_lookup.add(textPane_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 109, 304, 32);
		movie_lookup.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCheckMovie = new JButton("Look Up");
		btnCheckMovie.setBounds(499, 109, 107, 29);
		movie_lookup.add(btnCheckMovie);
		
		JButton btnProceed_1 = new JButton("Proceed");
		btnProceed_1.setBounds(417, 503, 89, 23);
		btnProceed_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				customer_selection();
			}
		});
		movie_lookup.add(btnProceed_1);
		
		JButton button_7 = new JButton("Cancel");
		button_7.setBounds(536, 503, 89, 23);
		movie_lookup.add(button_7);
		
		JButton button_15 = new JButton("Reports");
		button_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_15.setEnabled(false);
		button_15.setBounds(143, 11, 107, 32);
		movie_lookup.add(button_15);
	}

	public void customer_details()
	{

		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);

		JPanel customer_details = new JPanel();
		frame.getContentPane().add(customer_details, "name_197621012963743");
		customer_details.setLayout(null);
		
		JButton button = new JButton("Accounts");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(22, 11, 107, 32);
		customer_details.add(button);
		
		JButton button_1 = new JButton("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(875, 11, 107, 32);
		customer_details.add(button_1);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerDetails.setBounds(400, 74, 190, 26);
		customer_details.add(lblCustomerDetails);
		
		JLabel lblAccountnumber = new JLabel("Account Number:");
		lblAccountnumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAccountnumber.setBounds(38, 134, 144, 32);
		customer_details.add(lblAccountnumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 134, 304, 32);
		customer_details.add(textField_2);
		
		JButton button_2 = new JButton("Look Up");
		button_2.setBounds(503, 134, 107, 29);
		customer_details.add(button_2);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFullName.setBounds(38, 225, 144, 32);
		customer_details.add(lblFullName);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBounds(176, 225, 304, 32);
		customer_details.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBounds(176, 268, 304, 72);
		customer_details.add(textPane_5);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(38, 265, 144, 32);
		customer_details.add(lblAddress);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setBounds(176, 351, 304, 74);
		customer_details.add(textPane_7);
		
		JLabel lblOutstandingMovies = new JLabel("Overdue Movies:");
		lblOutstandingMovies.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOutstandingMovies.setBounds(38, 351, 144, 32);
		customer_details.add(lblOutstandingMovies);
		
		JLabel lblMoneyOwed = new JLabel("Money owed:");
		lblMoneyOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMoneyOwed.setBounds(38, 436, 144, 32);
		customer_details.add(lblMoneyOwed);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEditable(false);
		textPane_8.setBounds(176, 436, 304, 32);
		customer_details.add(textPane_8);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(402, 517, 89, 23);
		btnProceed.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				checkout();
			}
		});
		customer_details.add(btnProceed);
		
		JButton button_6 = new JButton("Cancel");
		button_6.setBounds(521, 517, 89, 23);
		customer_details.add(button_6);
		
		JButton button_14 = new JButton("Reports");
		button_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_14.setEnabled(false);
		button_14.setBounds(149, 11, 107, 32);
		customer_details.add(button_14);
	}

	public void customer_selection()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);

		JPanel customer_selection = new JPanel();
		frame.getContentPane().add(customer_selection, "name_197625364594910");
		customer_selection.setLayout(null);
		
		JButton button_5 = new JButton("Accounts");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_5.setBounds(24, 11, 107, 32);
		customer_selection.add(button_5);
		
		JButton button_8 = new JButton("Log Out");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_8.setBounds(877, 11, 107, 32);
		customer_selection.add(button_8);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				customer_details();
			}
		});
		btnNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewCustomer.setBounds(113, 218, 288, 130);
		customer_selection.add(btnNewCustomer);
		
		JButton btnExistingCustomer = new JButton("Existing Customer");
		btnExistingCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExistingCustomer.setBounds(561, 218, 288, 130);
		customer_selection.add(btnExistingCustomer);
		
		JButton button_11 = new JButton("Reports");
		button_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_11.setEnabled(false);
		button_11.setBounds(151, 11, 107, 32);
		customer_selection.add(button_11);
	}

	public void checkout()
	{	
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);

		JPanel checkout = new JPanel();
		frame.getContentPane().add(checkout, "name_197622637729269");
		checkout.setLayout(null);
		
		JButton button_3 = new JButton("Accounts");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(23, 11, 107, 32);
		checkout.add(button_3);
		
		JButton button_4 = new JButton("Log Out");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(876, 11, 107, 32);
		checkout.add(button_4);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckOut.setBounds(437, 74, 118, 26);
		checkout.add(lblCheckOut);
		
		JLabel lblAmountDue = new JLabel("Amount Due:");
		lblAmountDue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountDue.setBounds(40, 194, 144, 32);
		checkout.add(lblAmountDue);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 194, 304, 32);
		checkout.add(textField_3);
		
		JLabel lblAmountReceived = new JLabel("Amount Received:");
		lblAmountReceived.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountReceived.setBounds(40, 251, 144, 32);
		checkout.add(lblAmountReceived);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 251, 304, 32);
		checkout.add(textField_4);
		
		JLabel lblChangeOwed = new JLabel("Change owed:");
		lblChangeOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblChangeOwed.setBounds(40, 307, 144, 32);
		checkout.add(lblChangeOwed);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 307, 304, 32);
		checkout.add(textField_5);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(392, 418, 89, 23);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
		});
		checkout.add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(511, 418, 89, 23);
		checkout.add(btnCancel);
		
		JButton button_13 = new JButton("Reports");
		button_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_13.setEnabled(false);
		button_13.setBounds(150, 11, 107, 32);
		checkout.add(button_13);
	}
}
