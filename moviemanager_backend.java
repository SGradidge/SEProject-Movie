import java.sql.*;
import java.text.*;
import java.util.Date;
import java.security.*;
   
public class moviemanager_backend 
{
	private Connection con;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	/**
	 * Default constructor + opens the connection to the database
	 */
    public moviemanager_backend()
    {
    	try 
    	{
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Pyro/Desktop/SE Project/Movie.accdb");
		} 
    	catch (Exception e) 
    	{
    		System.out.println("Failed to open database");
		}	
    }   
    
    /**
     * This method checks for valid login credentials
     * @param username Used to identify the user
     * @param password Used to verify the identity
     * @return
     */
	public boolean loginCheck(String username, String password)
	{
		try
		{
			byte[] bytesOfMessage = password.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < thedigest.length; ++i) 
	        {
	        	sb.append(Integer.toHexString((thedigest[i] & 0xFF) | 0x100).substring(1,3));
	        }
			
			String sql = "SELECT Password FROM User_Details WHERE Username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) 
			{
			    if(rs.getString(1).equals(sb.toString()))
			    {
			    	return true;
			    }
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	/**
	 * This method is used to change the password of a user
	 * @param username Used to identify the user
     * @param password Used to verify the identity
	 */
	public void changePassword(String username, String password)
	{	
		try
		{
			byte[] bytesOfMessage = password.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < thedigest.length; ++i) 
	        {
	        	sb.append(Integer.toHexString((thedigest[i] & 0xFF) | 0x100).substring(1,3));
	        }
			
			String sql = "UPDATE User_Details SET Password = ? WHERE Username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sb.toString());
			pstmt.setString(2,username);
			int nrows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * This method return data for the various reports
	 * @param report indicates which type of report is required
	 * @return
	 */
	public String [][] reports(int report)
	{
		ResultSet rs;
		String [][] data  = new String[1][1];
		int size;
		
		try
		{			
			if(report == 1)
			{
				size = 6;
				data = new String[1000][size]; 
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Customer_Details");
			}
			else
			{
				size = 8;
				data = new String[1000][size]; 
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Movie_Details");
			}
				
				int count = 0;
				while (rs.next()) 
				{
				    	for(int j = 0; j < size; j++)
				    	{
				    		data[count][j] = rs.getString(j+1);
				    	}
				    	count++;
				}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}
        
        /**
         * This method allows you to add a movie to the database using SQL
         * @param productID The product ID for the movie
         * @param movieName The name of the movie to be added
         * @param genre The genre of the movie to be added
         * @param category The product category of the movie
         * @param price The price of the movie
         * @param status If the movie is available
         */

	public void addMovie(int productID, String movieName, String genre, String category, double price, int status)
	{
			try
			{
				String sql = "INSERT INTO Movie_Details VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, productID);
				pstmt.setString(2, movieName);
				pstmt.setString(3, genre);
				pstmt.setString(4, category);
				pstmt.setDouble(5, price);
				pstmt.setInt(6, status);
				pstmt.setString(7, "");
				pstmt.setInt(8, 0);
				int nrows = pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
        
        /**
         * This method removes a selected movie from the database
         * @param productID Used to uniquely identify movies
         */

	public void removeMovie(int productID)
	{
			try
			{
				String sql = "DELETE FROM Movie_Details WHERE Product_ID=?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, productID);
                int nrows = pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	/**
	 * This method is used to return a movie
	 * @param productID Used to uniquely identify movies
	 */
	public void returnMovie(long productID)
	{
		try
		{
			String sql = "SELECT Date_Rented, Account_Number FROM Movie_Details WHERE Product_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,productID);
			ResultSet rs = pstmt.executeQuery();
			int accNo = 0;
			String accProductID = "";
			while (rs.next()) 
			{
			    String date = rs.getString(1);
			    accNo = rs.getInt(2);
			    String [] dateHolder = date.split("/");
			    int year = Integer.parseInt(dateHolder[0]) - 1900;
			    int month = Integer.parseInt(dateHolder[1]) - 1;
			    int day = Integer.parseInt(dateHolder[2]);
			    Date rentDate = new Date(year,month,day);
			    Date currentDate = new Date();
			    long diff = currentDate.getTime() - rentDate.getTime();
			    long time = diff / (1000*60*60*24);
			    if(time > 1)
			    {
			    	int amount = 0;
			    	sql = "SELECT Price FROM Movie_Details WHERE Product_ID = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setLong(1,productID);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						amount = rs.getInt(1);
					}
					
					amount = amount * (int)(time - 1);
			    	sql = "UPDATE Customer_Details SET Amount_Outstanding = ? WHERE Product_ID = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,amount);
					pstmt.setLong(2,productID);
					int nrows = pstmt.executeUpdate();
			    }
			}
			
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT Product_ID FROM Customer_Details WHERE Account_Number = " + accNo + "");
			while (rs.next()) 
			{
				   accProductID = rs.getString(1).replace(""+productID, "");
			}
			
			sql = "UPDATE Customer_Details SET Product_ID = ? WHERE Account_Number = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,accProductID);
			pstmt.setLong(2,accNo);
			int nrows = pstmt.executeUpdate();
			
			sql = "UPDATE Movie_Details SET Available = ?, Date_Rented = ?, Account_Number = ? WHERE Product_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,1);
			pstmt.setString(2,"");
			pstmt.setInt(3,0);
			pstmt.setLong(4,productID);
			nrows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * This method allows for movies to be rented to a customer
	 * @param productID Used to uniquely identify movies
	 * @param accNo Used to uniquely identify the customer
	 */
	public void rentMovie(long [] productID, int accNo, String accProductID)
	{
		try
		{
			Date currentdate = new Date();
			String date = dateFormat.format(currentdate);
			String sql = "UPDATE Customer_Details SET Product_ID = ?, Amount_Outstanding = ? WHERE Account_Number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,accProductID);
			pstmt.setInt(2,0);
			pstmt.setInt(3,accNo);
			int nrows = pstmt.executeUpdate();
			
			for(int i = 0; i < productID.length ; i++)
			{
				sql = "UPDATE Movie_Details SET Available = ?, Date_Rented = ?, Account_Number = ? WHERE Product_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,0);
				pstmt.setString(2,date);
				pstmt.setInt(3,accNo);
				pstmt.setLong(4,productID[i]);
				nrows = pstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * This method looks up the specific customer's details
	 * @param accNo Used to uniquely identify the customer
	 * @return
	 */
	public String [] customerDetails(int accNo)
	{
		String [] data = new String[6];
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer_Details WHERE Account_Number = " + accNo + "");
			while (rs.next()) 
			{
			    for(int i = 1; i < 7; i++)
			    {
			    	data[i-1] = rs.getString(i);
			    }
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}
	
	/**
	 * This method looks up the specific movie's details
	 * @param productID Used to uniquely identify a movie
	 * @return
	 */
	public String [] movieDetails(int productID)
	{
		String [] data = new String[6];
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Movie_Details WHERE Product_ID = " + productID + "");
			while (rs.next()) 
			{
			    for(int i = 1; i < 7; i++)
			    {
			    	data[i-1] = rs.getString(i);
			    }
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	 /**
         * This method allows you to add a customer to the database using SQL
         * @param accNo The account number of the customer
         * @param fullName The full name of the customer
         * @param address The customers' address
         * @param amount The amount still due by the customer
         * @param productID The product ID linked to the customer (that was rented) 
         */
	public void addCustomer(int accNo, String fullName, String address, String contactNumber, double amount, int productID)
	{
		try
		{
			String sql = "INSERT INTO Customer_Details(Account_Number, Full_Name, Address, Contact_Number, Amount_Outstanding, Product_ID)" +  "VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, accNo);
            pstmt.setString(2, fullName);
            pstmt.setString(3, address);
            pstmt.setString(4, contactNumber);
            pstmt.setDouble(5, amount);
            pstmt.setInt(6, productID);
            pstmt.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	 /**
         * This method removes the selected customer from the database using their unique account number as input. 
         * @param accNo The account number of the customer
         */
	public void removeCustomer(int accNo)
	{
		try
		{
			String sql = "DELETE FROM Customer_Details WHERE Account_Number = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, accNo);
            pstmt.execute();
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * This method is to edit the details of an existing customer
	 * @param accNo Used to uniquely identify the customer
	 * @param fullName Full name of the customer
	 * @param address Address of the customer
	 * @param amount The customers outstanding balance
	 */
	public void editCustomerDetails(int accNo, String fullName, String address, String contactNumber)
	{
		try
		{
			String sql = "UPDATE Customer_Details SET Full_Name = ?, Address = ?, Contact_Number = ? WHERE Account_Number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fullName);
			pstmt.setString(2,address);
			pstmt.setString(3,contactNumber);
			pstmt.setInt(4,accNo);
			int nrows = pstmt.executeUpdate();
			customerDetails(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * This method auto-generates the next available Product ID
	 * @return The next available Product ID is returned
	 */
	public int makeProductID()
	{
		int productID = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Movie_Details");
			while (rs.next()) 
			{
			    productID = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return productID + 1;
	}
	
	/**
	 * This method auto-generates the next available Account Number
	 * @return The next available Product ID is returned
	 */
	public int makeAccountNumber()
	{
		int accNo = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer_Details");
			while (rs.next()) 
			{
			    accNo = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return accNo + 1;
	}
	
	/**
	 * This method checks the access level of the logged in user
	 * @param username The user name of the logged in user
	 * @return Return the users access level
	 */
	public int getAccessLevel(String username)
	{
		int accesslevel = 0;
		try
		{
			String sql = "SELECT Access_Level FROM User_Details WHERE Username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
			    accesslevel = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return accesslevel;
	}
	
	/**
	 * This method validates inputed data with regular expressions
	 * @param type The type of data that needs to be validated
	 * @param input The data that needs to validated
	 * @return Returns true if its a valid expression or otherwise false
	 */
	public boolean validate(int type, String input)
	{
		if (type == 1)
		{
			String regex = "\\d+";
			return input.matches(regex) && input.length() == 10;
		}
		else
		{
			String regex = "[0-9a-zA-Z\\s]+";
			return input.matches(regex);
		}
	}

	/**
	 * This method closes the connection to the database once the program is terminated
	 */
	public void finish()
	{
		try
		{
			con.close();
			System.out.println("Database successfully closed");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
