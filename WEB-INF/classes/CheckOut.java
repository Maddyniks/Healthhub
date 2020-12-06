import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/CheckOut")

//once the user clicks buy now button page is redirected to checkout page where user has to give checkout information

public class CheckOut extends HttpServlet 
{
	String []  descriptions;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities Utility = new Utilities(request, pw);
		storeOrders(request, response);
	}
	
	protected void storeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    try
        {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			Utilities utility = new Utilities(request,pw);
			ArrayList<StoreLocation> locations = new ArrayList<StoreLocation>();
			
			if(!utility.isLoggedin())
			{
				HttpSession session = request.getSession(true);				
				session.setAttribute("login_msg", "Please Login to add items to cart");
				response.sendRedirect("Login");
				return;
			}
			HttpSession session=request.getSession(); 

			//get the order product details	on clicking submit the form will be passed to submitorder page	
			User user = utility.getUser();			
			String userName = session.getAttribute("username").toString();
			String orderTotal = request.getParameter("orderTotal");
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<form name ='CheckOut' action='Payment' method='post'>");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");

			pw.print("<table  class='gridtable' style = 'width: 100%'>");
			pw.print("<tr><td style = 'text-align: center;'>Customer ID</td><th>" + user.getId() + "</th></tr>");
			pw.print("<tr><td style = 'text-align: center;'>Customer Name</td><th>" + userName + "</th></tr>");
			pw.print("</table>");

			pw.print("<br>");




			for (OrderItem oi : utility.getCustomerOrders()) 
			{
				if(oi.getCategory().equals("doctors"))
				{
					renderDoctorView(oi, pw);
				}
				else if(oi.getCategory().equals("Pharmacy"))
				{
					renderPharmacyView(oi, pw);
				}
				else
				{
					renderInsuranceView(oi, pw);
				}
			}






			

			// pw.print("<h3>Shipping Details</h3><br>");
			// pw.print("<table>");

			// pw.print("<tr>");
			// pw.print("<th>Street Address</th>");
			// pw.print("<td><input type='text' name='street' required = 'true' style = 'margin-left: 1rem;'></td></tr>");

			// pw.print("<tr>");
			// pw.print("<th>Apt/Suit</th>");
			// pw.print("<td><input type='text' name='apt' required = 'true' style = 'margin-left: 1rem;'></td></tr>");
		
			// pw.print("<tr>");
			// pw.print("<th>City</th>");
			// pw.print("<td><input type='text' name='city' required = 'true' style = 'margin-left: 1rem;'></td></tr>");

			// pw.print("<tr>");
			// pw.print("<th>State</th>");
			// pw.print("<td><input type='text' name='state' required = 'true' style = 'margin-left: 1rem;'></td></tr>");

			// pw.print("<tr>");
			// pw.print("<th>Zip</th>");
			// pw.print("<td><input type='text' name='zip' required = 'true' style = 'margin-left: 1rem;'></td></tr>");

			// pw.print("<tr>");
			// pw.print("<th>Shipping Mode</th>");
			// pw.print("<td><input type='radio' id = 'delivery' name ='mode' value = 'delivery' required = 'true' style = 'margin-left: 1rem;'> <label for='delivery'>Delivery</label><br></td>");
			// pw.print("<td><input type='radio' id = 'pickup' name ='mode' value = 'pickup' required = 'true' > <label for='pickup'>Pickup</label><br></td>");
			// pw.print("</tr>");

			// try{
			// 	locations = MySqlDataStoreUtilities.getLocations();
			// }
			// catch(Exception e){

			// }
			
			// pw.print("<tr>");
			// pw.print("<td colspan='2'>");
			// pw.print("<label>Select Pickup location(if pickup is selected): </label> ");
			// pw.print("<select name = 'locationDetails' class='input' >");
			// for(StoreLocation location : locations)
			// {
			// 	String storeID = location.getStoreID();
			// 	String temp = location.getStreet() + ", " + location.getCity() + ", " + location.getState() + ", " + location.getZip();
			// 	pw.print("<option value = '" + storeID + "&" +  temp + "'>" + temp + "</option>");
			// }
			// pw.print("</td>");
			// pw.print("</tr>");
			// pw.print("<tr><label>Note: Additional $3 per item would be charged if shipping mode is <b>Delivery</b> </label> </tr>");
			// pw.print("</table>");

			pw.print("<table  class='gridtable' style = 'width: 100%'>");
			pw.print("<tr><th style = 'text-align: center;'>Item</th><th style = 'text-align: center;'> Price</th></tr>");
			pw.print("<h3>Summary</h3><br>");
			for (OrderItem oi : utility.getCustomerOrders()) 
			{
				pw.print("<tr><td>" + oi.getName()+"</td><td>" + oi.getPrice() + "</td></tr>");
				pw.print("<input type='hidden' name='orderPrice' value='$ "+oi.getPrice()+"'>");
				pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
			}

			pw.print("<tr><th style = 'text-align: center;'>Total Amount</th><td>$ " + orderTotal + "</td></tr>");
			pw.print("</table><br>");
		

			pw.print("<table>");
			if(Double.parseDouble(orderTotal) > 0.0)
			{
				pw.print("<h3>Payment Details</h3><br>");
				
				pw.print("<tr>");
				pw.print("<th>Credit/Debit Card</th>");
				pw.print("<td><input type='text' name='creditCardNo' required = 'true' style = 'margin-left: 1rem;'> </td></tr>");
			}
			
			pw.print("<tr'><td colspan='2'>");
			pw.print("<input type='submit' name='submit' class='btnbuy' value = 'Place Order' style = 'width: 100%; margin-top: 1rem;'>");
			pw.print("</td></tr></table>");

			pw.print("</form>");
			pw.print("</div></div></div>");		
			utility.printHtml("Footer.html");
	    }
        catch(Exception e)
		{
         System.out.println(e.getMessage());
		}  			
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		response.sendRedirect("Cart");
				return;
		}
		
		void renderDoctorView(OrderItem oi, PrintWriter pw)
		{
			String docDesc = "'docDesc" + oi.getId() + "'";
			String docDate = "'docDate" + oi.getId() + "'";
			String docTime = "'docTime" + oi.getId() + "'";

			DoctorType doctor = MySqlDataStoreUtilities.getDoctor(oi.getId());

			pw.print("<div class='card mb-3'>");
			pw.print("<div class='row no-gutters'>");
			pw.print("<div class='col-md-4'>");
			pw.print("<img src='images/doctors/"+doctor.getImage()+"' class='card-img' alt='...'>");
			pw.print("</div>");
			pw.print("<div class='col-md-8'>");
			pw.print("<div class='card-body'>");
			pw.print("<h5 class='card-title'>"+oi.getName()+"</h5>");
			pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+doctor.getCategory()+", "+doctor.getCity()+", "+ doctor.getZip() +" </h6>");
			pw.print("<h5><span class='badge badge-primary'>Appointment fee $"+doctor.getPrice()+"</span></h5>");
			
			pw.print("<label for = " + docDesc + "'>Please Describe your issue</label><br/>");
			pw.print("<input type='text' id = " + docDesc + "name=" + docDesc + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("<label for = " + docDesc + "'>Appointment Date</label><br/>");
			pw.print("<input type='date' id = " + docDate + "name=" + docDate + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("<label for = " + docTime + "'>Appointment Time</label><br/>");
			pw.print("<input type='time' id = " + docTime + "name=" + docTime + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("</div>");
			pw.print("</div>");
			pw.print("</div>");
			pw.print("</div>");
		}

		void renderPharmacyView(OrderItem oi, PrintWriter pw)
		{
			String pharDesc = "'pharDesc" + oi.getId() + "'";
			String pharDate = "'pharDate" + oi.getId() + "'";
			String pharTime = "'pharTime" + oi.getId() + "'";

			PharmacyType pharmacy = MySqlDataStoreUtilities.getPharmacy(oi.getId());

			pw.print("<div class='card mb-3'>");
			pw.print("<div class='row no-gutters'>");
			pw.print("<div class='col-md-4'>");
			pw.print("<img src='images/pharmacies/"+pharmacy.getImage()+"' class='card-img' alt='...'>");
			pw.print("</div>");
			pw.print("<div class='col-md-8'>");
			pw.print("<div class='card-body'>");
			pw.print("<h5 class='card-title'>"+oi.getName()+"</h5>");
			pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+pharmacy.getCategory()+", "+pharmacy.getCity()+", "+ pharmacy.getZip() +" </h6>");
			
			pw.print("<label for = " + pharDesc + "'>Please Describe your purpose</label><br/>");
			pw.print("<input type='text' id = " + pharDesc + "name=" + pharDesc + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("<label for = " + pharDesc + "'>Appointment Date</label><br/>");
			pw.print("<input type='date' id = " + pharDate + "name=" + pharDate + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("<label for = " + pharTime + "'>Appointment Time</label><br/>");
			pw.print("<input type='time' id = " + pharTime + "name=" + pharTime + " required = 'true' class='form-control form-control-sm'><br/>");

			pw.print("</div>");
			pw.print("</div>");
			pw.print("</div>");
			pw.print("</div>");

		}

		void renderInsuranceView(OrderItem oi, PrintWriter pw)
		{
			pw.print("<div class='panel panel-default'>");
			pw.print("<div class='panel-body'>");
			pw.print("<h4>"+oi.getName()+"</h4>");
			pw.print("</div>");
			pw.print("</div>");
		}
}
