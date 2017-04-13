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
			test();
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

	}// Called with each window

	void loginPage()
	{

	}

	void rentReturnMenu()
	{

	}

	void optionsScreen()
	{

	}// Calls changePassword() and reports()

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

	void customerDetails()
	{

	}// calls addCustomer() and removeCustomer()

	void addCustomer()
	{

	}

	void removeCustomer()
	{

	}

	void editCustomerDetails()
	{

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
