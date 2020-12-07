import java.sql.*;
import java.util.*;
                	
public class MySqlDataStoreUtilities
{
    static Connection conn = null;

    MySqlDataStoreUtilities()
    {
        getConnection();
    }

    public static void getConnection()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthhub","root","1234");	
        System.out.println("----------------------------------------");
        System.out.println("SQL Connection Established");	
        System.out.println("----------------------------------------");					
        }
        catch(Exception e)
        {
            System.out.println("----------------------------------------");
            System.out.println("SQL Connection Failed: " + e);	
            System.out.println("----------------------------------------");	
        }
    }

    public static void stopConnection()
    {
        try{
            conn.close();
            System.out.println("SQL Connection Closed Successfully ");	
            System.out.println("----------------------------------------");	
        }
        catch(Exception e)
        {
            System.out.println("----------------------------------------");
            System.out.println("Error while closing the connection: " + e);	
            System.out.println("----------------------------------------");	
        }
        
    }

    public static void deleteOrder(int orderId,String orderName)
    {
        try
        {
            String deleteOrderQuery ="Delete from CustomerOrder where OrderId=? and orderName=?";
            PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
            pst.setInt(1,orderId);
            pst.setString(2,orderName);
            pst.executeUpdate();
        }
        catch(Exception e)
        {
                
        }
    }

    public static void deleteUser(String name)
    {
        try
        {
            String deleteUserQuery ="Delete from Registration where username=?";
            PreparedStatement pst = conn.prepareStatement(deleteUserQuery);
            pst.setString(1,name);
            pst.executeUpdate();
        }
        catch(Exception e)
        {            
        }
    }

    public static void insertDoctor(String id, String name, double price, String image, String description, String category, String phoneNumber, String city, String zip, String latitude, String longitude )
    {
        // System.out.println(type + " | " + ID + " | " + name + " | " + price + " | " + image + " | " + manufactorer + " | " + condition + " | " + discount + " | " + description);
        try
        { 
            //getConnection();       
            String insertIntoCustomerOrderQuery = "INSERT INTO doctors(id, name, price, image, description, category, phoneNumber, city, zip, latitude, longitude )"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setDouble(3,price);
            pst.setString(4,image);
            pst.setString(5,description);
            pst.setString(6,category);
            pst.setString(7,phoneNumber);
            pst.setString(8,city);
            pst.setString(9,zip);
            pst.setString(10,latitude);
            pst.setString(11,longitude);
            pst.execute();
            //stopConnection();
        }
        catch(Exception e)
        {
        
        }		
    }

    public static void insertPharmacy(String id, String name, String image, String description, String category, String phoneNumber, String emailId, String city, String zip, String latitude, String longitude )
    {
        // System.out.println(type + " | " + ID + " | " + name + " | " + image + " | " + manufactorer + " | " + condition + " | " + discount + " | " + description);
        try
        {    
            //getConnection();    
            String insertIntoCustomerOrderQuery = "INSERT INTO pharmacy(id, name, image, description, category, phoneNumber, emailId, city, zip, latitude, longitude )"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,image);
            pst.setString(4,description);
            pst.setString(5,category);
            pst.setString(6,phoneNumber);
            pst.setString(7,emailId);
            pst.setString(8,city);
            pst.setString(9,zip);
            pst.setString(10,latitude);
            pst.setString(11,longitude);
            pst.execute();
            //stopConnection();
        }
        catch(Exception e)
        {
        
        }		
    }

    public static void insertInsurance(String id, String name, String category, String subcategory, double price, String image, String description, String duration, String emailId, double deductables, double totalcoverage )
    {
        // System.out.println(type + " | " + ID + " | " + name + " | " + image + " | " + manufactorer + " | " + condition + " | " + discount + " | " + description);
        try
        {  
            //getConnection();      
            String insertIntoCustomerOrderQuery = "INSERT INTO insurance(id, name, category, subcategory, price, image, description, duration, emailId, deductables, totalcoverage )"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,category);
            pst.setString(4,subcategory);
            pst.setDouble(5,price);
            pst.setString(6,image);
            pst.setString(7,description);
            pst.setString(8,duration);
            pst.setString(9,emailId);
            pst.setDouble(10,deductables);
            pst.setDouble(11,totalcoverage);
            pst.execute();
            //stopConnection();
        }
        catch(Exception e)
        {
        
        }		
    }


    public static void insertProduct(String type, String ID, String name, double price, String image, String manufactorer, String condition, double discount, String description)
    {
        // System.out.println(type + " | " + ID + " | " + name + " | " + price + " | " + image + " | " + manufactorer + " | " + condition + " | " + discount + " | " + description);
        try
        {        
            String insertIntoCustomerOrderQuery = "INSERT INTO productDetails(productType, ID, productName, productPrice, productImage, productManufacturer, productCondition, productDiscount, description)"
            + "VALUES (?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            pst.setString(1,type);
            pst.setString(2,ID);
            pst.setString(3,name);
            pst.setDouble(4,price);
            pst.setString(5,image);
            pst.setString(6,manufactorer);
            pst.setString(7,condition);
            pst.setDouble(8,discount);
            pst.setString(9,description);
            pst.execute();
        }
        catch(Exception e)
        {
        
        }		
    }

    public static void insertTransaction()
    {
        String[] users = {"chirag", "nishant", "akash", "dhiraj", "ninad", "harsh", "satyaveer", "chris", "jose", "jean"};
        String [] user_IDS = {"1602341465", "1602462193", "1602465920", "1602465931", "1602465967", "1602465977", "1602465951", "1602466072", "1602466080", "1602466090"};
        
        String [] creditcardno = {"653235654","4654135461","56556556445", "64654654464", "6464545612"};
        String [] orderDate = {"2020-20-08", "2020-21-08","2020-22-08","2020-23-08","2020-24-08"};
        String [] exp_DD = {"2020-07-09", "2020-08-09","2020-09-09","2020-10-09","2020-11-09"};
        String [] act_DD = {"2020-05-09", "2020-09-09","2020-09-09","2020-09-09","2020-12-09"};
        String [] zipArr = {"60616", "425401", "411004", "484645", "564565"};
       
        String [] productIDs = {"al1", "al2", "al3", "amz1", "amz2", "amz3", "ap1", "ap2", "ap3", "dl1"};
        String [] productNames = {"Apple Macbook Air", "Apple Macbook Pro", "Apple Macbook Pro 16", "Amazon - Echo Dot (3rd Gen) - Smart Speaker with Alexa - Charcoal", "Amazon - Echo Studio Smart Speaker with Alexa - Charcoal", "Amazon - Echo Dot Kids Edition Smart Speaker with Alexa - Rainbow", "Apple iPhone 11", "Apple iPhone 11 Pro", "Apple iPhone 11 Pro Max", "Dell Inspiron 6546"};
        String [] categories = {"laptop", "laptop","laptop", "va", "va", "va", "phone", "phone", "phone", "laptop"};
        String [] manuf = {"Apple", "Apple", "Apple", "Amazon", "Amazon","Amazon","Apple", "Apple", "Apple", "Dell"};

        String [] modeArr = {"delivery", "pickup"};
        String [] statusArr = {"disputed", "approved"};
        String [] returnedArr = {"Yes", "No"};

        int indexMin = 0, ageMin = 18, commonMin = 0, modeMin = 0;
        int indexMax = 9, ageMax = 30, commonMax = 4, modeMax = 1;
        int min = 100000;
        int max = 999999;

        try
        {        

            
                int nameIndex = (int)(Math.random()*(indexMax-indexMin+1)+indexMin);  
                int productIndex = (int)(Math.random()*(indexMax-indexMin+1)+indexMin);  	
                int ageIndex = (int)(Math.random()*(ageMax-ageMin+1)+ageMin);  	
                int orderId =  (int)(Math.random()*(max-min+1)+min); 
                int commonIndex =  (int)(Math.random()*(commonMax-commonMin+1)+commonMin);  
                int rand_rating = (int)(Math.random()*(5-1+1)+1);
                int modeIndex =  (int)(Math.random()*(modeMax-modeMin+1)+modeMin);  
                int statusIndex =  (int)(Math.random()*(modeMax-modeMin+1)+modeMin);  
                int returnedIndex =  (int)(Math.random()*(modeMax-modeMin+1)+modeMin);  
                int onTimeIndex =  (int)(Math.random()*(modeMax-modeMin+1)+modeMin);  
                
                String query = "INSERT INTO transactions(loginID,customerName, customerAge,creditCardNo,OrderID,orderDate,exp_deliveryDate,act_deliveryDate,productID,productName,category,manufacturer,rating,del_trackingID,mode,del_ZIP,status,returned,onTime)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
                
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1,user_IDS[nameIndex]);
                pst.setString(2,users[nameIndex]);
                pst.setInt(3,ageIndex);
                pst.setString(4,creditcardno[commonIndex]);
                pst.setInt(5,orderId);
                pst.setString(6,orderDate[commonIndex]);
                pst.setString(7,exp_DD[commonIndex]);
                pst.setString(8,act_DD[commonIndex]);
                pst.setString(9,productIDs[productIndex]);
                pst.setString(10,productNames[productIndex]);
                pst.setString(11,categories[productIndex]);
                pst.setString(12,manuf[productIndex]);
                pst.setInt(13,rand_rating);
                pst.setString(14,"" + orderId);
                pst.setString(15,zipArr[commonIndex]);
                pst.setString(16,modeArr[modeIndex]);
                pst.setString(17,statusArr[statusIndex]);
                pst.setString(18,returnedArr[returnedIndex]);
                pst.setString(19,returnedArr[onTimeIndex]);
                pst.execute();            
        }
        catch(Exception e)
        {
        
        }		
    }

    public static HashMap<String,DoctorType> getDoctors(){
        HashMap<String,DoctorType> doctors = new HashMap<String,DoctorType>();            
        try
        {			
            String selectOrderQuery ="select * from productDetails where productType = 'doctor'";			
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            ResultSet rs = pst.executeQuery();	
           
            while(rs.next())
            {
                //DoctorType doctor = new DoctorType(rs.getString("ID"), rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"), rs.getString("description"));
               // doctors.put(doctor.getId(), doctor);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return doctors;
    }


    public static void insertOrder(String userID, String userName, String userAddress, String creditCardNo, int orderId, String productID, String orderName, String category, String orderDate, String shipDate, double orderPrice, int quantity, double discount, double shippingCost, double netTotal, String mode, String storeID, String location)
    {
        try
        {        
            String insertIntoCustomerOrderQuery = "INSERT INTO CustomerOrder(OrderId, userID, userName, orderName, productID, category, quantity, discount, shippingCost, netTotal, orderPrice, userAddress, creditCardNo, mode, storeID, location, orderDate, shipDate)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            //set the parameter for each column and execute the prepared statement
            pst.setInt(1,orderId);
            pst.setString(2,userID);
            pst.setString(3,userName);
            pst.setString(4,orderName);
            pst.setString(5,productID);
            pst.setString(6,category);
            pst.setInt(7,quantity);
            pst.setDouble(8,discount);
            pst.setDouble(9,shippingCost);
            pst.setDouble(10,netTotal);
            pst.setDouble(11,orderPrice);
            pst.setString(12,userAddress);
            pst.setString(13,creditCardNo);
            pst.setString(14,mode);
            pst.setString(15,storeID);
            pst.setString(16,location);
            pst.setString(17,orderDate);
            pst.setString(18,shipDate);
            pst.execute();
        }
        catch(Exception e)
        {
        
        }		
    }

    public static int getStock(String ID)
    {
        int stock = 0; 
        try
        {
            String getStockQuery = "SELECT Stock FROM productDetails WHERE ID = ?";	
                    
            PreparedStatement pst = conn.prepareStatement(getStockQuery);
            pst.setString(1,ID);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                stock = rs.getInt("Stock");
            }			
        }
        catch(Exception e)
        {

        }

        return stock;
    }

    // (productID, quantity, flag) // flag => 0: Sell Opeation 1: Stockup Operation
    public static void setStock(String ID, int quantity, int flag)
    {
        try
        {
            int stock = getStock(ID);
            int newStock = stock - quantity;
            if(stock > newStock || flag == 1)
            {
                String setStockQuery = "UPDATE productDetails SET Stock = ? WHERE ID = ?";	 
                PreparedStatement pst = conn.prepareStatement(setStockQuery);
                
                if (flag == 0)
                    pst.setInt(1, newStock );
                else if (flag == 1)
                    pst.setInt(1, quantity );
                pst.setString(2,ID);
                pst.executeUpdate();
            }   
            else
            {
                System.out.println("Not enough quantity available");
            }
        }
        catch(Exception e)
        {

        }     
    }

     public static ArrayList<PharmacyType> getInventory()
    {	
       ArrayList<PharmacyType> productList = new ArrayList<PharmacyType>();
       try
        {			
            String selectInventoryQuery ="select * from pharmacy";			
            PreparedStatement pst = conn.prepareStatement(selectInventoryQuery);
            ResultSet rs = pst.executeQuery();	
            while(rs.next())
            {
              PharmacyType p = new PharmacyType(rs.getString("id"),rs.getString("name"),rs.getString("image"),rs.getString("description"),rs.getString("category"),rs.getString("phoneNumber"),rs.getString("emailId"),rs.getString("city"),rs.getString("zip"),rs.getString("latitude"),rs.getString("longitude"));
              productList.add(p);	 		
            }					
        }
        catch(Exception e)
        {
            
        }
        return productList;
    }

   

    
    public static ArrayList<Product> getDiscountedProducts()
    {	
       ArrayList<Product> productList = new ArrayList<Product>();
       try
        {			
            String selectInventoryQuery ="select * from productDetails WHERE productDiscount > 0";			
            PreparedStatement pst = conn.prepareStatement(selectInventoryQuery);
            ResultSet rs = pst.executeQuery();	
            while(rs.next())
            {
                Product temp = new Product(rs.getString("productType"), rs.getString("ID"), rs.getInt("Stock"), rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"), rs.getString("description"));
                productList.add(temp);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return productList;
    }

    public static ArrayList<Product> getSalesList()
    {	
       ArrayList<Product> productList = new ArrayList<Product>();
       try
        {			
            String selectInventoryQuery ="SELECT orderName, productID, netTotal, COUNT(OrderId) AS ItemSold FROM  customerOrder GROUP BY orderName";			
            PreparedStatement pst = conn.prepareStatement(selectInventoryQuery);
            ResultSet rs = pst.executeQuery();	
            while(rs.next())
            {
                Product temp = new Product("", rs.getString("productID"), rs.getInt("ItemSold"), rs.getString("orderName"), rs.getDouble("netTotal"), "", "", "", 0, "");
                productList.add(temp);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return productList;
    }

    public static ArrayList<Product> getDailySalesList()
    {	
       ArrayList<Product> productList = new ArrayList<Product>();
       try
        {			
            String selectInventoryQuery ="SELECT orderDate, SUM(netTotal) AS Revenue, COUNT(OrderId) AS ItemSold FROM  customerOrder GROUP BY orderDate";			
            PreparedStatement pst = conn.prepareStatement(selectInventoryQuery);
            ResultSet rs = pst.executeQuery();	
            while(rs.next())
            {
                Product temp = new Product("", "", rs.getInt("ItemSold"), rs.getString("orderDate"), rs.getDouble("Revenue"), "", "", "", 0, "");
                productList.add(temp);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return productList;
    }

    public static ArrayList<StoreLocation> getLocations()
    {	
       ArrayList<StoreLocation> locations = new ArrayList<StoreLocation>();            
        try
        {			
            String selectOrderQuery ="select * from locations";			
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            ResultSet rs = pst.executeQuery();	
           
            while(rs.next())
            {
                StoreLocation location = new StoreLocation(rs.getString("storeID"), rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("zip"));
                locations.add(location);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return locations;
    }

    public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
    {	
        HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
            
        try
        {			
            //select the table 
            String selectOrderQuery ="select * from CustomerOrder";			
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            ResultSet rs = pst.executeQuery();	
            ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
            while(rs.next())
            {
                if(!orderPayments.containsKey(rs.getInt("OrderId")))
                {	
                    ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
                    orderPayments.put(rs.getInt("orderId"), arr);
                }
                ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));		
                System.out.println("data is"+rs.getInt("OrderId")+orderPayments.get(rs.getInt("OrderId")));

                //add to orderpayment hashmap
                OrderPayment order = new OrderPayment(rs.getString("userID"), rs.getString("userName"), rs.getString("userAddress"), rs.getString("creditCardNo"), rs.getInt("OrderId"), rs.getString("productID"), rs.getString("orderName"), rs.getString("category"), rs.getString("orderDate"), rs.getString("shipDate"), rs.getDouble("orderPrice"), rs.getInt("quantity"), rs.getFloat("discount"), rs.getFloat("shippingCost"), rs.getFloat("netTotal"), rs.getString("mode"), rs.getString("storeID"), rs.getString("location"));
                listOrderPayment.add(order);		
            }					
        }
        catch(Exception e)
        {
            
        }
        return orderPayments;
    }

    public static void insertUser(String userID, String username, String password, String usertype)
    {
        try
        {	
            String insertIntoCustomerRegisterQuery = "INSERT INTO registration(userID, username, password, usertype) "
            + "VALUES (?,?,?,?);";	
                    
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
            pst.setString(1,userID);
            pst.setString(2,username);
            pst.setString(3,password);            
            pst.setString(4,usertype);
            pst.execute();
        }
        catch(Exception e)
        {
        
        }	
    }

    public static HashMap<String,User> selectUser()
    {	
        HashMap<String,User> hm=new HashMap<String,User>();
        try 
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  Registration";
            ResultSet rs = stmt.executeQuery(selectCustomerQuery);
            while(rs.next())
            {	
                User user = new User(rs.getString("userID"), rs.getString("username"), rs.getString("password"), rs.getString("usertype"));
                hm.put(rs.getString("username"), user);
            }
        }
        catch(Exception e)
        {
        }
        return hm;			
    }
    
    public static HashMap<String,DoctorType> getData()
	{
		HashMap<String,DoctorType> hm=new HashMap<String,DoctorType>();
		try
		{
			getConnection();
			Statement stmt=conn.createStatement();
			String selectCustomerQuery="select * from  doctors";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
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
    
    public static DoctorType getDoctor(String id)
    {
        DoctorType doctor = new DoctorType();
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  doctors where id = \"" + id + "\"";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
				doctor = new DoctorType(rs.getString("id"),rs.getString("name"), rs.getDouble("price"), rs.getString("image"),rs.getString("description"),rs.getString("category"),rs.getString("phoneNumber"),rs.getString("city"),rs.getString("zip"),rs.getString("latitude"),rs.getString("longitude"));
                break;
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getDoctor() in MySqlDataStoreUtilities");
        }

        return doctor;
    }

    public static ArrayList<DoctorTransactionType> getDoctorTransactions()
    {
        ArrayList<DoctorTransactionType> doctors = new ArrayList<DoctorTransactionType>();
        //DoctorTransactionType doctor;
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select *, COUNT(doctorID) AS bookappointment from doctorappointments GROUP BY doctorName" ;
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
                //doctor = new DoctorTransactionType("", "", "", rs.getString("doctorID"), rs.getString("doctorName"),0, "","", "", "", "", "", "", "", "",rs.getInt("bookappointment"));
				//doctor = new DoctorTransactionType(rs.getString("bookappointment"), rs.getString("userID"), rs.getString("userName"), rs.getString("doctorID"), rs.getString("doctorName"),rs.getDouble("doctorPrice"), rs.getString("doctorCategory"),rs.getString("doctorCity"), rs.getString("doctorZip"),rs.getString("doctorLat"),rs.getString("doctorLon"), rs.getString("appointmentDate"),rs.getString("appointmentTime"), rs.getString("appointmentDesc"), rs.getString("currentStatus"));
                DoctorTransactionType doctor = new DoctorTransactionType();
                doctor.setDoctorName(rs.getString("doctorName"));
                doctor.setQuantity(rs.getInt("bookappointment"));
                doctor.setDoctorID(rs.getString("doctorID"));
                doctors.add(doctor);
            
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getDoctors() in MySqlDataStoreUtilities");
        }

        return doctors;
    }

    public static ArrayList<DoctorTransactionType> getDoctorTrnxs(String userID)
    {
        ArrayList<DoctorTransactionType> doctors = new ArrayList<DoctorTransactionType>();
        DoctorTransactionType doctor;
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  doctorappointments where userID = \"" + userID + "\"";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
				doctor = new DoctorTransactionType(rs.getString("transactionID"), rs.getString("userID"), rs.getString("userName"), rs.getString("doctorID"), rs.getString("doctorName"),rs.getDouble("doctorPrice"), rs.getString("doctorCategory"),rs.getString("doctorCity"), rs.getString("doctorZip"),rs.getString("doctorLat"),rs.getString("doctorLon"), rs.getString("appointmentDate"),rs.getString("appointmentTime"), rs.getString("appointmentDesc"), rs.getString("currentStatus"));
                doctors.add(doctor);
                break;
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getDoctors() in MySqlDataStoreUtilities");
        }

        return doctors;
    }

    public static String getRegistered()
    {   
        String doctorregistered ="";
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="Select COUNT(*) as doctorregistered from doctors";
            ResultSet rs = stmt.executeQuery(selectCustomerQuery);

            while(rs.next())
            {
                doctorregistered = rs.getString("doctorregistered");
                break;
            }
            

        }
        catch(Exception e)
        {
            System.out.println("Error in function in getRegistered() in MySqlDataStoreUtilities");
        }

        return doctorregistered;
    }

    public static String getRegisteredPharma()
    {
        String pharmacyregistered ="";
        try
        {
            Statement stmt1=conn.createStatement();
            String selectCustomerQuery1="Select COUNT(*) as pharmacyregistered from pharmacy";
            ResultSet rs1 = stmt1.executeQuery(selectCustomerQuery1);

            while(rs1.next())
            {
                pharmacyregistered = rs1.getString("pharmacyregistered");
                break;
            }


        }
        catch(Exception e)
        {
            System.out.println("Error in function in getRegisteredPharma() in MySqlDataStoreUtilities");
        }

        return pharmacyregistered;
    }

    public static String getRegisteredInsurance()
    {
        String insuranceregistered ="";
        try
        {

            Statement stmt2=conn.createStatement();
            String selectCustomerQuery2="Select COUNT(*) as insuranceregistered from insurance";
            ResultSet rs2 = stmt2.executeQuery(selectCustomerQuery2);

            while(rs2.next())
            {
                insuranceregistered = rs2.getString("insuranceregistered");
                break;
            }

        }
        catch(Exception e)
        {
            System.out.println("Error in function in getRegisteredInsurance() in MySqlDataStoreUtilities");
        }

        return insuranceregistered;
    }


    public static PharmacyType getPharmacy(String id)
    {
        PharmacyType pharmacy = new PharmacyType();
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  pharmacy where id = \"" + id + "\"";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
				pharmacy = new PharmacyType(rs.getString("id"),rs.getString("name"), rs.getString("image"),rs.getString("description"),rs.getString("category"),rs.getString("phoneNumber"),rs.getString("emailId"), rs.getString("city"),rs.getString("zip"),rs.getString("latitude"),rs.getString("longitude"));
                break;
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getPharmacy() in MySqlDataStoreUtilities");
        }

        return pharmacy;
    }

    public static ArrayList<PharmacyTransactionType> getPharmaciesTrnxs(String userID)
    {
        ArrayList<PharmacyTransactionType> pharmacies = new ArrayList<PharmacyTransactionType>();
        PharmacyTransactionType pharmacy;
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  pharmacyAppointments where userID = \"" + userID + "\"";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
				pharmacy = new PharmacyTransactionType(rs.getString("transactionID"), rs.getString("userID"), rs.getString("userName"), rs.getString("pharmacyID"), rs.getString("pharmacyName"), rs.getString("pharmacyCategory"),rs.getString("pharmacyCity"), rs.getString("pharmacyZip"),rs.getString("pharmacyLat"),rs.getString("pharmacyLon"), rs.getString("appointmentDate"),rs.getString("appointmentTime"), rs.getString("appointmentDesc"), rs.getString("currentStatus"));
                pharmacies.add(pharmacy);
                break;
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getPharmacies() in MySqlDataStoreUtilities");
        }

        return pharmacies;
    }

    public static InsuranceType getInsurance(String id)
    {
        InsuranceType insurance = new InsuranceType();
        try
        {
            Statement stmt=conn.createStatement();
            String selectCustomerQuery="select * from  insurance where id = \"" + id + "\"";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
            {	
				insurance = new InsuranceType(rs.getString("id"),rs.getString("name"), rs.getString("category"), rs.getString("subcategory"), rs.getDouble("price"), rs.getString("image"),rs.getString("description"),rs.getString("duration"),rs.getString("emailId"), rs.getDouble("deductables"), rs.getDouble("totalcoverage"));
                break;
			}
        }
        catch(Exception e)
        {
            System.out.println("Error in function in getinsurance() in MySqlDataStoreUtilities");
        }

        return insurance;
    }

    // public static InsuranceType getInsurances(String userID)
    // {
    //     ArrayList<InsuranceType> insurances = new ArrayList<InsuranceType>();
    //     InsuranceType insurance = new InsuranceType();
    //     try
    //     {
    //         Statement stmt=conn.createStatement();
    //         String selectCustomerQuery="select * from  insurancetransaction where userID = \"" + userID + "\"";
	// 		ResultSet rs = stmt.executeQuery(selectCustomerQuery);
	// 		while(rs.next())
    //         {	
	// 			insurance = new InsuranceType(rs.getString("id"),rs.getString("name"), rs.getString("category"), rs.getString("subcategory"), rs.getDouble("price"), rs.getString("image"),rs.getString("description"),rs.getString("duration"),rs.getString("emailId"), rs.getDouble("deductables"), rs.getDouble("totalcoverage"));
    //             insurances.add(insurance);
    //             break;
	// 		}
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println("Error in function in getInsurances() in MySqlDataStoreUtilities");
    //     }

    //     return insurances;
    // }

    public static void storeDoctorAppointment(String transactionID, String userID, String userName, String doctorID, String doctorName, double doctorPrice, String doctorCategory, String doctorCity, String doctorZip, String doctorLat, String doctorLon, String appointmentDate, String appointmentTime, String appointmentDesc, String currentStatus)
    {
        try
        {        
            String addDocAppointmentQuery = "INSERT INTO doctorAppointments(transactionID, userID, userName, doctorID, doctorName, doctorPrice, doctorCategory, doctorCity, doctorZip, doctorLat, doctorLon, appointmentDate, appointmentTime, appointmentDesc, currentStatus)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(addDocAppointmentQuery);
            //set the parameter for each column and execute the prepared statement
            pst.setString(1,transactionID);
            pst.setString(2,userID);
            pst.setString(3,userName);
            pst.setString(4,doctorID);
            pst.setString(5,doctorName);
            pst.setDouble(6,doctorPrice);
            pst.setString(7,doctorCategory);
            pst.setString(8,doctorCity);
            pst.setString(9,doctorZip);
            pst.setString(10,doctorLat);
            pst.setString(11,doctorLon);
            pst.setString(12,appointmentDate);
            pst.setString(13,appointmentTime);
            pst.setString(14,appointmentDesc);
            pst.setString(15,currentStatus);
            pst.execute();
        }
        catch(Exception e)
        {
            System.out.println("Error in function in storeDoctorAppointment() in MySqlDataStoreUtilities");
        }		

    }

    public static void storePharmacyAppointment(String transactionID, String userID, String userName, String pharmacyID, String pharmacyName, String pharmacyCategory, String pharmacyCity, String pharmacyZip, String pharmacyLat, String pharmacyLon, String appointmentDate, String appointmentTime, String appointmentDesc, String currentStatus)
    {
        try
        {        
            String addPharmaAppointmentQuery = "INSERT INTO pharmacyAppointments(transactionID, userID, userName, pharmacyID, pharmacyName, pharmacyCategory, pharmacyCity, pharmacyZip, pharmacyLat, pharmacyLon, appointmentDate, appointmentTime, appointmentDesc, currentStatus)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(addPharmaAppointmentQuery);
            //set the parameter for each column and execute the prepared statement
            pst.setString(1,transactionID);
            pst.setString(2,userID);
            pst.setString(3,userName);
            pst.setString(4,pharmacyID);
            pst.setString(5,pharmacyName);
            pst.setString(6,pharmacyCategory);
            pst.setString(7,pharmacyCity);
            pst.setString(8,pharmacyZip);
            pst.setString(9,pharmacyLat);
            pst.setString(10,pharmacyLon);
            pst.setString(11,appointmentDate);
            pst.setString(12,appointmentTime);
            pst.setString(13,appointmentDesc);
            pst.setString(14,currentStatus);
            pst.execute();
        }
        catch(Exception e)
        {
            System.out.println("Error in function in storePharmacyAppointment() in MySqlDataStoreUtilities: " + e);
        }		
    }

    public static void storeInsuranceTransaction(String transactionID, String userID, String userName, String insuranceID, String insuranceName, String insuranceCategory, String insuranceSubCategory, double insurancePrice, String insuranceDuration, double deductables, double totalcoverage, String email, String phName, String phAge, String phAddress1, String phAddress2, String phCity, String phZIP, String phPhone)
    {
        try
        {        
            String addInsuranceQuery = "INSERT INTO insuranceTransaction(transactionID, userID, userName, insuranceID, insuranceName, insuranceCategory, insuranceSubCategory, insurancePrice, insuranceDuration, deductables, totalcoverage, email, phName, phAge, phAddress1, phAddress2, phCity, phZIP, phPhone )"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";	
                
            PreparedStatement pst = conn.prepareStatement(addInsuranceQuery);
            //set the parameter for each column and execute the prepared statement
            pst.setString(1,transactionID);
            pst.setString(2,userID);
            pst.setString(3,userName);
            pst.setString(4,insuranceID);
            pst.setString(5,insuranceName);
            pst.setString(6,insuranceCategory);
            pst.setString(7,insuranceSubCategory);
            pst.setDouble(8,insurancePrice);
            pst.setString(9,insuranceDuration);
            pst.setDouble(10,deductables);
            pst.setDouble(11,totalcoverage);
            pst.setString(12,email);
            pst.setString(13,phName);
            pst.setString(14,phAge);
            pst.setString(15,phAddress1);
            pst.setString(16,phAddress2);
            pst.setString(17,phCity);
            pst.setString(18,phZIP);
            pst.setString(19,phPhone);
            pst.execute();
        }
        catch(Exception e)
        {
            System.out.println("Error in function in storeInsuranceTransaction() in MySqlDataStoreUtilities");
        }		

    }

}	