import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.util.*;

public class ProductRecommenderUtility
{	
	static Connection conn = null;
    static String message;
	
	public static String getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
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

    public HashMap<String,String> readOutputFile()
    {
		String TOMCAT_HOME = System.getProperty("catalina.home");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
        try 
        {
            br = new BufferedReader(new FileReader(new File(TOMCAT_HOME+"\\webapps\\Healthhub\\matrixFactorizationBasedRecommendations.csv")));
            while ((line = br.readLine()) != null) 
            {
                String[] prod_recm = line.split(cvsSplitBy,2);
				prodRecmMap.put(prod_recm[0],prod_recm[1]);
            }
			
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
		}
		
		return prodRecmMap;
	}
	
    public static PharmacyType getProduct(String product)
    {
        System.out.println("-----------Inside getProduct()----------");
        System.out.println("Requested Product = " + product);
        
        PharmacyType prodObj = new PharmacyType();

        try 
		{
            ArrayList<PharmacyType> productList = MySqlDataStoreUtilities.getInventory();
            for(PharmacyType temp : productList)
            {
                if(temp.getName().contains(product))
                {
                    prodObj = temp;
                    break;
                }
            }

		} 
		catch (Exception ex) 
		{
            System.out.println(ex.getMessage());
        }
        System.out.println("Product Found = " + prodObj.getName());
        System.out.println("------------------------------------");
        return prodObj;
	}
}