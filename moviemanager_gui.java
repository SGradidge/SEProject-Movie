import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.text.*;


public class moviemanager_gui {

	private JFrame frame;
	private moviemanager_backend mb;
	private int accNo;
	private long productID;
	private long [] mproductID;
	private String accProductID;
	private int size = 0;
	private double amountOwed;
	private double amountDue;
	private double totalAmount = 0;
	private String username;
	private int accesslevel;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTable table;



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
					System.out.println("Database successfully opened");
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
		//options();
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
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1024, 627);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent event) 
			{
				mb.finish();
				frame.dispose();
		        System.exit(0);
		    }
		});
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
		
		JLabel lblMovieManagementSoftware = new JLabel("");
		Image img = new ImageIcon("img/login.png").getImage();
		lblMovieManagementSoftware.setIcon(new ImageIcon(img));
		lblMovieManagementSoftware.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblMovieManagementSoftware.setBounds(274, 57, 439, 122);
		login.add(lblMovieManagementSoftware);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(329, 235, 115, 37);
		login.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(329, 289, 115, 37);
		login.add(lblPassword);
		
		JTextField textField = new JTextField();
		textField.setBounds(454, 241, 208, 32);
		login.add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(454, 295, 208, 32);
		login.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mb.loginCheck(textField.getText(),passwordField.getText()))
				{
					username = textField.getText();
					accesslevel = mb.getAccessLevel(username);
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
		btnLogin.setBounds(457, 356, 89, 32);
		login.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setBounds(573, 356, 89, 32);
		login.add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(83, 172, 186, 173);
		login.add(lblNewLabel_1);
	}
	
	public void movie()
	{
		initialize();
		JPanel movie_lookup = new JPanel();
		frame.getContentPane().add(movie_lookup, "name_197617944856377");
		movie_lookup.setLayout(null);
		
		mproductID = new long [5];
		
		JLabel lblNewLabel_2 = new JLabel("No. of movies selected: 0");
		lblNewLabel_2.setBounds(712, 127, 169, 32);
		movie_lookup.add(lblNewLabel_2);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(21, 11, 107, 32);
		movie_lookup.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
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
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(874, 11, 107, 32);
		movie_lookup.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					login();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
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
		btnProceed_1.setBounds(341, 503, 89, 32);
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
		btnReturnMovie.setBounds(541, 503, 113, 32);
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
		
		JButton btnRemoveMovie = new JButton("Remove Movie");
		btnRemoveMovie.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to REMOVE this movie?","Confirmation",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION)
				{				
					mb.removeMovie(Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null, "Movie successfully removed");
					frame.setVisible(false);
					movie();
				}
				
			}
		});
		btnRemoveMovie.setBounds(721, 308, 127, 92);
		btnRemoveMovie.setEnabled(false);
		movie_lookup.add(btnRemoveMovie);
		
		JButton btnAddMovie_1 = new JButton("Add");
		
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
						btnReturnMovie.setEnabled(false);
						btnAddMovie_1.setEnabled(true);
					}
					else
					{
						textPane_3.setText("Not Available");
						if(size < 1)
						{
							btnReturnMovie.setEnabled(true);
						}
						btnAddMovie_1.setEnabled(false);
					}
					btnRemoveMovie.setEnabled(true);
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
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					options();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton btnAddMovie = new JButton("New Movie");
		btnAddMovie.setBounds(721, 210, 127, 92);
		movie_lookup.add(btnAddMovie);
		
		JLabel lblMovieDetails = new JLabel("Movie Details");
		lblMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMovieDetails.setBounds(440, 49, 160, 26);
		movie_lookup.add(lblMovieDetails);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon("img/background.png").getImage();
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(106, 102, 724, 421);
		movie_lookup.add(label);
		
		btnAddMovie_1.setEnabled(false);
		btnAddMovie_1.setBounds(440, 503, 89, 32);
		movie_lookup.add(btnAddMovie_1);
		btnAddMovie_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnProceed_1.setEnabled(true);
					textPane_4.setText("");
					textPane.setText("");
					textPane_1.setText("");
					textPane_2.setText("");
					textPane_3.setText("");
					boolean isSelected = false;
					for(int i = 0; i < 5; i++)
					{
						if(mproductID[i] == Long.parseLong(textField_1.getText()))
						{
							isSelected = true;
						}
					}
					if(isSelected)
					{
						JOptionPane.showMessageDialog(null,"That movie has already been added to the list");
						textField_1.setText("");
					}
					else
					{
						mproductID[size] = Long.parseLong(textField_1.getText());
						if(size < 1)
						{
							accProductID = textField_1.getText();
						}
						else
						{
							accProductID = accProductID + " " + textField_1.getText();
							System.out.println(accProductID);
						}
						size++;
						lblNewLabel_2.setText("No. of movies selected: " + size);
						textField_1.setText("");
						totalAmount = totalAmount + amountDue; 
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHelp.setBounds(750, 11, 107, 32);
		movie_lookup.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if (Desktop.isDesktopSupported()) 
					{
						File myFile = new File("User Guide.pdf");
			            Desktop.getDesktop().open(myFile);
			        }
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnCheckMovie.setEnabled(false);
					textField_1.setText("" + mb.makeProductID());
					textField_1.setEditable(false);
					textPane_2.setText("");
					textPane_4.setText("");
					textPane.setText("");
					textPane_1.setText("");
					textPane_2.setEditable(true);
					textPane_4.setEditable(true);
					textPane.setEditable(true);
					textPane_1.setEditable(true);
					textPane_3.setVisible(false);
					lblMovieStatus.setVisible(false);
					btnAddMovie.setVisible(false);
					btnAddMovie_1.setVisible(false);
					btnRemoveMovie.setVisible(false);
					btnProceed_1.setVisible(false);
					movie_lookup.remove(btnProceed_1);
					JButton btnAdd = new JButton("Add");
					btnAdd.setEnabled(true);
					btnAdd.setBounds(405, 503, 89, 32);
					movie_lookup.add(btnAdd);
					movie_lookup.repaint();
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							try
							{
								mb.addMovie(Integer.parseInt(textField_1.getText()), textPane_4.getText(), textPane.getText(), textPane_1.getText(), Double.parseDouble(textPane_2.getText()), 1);
								JOptionPane.showMessageDialog(null, "Movie added successfully!");
								frame.setVisible(false);
								movie();
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, "Please enter valid Movie Details");
							}
						}
					});
					
					btnReturnMovie.setVisible(false);
					movie_lookup.remove(btnReturnMovie);
					JButton btnCancel = new JButton("Cancel");
					btnCancel.setEnabled(true);
					btnCancel.setBounds(506, 503, 113, 32);
					movie_lookup.add(btnCancel);
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
								JOptionPane.showMessageDialog(null, "Movie not returned");
							}
						}
					});
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Product ID");
				}
			}
		});
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
		btnHome_2.addActionListener(new ActionListener() {
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
		
		JButton button_1 = new JButton("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(875, 11, 107, 32);
		customer_details.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					login();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
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
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(354, 508, 89, 32);
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
		button_6.setBounds(559, 508, 89, 32);
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
		
		
		JButton btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.setEnabled(false);
		btnRemoveCustomer.setBounds(725, 323, 144, 92);
		customer_details.add(btnRemoveCustomer);
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to REMOVE this customer?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION)
					{				
						mb.removeCustomer(Integer.parseInt(textField_2.getText()));
						JOptionPane.showMessageDialog(null, "Customer successfully removed");
						frame.setVisible(false);
						customer();
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
		lblOutstandingMovies.setBounds(38, 380, 144, 64);
		customer_details.add(lblOutstandingMovies);
		
		JLabel lblMoneyOwed = new JLabel("Money owed:");
		lblMoneyOwed.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMoneyOwed.setBounds(38, 436, 144, 32);
		customer_details.add(lblMoneyOwed);
		
		JButton button_2 = new JButton("Look Up");
		JButton btnAddCustomer = new JButton("Add Customer");
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(176, 352, 304, 32);
		customer_details.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(176, 396, 304, 32);
		customer_details.add(textPane_1);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblContactNumber.setBounds(38, 337, 144, 64);
		customer_details.add(lblContactNumber);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.setBounds(458, 508, 89, 32);
		customer_details.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					textField_2.setEditable(false);
					button_2.setEnabled(false);
					textPane_4.setEditable(true);
					textPane_5.setEditable(true);
					textPane_1.setVisible(false);
					textPane.setEditable(true);
					textPane_8.setVisible(false);
					lblOutstandingMovies.setVisible(false);
					lblMoneyOwed.setVisible(false);
					btnAddCustomer.setVisible(false);
					btnRemoveCustomer.setVisible(false);
					btnEdit.setVisible(false);
					btnProceed.setVisible(false);
					
					JButton btnUpdate = new JButton("Update");
					btnUpdate.setEnabled(true);
					btnUpdate.setBounds(458, 508, 89, 32);
					customer_details.add(btnUpdate);
					btnUpdate.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							mb.editCustomerDetails(Integer.parseInt(textField_2.getText()), textPane_4.getText(), textPane_5.getText(), textPane.getText());
							JOptionPane.showMessageDialog(null, "Customer details edited successfully");
							frame.setVisible(false);
							movie();
						}
					});
					
					button_6.setVisible(false);
					JButton btnCancel = new JButton("Cancel");
					btnCancel.setBounds(559, 508, 89, 32);
					customer_details.add(btnCancel);
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							try
							{
								frame.setVisible(false);
								customer();
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, "An error has occured");
							}
						}
					});
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Account Number");
				}
			}
		});
				
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
					textPane.setText(data[3]);
					double amount = Double.parseDouble(data[4]);
					DecimalFormat df = new DecimalFormat("0.00");
					String ao = df.format(amount);
					textPane_8.setText(ao);
					if(data[5].equals("0") || data[5].equals("") || data[5].equals(" "))
					{	
						textPane_1.setText("None");
						amountOwed = Double.parseDouble(ao);
						btnProceed.setEnabled(true);
						accNo = Integer.parseInt(data[0]);
					}
					else
					{
						textPane_1.setText("Product ID: " + data[5]);
					}
					btnEdit.setEnabled(true);
					btnRemoveCustomer.setEnabled(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Account Number");
				}
			}
		});
		
		JButton btnOptions_2 = new JButton("Options");
		btnOptions_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOptions_2.setBounds(149, 11, 107, 32);
		customer_details.add(btnOptions_2);
		btnOptions_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					options();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		btnAddCustomer.setBounds(725, 225, 144, 92);
		customer_details.add(btnAddCustomer);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon("img/background.png").getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(103, 84, 724, 421);
		customer_details.add(label);
		
		JButton button = new JButton("Help");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(751, 11, 107, 32);
		customer_details.add(button);
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if (Desktop.isDesktopSupported()) 
					{
						File myFile = new File("User Guide.pdf");
			            Desktop.getDesktop().open(myFile);
			        }
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		btnAddCustomer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField_2.setText("" + mb.makeAccountNumber());
				textField_2.setEditable(false);
				button_2.setEnabled(false);
				btnAddCustomer.setVisible(false);
				btnRemoveCustomer.setVisible(false);
				button_6.setVisible(false);
				btnEdit.setVisible(false);
				btnProceed.setVisible(false);
				textPane_4.setText("");
				textPane_5.setText("");
				textPane.setText("");
				textPane_4.setEditable(true);
				textPane_5.setEditable(true);
				textPane.setEditable(true);
				textPane_1.setVisible(false);
				textPane_8.setVisible(false);
				lblOutstandingMovies.setVisible(false);
				lblMoneyOwed.setVisible(false);
				
				JButton btnAdd = new JButton("Add");
				btnAdd.setEnabled(true);
				btnAdd.setBounds(458, 508, 89, 32);
				customer_details.add(btnAdd);
				btnAdd.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						mb.addCustomer(Integer.parseInt(textField_2.getText()), textPane_4.getText(), textPane_5.getText(),textPane.getText(), 0, 0);
						JOptionPane.showMessageDialog(null, "Customer added successfully");
						frame.setVisible(false);
						customer();
					}
				});
				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setBounds(559, 508, 89, 32);
				customer_details.add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							frame.setVisible(false);
							customer();
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, "An error has occured");
						}
					}
				});
				
			}
		});

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
		btnHome.addActionListener(new ActionListener() {
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
		
		JButton button_4 = new JButton("Log Out");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(876, 11, 107, 32);
		checkout.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					login();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
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
		String ao = df.format((totalAmount+amountOwed));
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
					mb.rentMovie(mproductID, accNo, accProductID);
					JOptionPane.showMessageDialog(null, "Movie rented successfully");
					size = 0;
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
		btnOptions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					options();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					double change = Double.parseDouble(textField_4.getText()) - (totalAmount+amountOwed);
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
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon("img/background.png").getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(103, 112, 724, 421);
		checkout.add(label);
		
		JButton button_1 = new JButton("Help");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(753, 11, 107, 32);
		checkout.add(button_1);
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if (Desktop.isDesktopSupported()) 
					{
						File myFile = new File("User Guide.pdf");
			            Desktop.getDesktop().open(myFile);
			        }
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
	}
	
	public void options()
	{
		initialize();
		JPanel options = new JPanel();
		frame.getContentPane().add(options, "name_197615222529489");
		options.setLayout(null);
		
		JButton button = new JButton("Home");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(18, 16, 107, 32);
		options.add(button);
		button.addActionListener(new ActionListener() {
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
		
		JButton button_1 = new JButton("Options");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(144, 16, 107, 32);
		options.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					options();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOptions.setBounds(446, 62, 94, 26);
		options.add(lblOptions);
		
		JButton button_2 = new JButton("Log Out");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(873, 16, 107, 32);
		options.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					frame.setVisible(false);
					login();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		JButton btnCustomerReports = new JButton("Customer Report");
		btnCustomerReports.setEnabled(false);
		JButton btnChangePassword = new JButton("Change Password");
		
		JButton btnStockReports = new JButton("Stock Report");
		btnStockReports.setBounds(400, 153, 175, 92);
		options.add(btnStockReports);
		btnStockReports.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnStockReports.setVisible(false);
					btnCustomerReports.setVisible(false);
					btnChangePassword.setVisible(false);
					lblOptions.setVisible(false);
					JLabel lblStock = new JLabel("Stock Report");
					lblStock.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblStock.setBounds(419, 61, 203, 26);
					options.add(lblStock);
					options.repaint();
					
					String [] columnNames = new String [] {"Product ID", "Movie Name", "Genre", "Category", "Price", "Available", "Date Rented", "Account Number"};
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(41, 102, 917, 455);
					options.add(scrollPane);
					table = new JTable(mb.reports(2), columnNames);
					scrollPane.setViewportView(table);
					table.setRowSelectionAllowed(false);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Report could not be generated");
				}
			}
		});
		
		if(accesslevel == 1)
		{
			btnCustomerReports.setEnabled(true);
		}
		
		btnCustomerReports.setBounds(400, 257, 175, 92);
		options.add(btnCustomerReports);
		btnCustomerReports.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnStockReports.setVisible(false);
					btnCustomerReports.setVisible(false);
					btnChangePassword.setVisible(false);
					lblOptions.setVisible(false);
					JLabel lblCustomer = new JLabel("Customer Report");
					lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblCustomer.setBounds(394, 55, 203, 26);
					options.add(lblCustomer);
					options.repaint();
					
					String [] columnNames = new String [] {"Account Number", "Full Name", "Address", "Contact Number" , "Amount Outstanding", "Product ID"};
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(41, 102, 917, 455);
					options.add(scrollPane);
					table = new JTable(mb.reports(1), columnNames);
					scrollPane.setViewportView(table);
					table.setRowSelectionAllowed(false);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Report could not be generated");
				}
			}
		});
		
		btnChangePassword.setBounds(400, 361, 175, 92);
		options.add(btnChangePassword);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon("img/background.png").getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(93, 111, 724, 421);
		options.add(label);
		
		JButton button_3 = new JButton("Help");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(750, 16, 107, 32);
		options.add(button_3);
		button_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if (Desktop.isDesktopSupported()) 
					{
						File myFile = new File("User Guide.pdf");
			            Desktop.getDesktop().open(myFile);
			        }
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "An error has occured");
				}
			}
		});
		
		btnChangePassword.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					btnStockReports.setVisible(false);
					btnCustomerReports.setVisible(false);
					btnChangePassword.setVisible(false);
					lblOptions.setVisible(false);
					JLabel lblChange = new JLabel("Change Password");
					lblChange.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblChange.setBounds(419, 61, 203, 26);
					options.add(lblChange);
					options.repaint();
					
					JLabel lblNewLabel = new JLabel("Current Password:");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel.setBounds(239, 185, 173, 32);
					options.add(lblNewLabel);
					
					JLabel lblNewPassword = new JLabel("New Password:");
					lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewPassword.setBounds(239, 241, 173, 32);
					options.add(lblNewPassword);
					
					JLabel lblRetypeNewPassword = new JLabel("Retype New Password:");
					lblRetypeNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblRetypeNewPassword.setBounds(239, 300, 210, 32);
					options.add(lblRetypeNewPassword);
					
					passwordField_1 = new JPasswordField();
					passwordField_1.setBounds(496, 185, 189, 32);
					options.add(passwordField_1);
					
					passwordField_2 = new JPasswordField();
					passwordField_2.setBounds(496, 241, 189, 32);
					options.add(passwordField_2);
					
					passwordField_3 = new JPasswordField();
					passwordField_3.setBounds(496, 300, 189, 32);
					options.add(passwordField_3);
					
					JButton btnChange = new JButton("Change ");
					btnChange.setBounds(394, 424, 90, 28);
					options.add(btnChange);
					btnChange.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							if(mb.loginCheck(username,passwordField_1.getText()))
							{
								if(passwordField_2.getText().equals(passwordField_3.getText()))
								{
									mb.changePassword(username, passwordField_2.getText());
									JOptionPane.showMessageDialog(null, "Password changed successfully!");
									frame.setVisible(false);
									options();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "The passwords entered did not match");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "The current password is incorrect");
								passwordField_1.setText("");
								passwordField_2.setText("");
								passwordField_3.setText("");
							}
						}
					});
					
					JButton btnClear_1 = new JButton("Clear");
					btnClear_1.setBounds(524, 424, 90, 28);
					options.add(btnClear_1);
					btnClear_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							passwordField_1.setText("");
							passwordField_2.setText("");
							passwordField_3.setText("");
						}
					});
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Incorrect current password entered");
				}
			}
		}); 
	
	}
}
