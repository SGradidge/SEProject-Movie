import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class moviemanager_gui {

	private JFrame frame;
	private moviemanager_backend mb;
	private int accNo;
	private long productID;
	private double amountOwed;
	private double amountDue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moviemanager_backend mb = new moviemanager_backend();
					moviemanager_gui mg = new moviemanager_gui();
					mg.frame.setVisible(true);
					mb.finish();
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
		login();
		//movie();
		//customer();
		//checkout();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setVisible(true);
		mb = new moviemanager_backend();
	}
	
	public void login()
	{
		initialize();
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
		
		JTextField textField = new JTextField();
		textField.setBounds(454, 214, 208, 32);
		login.add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(454, 269, 208, 32);
		login.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				if(mb.loginCheck(textField.getText(),passwordField.getText()))
				{
					frame.setVisible(false);
					movie();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The username or password is incorrect");
					passwordField.setText("");
				}
			}
		});
		btnLogin.setBounds(454, 334, 89, 32);
		login.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setBounds(573, 334, 89, 32);
		login.add(btnClear);
	}
	
	public void movie()
	{
		initialize();
		JPanel movie_lookup = new JPanel();
		frame.getContentPane().add(movie_lookup, "name_197617944856377");
		movie_lookup.setLayout(null);
		
		JButton btnAccounts = new JButton("Home");
		btnAccounts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAccounts.setBounds(21, 11, 107, 32);
		movie_lookup.add(btnAccounts);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(874, 11, 107, 32);
		movie_lookup.add(btnLogOut);
		
		JLabel lblBarCodeNumber = new JLabel("Product ID:");
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
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBounds(172, 200, 304, 32);
		movie_lookup.add(textPane_4);
		
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
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(172, 109, 304, 32);
		movie_lookup.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnProceed_1 = new JButton("Take Out");
		btnProceed_1.setEnabled(false);
		btnProceed_1.setBounds(405, 503, 89, 32);
		movie_lookup.add(btnProceed_1);
		btnProceed_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					customer();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Product ID");
				}
			}
		});
		
		JButton btnReturnMovie = new JButton("Return Movie");
		btnReturnMovie.setEnabled(false);
		btnReturnMovie.setBounds(506, 503, 113, 32);
		movie_lookup.add(btnReturnMovie);
		btnReturnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to return this movie?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION)
					{				
						mb.returnMovie(productID);
						JOptionPane.showMessageDialog(null, "Movie successfully returned");
						textPane_4.setText("");
						textPane.setText("");
						textPane_1.setText("");
						textPane_2.setText("");
						textPane_3.setText("");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Movie not returned");
				}
			}
		});
		
		JButton btnCheckMovie = new JButton("Look Up");
		btnCheckMovie.setBounds(499, 109, 107, 29);
		movie_lookup.add(btnCheckMovie);
		btnCheckMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String [] data = mb.movieDetails(Integer.parseInt(textField_1.getText()));
					textPane_4.setText(data[1]);
					textPane.setText(data[2]);
					textPane_1.setText(data[3]);
					textPane_2.setText(data[4]);
					amountDue = Double.parseDouble(data[4]);
					productID = Long.parseLong(textField_1.getText());
					if(data[5].equals("1"))
					{
						textPane_3.setText("Available");
						btnProceed_1.setEnabled(true);
						btnReturnMovie.setEnabled(false);
					}
					else
					{
						textPane_3.setText("Not Available");
						btnReturnMovie.setEnabled(true);
						btnProceed_1.setEnabled(false);
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Product ID");
				}
			}
		});
		
		JButton btnOptions = new JButton("Options");
		btnOptions.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOptions.setBounds(143, 11, 107, 32);
		movie_lookup.add(btnOptions);
		
		JButton btnAddMovie = new JButton("Add Movie");
		btnAddMovie.setBounds(721, 210, 127, 92);
		movie_lookup.add(btnAddMovie);
		
		JButton btnRemoveMovie = new JButton("Remove Movie");
		btnRemoveMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveMovie.setBounds(721, 308, 127, 92);
		movie_lookup.add(btnRemoveMovie);
	}

	public void customer()
	{
		initialize();
		JPanel customer_details = new JPanel();
		frame.getContentPane().add(customer_details, "name_197621012963743");
		customer_details.setLayout(null);
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome_2.setBounds(22, 11, 107, 32);
		customer_details.add(btnHome_2);
		
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
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 134, 304, 32);
		customer_details.add(textField_2);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setBounds(176, 225, 304, 32);
		customer_details.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBounds(176, 268, 304, 72);
		customer_details.add(textPane_5);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEditable(false);
		textPane_8.setBounds(176, 436, 304, 32);
		customer_details.add(textPane_8);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setBounds(176, 351, 304, 74);
		customer_details.add(textPane_7);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(402, 508, 89, 32);
		btnProceed.setEnabled(false);
		customer_details.add(btnProceed);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					checkout();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
				
		JButton button_6 = new JButton("Cancel");
		button_6.setBounds(521, 508, 89, 32);
		customer_details.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					movie();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton button_2 = new JButton("Look Up");
		button_2.setBounds(503, 134, 107, 29);
		customer_details.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnProceed.setEnabled(false);
					String [] data = mb.customerDetails(Integer.parseInt(textField_2.getText()));
					textPane_4.setText(data[1]);
					textPane_5.setText(data[2]);
					if(data[4].equals("0"))
					{
						textPane_7.setText("None");
					}
					else
					{
						textPane_7.setText("Product ID: " + data[4]);
					}
					double amount = Double.parseDouble(data[3]);
					DecimalFormat df = new DecimalFormat("0.00");
					String ao = df.format(amount);
					textPane_8.setText(ao);
					if(data[4].equals("0"))
					{						
						amountOwed = Double.parseDouble(ao);
						btnProceed.setEnabled(true);
						accNo = Integer.parseInt(data[0]);
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Account Number");
				}
			}
		});
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFullName.setBounds(38, 225, 144, 32);
		customer_details.add(lblFullName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(38, 265, 144, 32);
		customer_details.add(lblAddress);
		
		JLabel lblOutstandingMovies = new JLabel("Movies owed:");
		lblOutstandingMovies.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOutstandingMovies.setBounds(38, 351, 144, 64);
		customer_details.add(lblOutstandingMovies);
		
		JLabel lblMoneyOwed = new JLabel("Money owed:");
		lblMoneyOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMoneyOwed.setBounds(38, 436, 144, 32);
		customer_details.add(lblMoneyOwed);
		
		JButton btnOptions_2 = new JButton("Options");
		btnOptions_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOptions_2.setBounds(149, 11, 107, 32);
		customer_details.add(btnOptions_2);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCustomer.setBounds(725, 225, 144, 92);
		customer_details.add(btnAddCustomer);
		
		JButton btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.setBounds(725, 323, 144, 92);
		customer_details.add(btnRemoveCustomer);
	}

	public void checkout()
	{	
		initialize();
		JPanel checkout = new JPanel();
		frame.getContentPane().add(checkout, "name_197622637729269");
		checkout.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(23, 11, 107, 32);
		checkout.add(btnHome);
		
		JButton button_4 = new JButton("Log Out");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(876, 11, 107, 32);
		checkout.add(button_4);
		
		JLabel lblCheckOut = new JLabel("Cash Out");
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckOut.setBounds(448, 74, 118, 26);
		checkout.add(lblCheckOut);
		
		JLabel lblAmountDue = new JLabel("Amount Due:");
		lblAmountDue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountDue.setBounds(40, 194, 144, 32);
		checkout.add(lblAmountDue);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(178, 194, 304, 32);
		checkout.add(textPane);
		DecimalFormat df = new DecimalFormat("0.00");
		String ao = df.format((amountDue+amountOwed));
		textPane.setText(ao);
		
		JLabel lblAmountReceived = new JLabel("Amount Received:");
		lblAmountReceived.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAmountReceived.setBounds(40, 251, 144, 32);
		checkout.add(lblAmountReceived);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 251, 304, 32);
		checkout.add(textField_4);
		
		JLabel lblChangeOwed = new JLabel("Change owed:");
		lblChangeOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblChangeOwed.setBounds(40, 307, 144, 32);
		checkout.add(lblChangeOwed);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(178, 307, 304, 32);
		checkout.add(textPane_2);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(392, 409, 89, 32);
		checkout.add(btnFinish);
		btnFinish.setEnabled(false);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					mb.rentMovie(productID, accNo);
					JOptionPane.showMessageDialog(null, "Movie rented successfully");
					frame.setVisible(false);
					movie();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(511, 409, 89, 32);
		checkout.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					movie();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton btnOptions_1 = new JButton("Options");
		btnOptions_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOptions_1.setBounds(150, 11, 107, 32);
		checkout.add(btnOptions_1);
		
		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					double change = Double.parseDouble(textField_4.getText()) - (amountDue+amountOwed);
					if(change >= 0)
					{
						DecimalFormat df = new DecimalFormat("0.00");
						String ao = df.format(change);
						textPane_2.setText(ao);
						btnFinish.setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The amount due is more than the amount received");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Amount entered incorrectly");
				}
			}
		});
		button.setBounds(544, 309, 107, 29);
		checkout.add(button);
	}
}
