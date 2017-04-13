import java.io.*;
import java.sql.*;
   
public class moviemanager_backend 
{
	Connection con;
 
    
    public moviemanager_backend()
    {
    	try 
    	{
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Pyro/Desktop/SE Project/Movie.accdb");
			System.out.println("Database successfully opened");
			customerDetails(1);
			editCustomerDetails(1,"Pieter Van Zyl","Houtbay",0);
			con.close();
		} 
    	catch (Exception e) 
    	{
    		System.out.println("Failed to open database");
		}
    	
    }
    
    public void test()
    {
    	try
    	{
	    	Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Bar_Code FROM Movie_Details");
			while (rs.next()) 
			{
			    System.out.println("Barcode is: " + rs.getString(1));
			}
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    
	void menuBar()
	{

	}

	void loginPage()
	{

	}

	void rentReturnMenu()
	{

	}

	void optionsScreen()
	{

	}

	void changePassword()
	{

	}

	void reports()
	{

	}

	void addMovie(int barCode, String movieName, String genre, String category, double price, int numberAvailable)
	{
			try
			{
				int barC = barCode;
				String movieN = movieName;
				String gen = genre;
				String categ = category;
				double pr = price;
				int numberA = numberAvailable;
	
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Insert into Movie_Details(" + barCode + ", " + movieName + ", " + genre + ", " +  category + ", " + price + ", " + numberAvailable + ")");
			}
			catch(Exception e)
			{
				
			}
	}

	void removeMovie(int barCode)
	{
			try
			{
				Statement stmt = con.createStatement();
				String query = "Delete From Movie_Details Where Bar_Code=" + barCode + "";
				int success = stmt.executeUpdate(query);
				stmt.close();
	
				if(success == 0)
				{
					System.out.println("Barcode not found");
				}
				else
				{
					System.out.println("Row deleted");
				}
			}
			catch(Exception e)
			{
				
			}

	}

	void returnMovie()
	{

	}

	public String [] customerDetails(int accNo)
	{
		String [] data = new String[5];
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer_Details WHERE Account_Number = " + accNo + "");
			while (rs.next()) 
			{
			    for(int i = 1; i < 6; i++)
			    {
			    	data[i-1] = rs.getString(i);
			    }
			}
			System.out.println(data[1]);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	void addCustomer()
	{

	}

	void removeCustomer()
	{

	}

	void editCustomerDetails(int accNo, String fullName, String address, double amount)
	{
		try
		{
			String sql = "UPDATE Customer_Details SET Full_Name = ?, Address = ?, Amount_Outstanding = ? WHERE Account_Number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fullName);
			pstmt.setString(2,address);
			pstmt.setDouble(3,amount);
			pstmt.setInt(4,accNo);
			int nrows = pstmt.executeUpdate();
			customerDetails(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	void cashOut()
	{

	}

	void finish()
	{

	}

	void validateNumber()
	{

	}
	
	public static void main (String [] args)
	{
		moviemanager_backend mm = new moviemanager_backend();
	}
}
