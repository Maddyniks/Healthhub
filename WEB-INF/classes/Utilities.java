import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/Utilities")

public class Utilities extends HttpServlet{
	HttpServletRequest req;
	PrintWriter pw;
	String url;
	HttpSession session; 

	public Utilities(HttpServletRequest req, PrintWriter pw) 
	{
		this.req = req;
		this.pw = pw;
		this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

	public void printHtml(String file) 
	{
		String result = HtmlToString(file);
		String usertype = usertype();

		String inventoryMarkup = "<li><a href='Inventory'>Inventory</a></li>";
		String salesMarkup = "<li><a href='Sales'>Sales</a></li>";
		//to print the right navigation in header of username cart and logout etc
		if (file == "Header.html") {
				result=result+"<div id='menu' style='float: right;'><ul>";
			if (session.getAttribute("username")!=null){
				String username = session.getAttribute("username").toString();
				username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
				if(usertype.equals("retailer"))
				{
					result = result + inventoryMarkup + salesMarkup;
				}
				result = result + "<li><a href='ViewOrder'>ViewOrder</a></li>"
						+ "<li><a>Hello, "+username+"</a></li>"
						+ "<li><a href='Account'>Account</a></li>"
						+ "<li><a href='Logout'>Logout</a></li>";
			}
			else
				result = result +"<li><a href='ViewOrder'>View Order</a></li>"+ "<li><a href='Login'>Login</a></li>";
				result = result +"<li><a href='Cart'>Cart("+CartCount()+")</a></li></ul></div></div><div id='page'>";
				pw.print(result);
		} else
				pw.print(result);
	}
	
	public String getFullURL() 
	{
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);

		if ((serverPort != 80) && (serverPort != 443)) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		url.append("/");
		return url.toString();
	}

	public String HtmlToString(String file) 
	{
		String result = null;
		try 
		{
			String webPage = url + file;
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) 
			{
				sb.append(charArray, 0, numCharsRead);
			}
			result = sb.toString();
		} 
		catch (Exception e) {
		}
		return result;
	} 

	public void logout(){
		session.removeAttribute("username");
		session.removeAttribute("usertype");
	}
	
	public boolean isLoggedin(){
		if (session.getAttribute("username")==null)
			return false;
		return true;
	}
	
	public String username(){
		if (session.getAttribute("username")!=null)
			return session.getAttribute("username").toString();
		return null;
	}
	
	public String usertype(){
		if (session.getAttribute("usertype")!=null)
			return session.getAttribute("usertype").toString();
		return null;
	}
	
	public User getUser(){
		String usertype = usertype();
		HashMap<String, User> hm=new HashMap<String, User>();
		
		try
		{		 
			hm = MySqlDataStoreUtilities.selectUser();
		}
		catch(Exception e)
		{
		}	
		User user = hm.get(username());
		return user;
	}
	
	public ArrayList<OrderItem> getCustomerOrders(){
		ArrayList<OrderItem> order = new ArrayList<OrderItem>(); 
		if(OrdersHashMap.orders.containsKey(username()))
			order= OrdersHashMap.orders.get(username());
		return order;
	}

	public int getOrderPaymentSize(){
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
		
		try
		{  
			orderPayments = MySqlDataStoreUtilities.selectOrder();
		}
		catch(Exception e)
		{
		
		}
		int size=0;
		for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()){
					size=size + 1;
					
		}
		return size;		
	}

	public int CartCount(){
		if(isLoggedin())
		return getCustomerOrders().size();
		return 0;
	}

	protected double getNewPrice(double original, double discount) {
		return  Math.round((original * (100 - discount)) / 100);
	  }
	
	public void storeProduct(String name,String type,String maker, String acc){
		if(!OrdersHashMap.orders.containsKey(username())){	
			ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
			OrdersHashMap.orders.put(username(), arr);
		}
		ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
		if(type.equals("doctors")){
			DoctorType doctor;
			doctor = SaxParserDataStore.doctors.get(name);
			OrderItem orderitem = new OrderItem(doctor.getId(), doctor.getName(), doctor.getPrice(), doctor.getImage(), type);
			orderItems.add(orderitem);
		}
		if(type.equals("Pharmacy")){
			PharmacyType pharmacy = null;
			pharmacy = SaxParserDataStore.pharmacies.get(name);
			OrderItem orderitem = new OrderItem(pharmacy.getId(), pharmacy.getName(),0, pharmacy.getImage(), type);
			orderItems.add(orderitem);
		}
		if(type.equals("Insurance")){
			InsuranceType insurance = null;
			insurance = SaxParserDataStore.insurances.get(name);
			OrderItem orderitem = new OrderItem(insurance.getId(), insurance.getName(), insurance.getPrice(), insurance.getImage(), type);
			orderItems.add(orderitem);
		}
	}

	public void removeProduct(String name)
	{
		ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
		for( OrderItem temp : orderItems)
		{
			if( temp.getName().equals(name))
			{
				orderItems.remove(temp);
				break;
			}
		}
	}
	
	// store the payment details for orders
	public void storePayment(String userID, String userName, String userAddress, String creditCardNo, int orderId, String productID, String orderName, String category, String orderDate, String shipDate, double orderPrice, int quantity, double discount, double shippingCost, double netTotal, String mode, String storeID, String location)
	{
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
		try
		{
			orderPayments = MySqlDataStoreUtilities.selectOrder();
		}
		catch(Exception e)
		{
		
		}
		if(orderPayments == null)
		{
			orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
		}
		// if there exist order id already add it into same list for order id or create a new record with order id
		
		if(!orderPayments.containsKey(orderId)){	
			ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
			orderPayments.put(orderId, arr);
		}
		ArrayList<OrderPayment> listOrderPayment = orderPayments.get(orderId);		
		OrderPayment orderpayment = new OrderPayment(userID, username(), userAddress, creditCardNo, orderId, productID ,orderName, category, orderDate, shipDate, orderPrice, quantity,discount, shippingCost, netTotal, mode, storeID, location);
		listOrderPayment.add(orderpayment);	
			
			// add order details into file

		try
		{	MySqlDataStoreUtilities.setStock(productID, 1, 0 ); // (productID, quantity, flag) // flag => 0: Sell Opeation 1: Stockup Operation
			MySqlDataStoreUtilities.insertOrder(userID, username(), userAddress, creditCardNo, orderId, productID ,orderName, category, orderDate, shipDate, orderPrice, quantity,discount, shippingCost, netTotal, mode, storeID, location);
		}
		catch(Exception e)
		{
			System.out.println("inside exception file not written properly");
		}	
	}

	
	/* getDoctors Functions returns the Hashmap with all doctors in the store.*/

	public HashMap<String, DoctorType> getDoctors(){
			HashMap<String, DoctorType> hm = new HashMap<String, DoctorType>();
			hm.putAll(SaxParserDataStore.doctors);
			return hm;
	}
	
	/* getPharmacies Functions returns the  Hashmap with all Pharmacies in the store.*/

	public HashMap<String, PharmacyType> getPharmacies(){
			HashMap<String, PharmacyType> hm = new HashMap<String, PharmacyType>();
			hm.putAll(SaxParserDataStore.pharmacies);
			return hm;
	}
	
	/* getInsurances Functions returns the Hashmap with all Phones in the store.*/

	public HashMap<String, InsuranceType> getInsurances(){
			HashMap<String, InsuranceType> hm = new HashMap<String, InsuranceType>();
			hm.putAll(SaxParserDataStore.insurances);
			return hm;
	}

	/* getProducts Functions returns the Arraylist of doctors in the store.*/

	public ArrayList<String> getProducts(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, DoctorType> entry : getDoctors().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	
	/* getProductsPharmacy Functions returns the Arraylist of pharmacies in the store.*/

	public ArrayList<String> getProductsPharmacy(){		
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, PharmacyType> entry : getPharmacies().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	
	/* getProductsPhones Functions returns the Arraylist of Phones in the store.*/

	public ArrayList<String> getProductsInsurance(){		
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, InsuranceType> entry : getInsurances().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}



public String storeReview(String productname,String producttype,String productmaker,String reviewrating,String reviewdate,String  reviewtext,String reatilerpin,String price,String city,String address)
	{
		String message=MongoDBDataStoreUtilities.insertReview(productname,username(),producttype,productmaker,reviewrating,reviewdate,reviewtext,reatilerpin,price,city,address);
		if(!message.equals("Successfull"))
			return "UnSuccessfull";
		else
		{
			HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
			try
			{
				reviews=MongoDBDataStoreUtilities.selectReview();
			}
			catch(Exception e)
			{
				
			}
			if(reviews==null)
			{
				reviews = new HashMap<String, ArrayList<Review>>();
			}
			// if there exist product review already add it into same list for productname or create a new record with product name
				
			if(!reviews.containsKey(productname))
			{	
				ArrayList<Review> arr = new ArrayList<Review>();
				reviews.put(productname, arr);
			}
			ArrayList<Review> listReview = reviews.get(productname);		
			Review review = new Review(productname,username(),producttype,productmaker,reviewrating,reviewdate,reviewtext,reatilerpin,price,city,address);
			listReview.add(review);	
				
			// add Reviews into database
			
			return "Successfull";	
		}
	}
}
