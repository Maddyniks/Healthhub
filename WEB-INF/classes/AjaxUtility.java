import java.io.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.io.IOException;
import java.io.*;

public class AjaxUtility 
{
	StringBuffer sb = new StringBuffer();
	boolean namesAdded = false;
	static Connection conn = null;
    static String message;
	public static String getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthhub","root","1234");							
			message="Successfull";
			return message;
		}
		catch(SQLException e)
		{
			 message="unsuccessful";
		     return message;
		}
		catch(Exception e)
		{
			 message="unsuccessful";
		     return message;
		}
	}
	
	public  StringBuffer readdata(String searchId)
	{	
		HashMap<String,DoctorType> data;
		data = getData();
		
 	    Iterator it = data.entrySet().iterator();	
        while (it.hasNext()) 
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				DoctorType p = (DoctorType)pi.getValue();                   
                if (p.getName().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getId() + "</id>");
                        sb.append("<productName>" + p.getName() + "</productName>");
						sb.append("<productType>" + "doctors"+ "</productType>");
						System.out.println(p.getCategory());
                        //sb.append("<productMaker>" + p.getproductManufacturer() + "</productMaker>");
                        sb.append("</product>");
                }
			}
       }
	   
	   return sb;
	}
	
	public static HashMap<String,DoctorType> getData()
	{
		HashMap<String,DoctorType> hm=new HashMap<String,DoctorType>();
		try
		{
			getConnection();
			
		    String selectproduct="select * from  doctors";
		    PreparedStatement pst = conn.prepareStatement(selectproduct);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{	
				
				DoctorType p = new DoctorType(rs.getString("id"),rs.getString("name"), rs.getDouble("price"), rs.getString("image"),rs.getString("description"),rs.getString("category"),rs.getString("phoneNumber"),rs.getString("city"),rs.getString("zip"),rs.getString("latitude"),rs.getString("longitude"));
                hm.put(rs.getString("name"), p);
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;			
    }
    
	public static void storeData(HashMap<String,Product> productdata)
	{
		try
		{
		
			getConnection();
				
			String insertIntoProductQuery = "INSERT INTO product(productId,productName,image,retailer,productCondition,productPrice,productType,discount) "
			+ "VALUES (?,?,?,?,?,?,?,?);";	
			for(Map.Entry<String, Product> entry : productdata.entrySet())
			{	

				PreparedStatement pst = conn.prepareStatement(insertIntoProductQuery);
				//set the parameter for each column and execute the prepared statement
				pst.setString(1,entry.getValue().getID());
				pst.setString(2,entry.getValue().getproductName());
				pst.setString(3,entry.getValue().getproductImage());
				pst.setString(4,entry.getValue().getproductManufacturer());
				pst.setString(5,entry.getValue().getproductCondition());
				pst.setDouble(6,entry.getValue().getproductPrice());
				pst.setString(7,entry.getValue().getproductType());
				pst.setDouble(8,entry.getValue().getproductDiscount());
				pst.execute();
			}
		}
		catch(Exception e)
		{	
	
		}		
	}
}
