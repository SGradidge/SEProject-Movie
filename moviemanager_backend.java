import java.sql.*;

import java.util.*;

import java.security.*;
   
public class moviemanager_backend 
{
	private Connection con;
 
    
    public moviemanager_backend()
    {
    	try 
    	{
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Pyro/Desktop/SE Project/Movie.accdb");
			System.out.println("Database successfully opened");
			
			//Put methods here to test
			customerDetails(1);
			//finish();
		} 
    	catch (Exception e) 
    	{
    		System.out.println("Failed to open database");
		}
    	
    }   
    
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

	public String [][] reports(int report)
	{
		ResultSet rs;
		String [][] data  = new String[1][1];
		int size;
		
		try
		{			
			if(report == 1)
			{
				size = 5;
				data = new String[1000][size]; 
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Customer_Details");
			}
			else
			{
				size = 6;
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

	public void addMovie(int productID, String movieName, String genre, String category, double price, int numberAvailable)
	{
			try
			{
	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

	public void removeMovie(int productID)
	{
			try
			{

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

	public void returnMovie(long productID)
	{
		try
		{
			String sql = "UPDATE Customer_Details SET Product_ID = ? WHERE Product_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setLong(2,productID);
			int nrows = pstmt.executeUpdate();
			
			sql = "UPDATE Movie_Details SET Available = ? WHERE Product_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,1);
			pstmt.setLong(2,productID);
			nrows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void rentMovie(long productID, int accNo)
	{
		try
		{
			String sql = "UPDATE Customer_Details SET Product_ID = ? WHERE Account_Number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,productID);
			pstmt.setInt(2,accNo);
			int nrows = pstmt.executeUpdate();
			
			sql = "UPDATE Movie_Details SET Available = ? WHERE Product_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setLong(2,productID);
			nrows = pstmt.executeUpdate();
			
			sql = "UPDATE Customer_Details SET Amount_Outstanding = ? WHERE Account_Number = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,0);
			pstmt.setLong(2,accNo);
			nrows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}
	
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

	public void addCustomer()
	{
		try
		{

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void removeCustomer()
	{
		try
		{

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void editCustomerDetails(int accNo, String fullName, String address, double amount)
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

	public boolean validateNumber(String number, int type)
	{
		try
		{
			if(type == 1)
			{
				String regex = "[\\d+]{4}";
				return number.matches(regex);
			}
			else
			{
				String regex = "[\\d+]{13,13}";
				return number.matches(regex);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	public static void main (String [] args)
	{
		moviemanager_backend mm = new moviemanager_backend();
	}
}
