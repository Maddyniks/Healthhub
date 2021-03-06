import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.Math;
import java.time.LocalDate;

@WebServlet("/Payment")

public class Payment extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Utilities utility = new Utilities(request, pw);
		User user = utility.getUser();
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to Pay");
			response.sendRedirect("Login");
			return;
		}
		// get the payment details like credit card no address processed from cart servlet	

		String street = request.getParameter("street");		
		String apt = request.getParameter("apt");		
		String city = request.getParameter("city");		
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String userAddress = street + ", " + apt + ", " + city + ", " + state + ", " + zip;
		String creditCardNo=request.getParameter("creditCardNo");
		String mode = request.getParameter("mode");
		String locationDetails = request.getParameter("locationDetails");
		// String[] temp = locationDetails.split("&");
		// String storeID = temp[0];
		// String location = temp[1];
		double shippingCost = 0;

		// if(mode.equals("delivery"))
		// {
		// 	location = "";
		// 	shippingCost = 3;
		// }


		if(!userAddress.isEmpty())
		{
			int min = 100000;
			int max = 999999;
			
			int transactionID =  (int)(Math.random()*(max-min+1)+min);  

			String orderDate = LocalDate.now().toString();
			String shipDate = LocalDate.now().plusDays(14).toString();

			//iterate through each order
			for (OrderItem oi : utility.getCustomerOrders())
			{
				if(oi.getCategory().equals("doctors"))
				{
					DoctorType doctor = MySqlDataStoreUtilities.getDoctor(oi.getId());
					String appointmentDate = request.getParameter("docDate"+oi.getId());
					String appointmentTime = request.getParameter("docTime"+oi.getId());
					String appointmentDesc = request.getParameter("docDesc"+oi.getId());
					MySqlDataStoreUtilities.storeDoctorAppointment(transactionID + "", user.getId(), user.getName(), doctor.getId(), doctor.getName(), doctor.getPrice(), doctor.getCategory(), doctor.getCity(), doctor.getZip(), doctor.getLat(), doctor.getLongi(), appointmentDate, appointmentTime, appointmentDesc, "Pending"  );
				}
				else if(oi.getCategory().equals("Pharmacy"))
				{
					PharmacyType pharmacy = MySqlDataStoreUtilities.getPharmacy(oi.getId());
					String appointmentDate = request.getParameter("pharDate"+oi.getId());
					String appointmentTime = request.getParameter("pharTime"+oi.getId());
					String appointmentDesc = request.getParameter("pharDesc"+oi.getId());
					MySqlDataStoreUtilities.storePharmacyAppointment(transactionID + "", user.getId(), user.getName(), pharmacy.getId(), pharmacy.getName(), pharmacy.getCategory(), pharmacy.getCity(), pharmacy.getZip(), pharmacy.getLat(), pharmacy.getLongi(), appointmentDate, appointmentTime, appointmentDesc, "Pending"  );
				}
				else if(oi.getCategory().equals("Insurance"))
				{
					InsuranceType insurance = MySqlDataStoreUtilities.getInsurance(oi.getId());

					String insEmail = request.getParameter("insEmail"+oi.getId());
					String insphName = request.getParameter("insphName"+oi.getId());
					String insphAge = request.getParameter("insphAge"+oi.getId());
					String insphAdd1 = request.getParameter("insphAdd1"+oi.getId());
					String insphAdd2 = request.getParameter("insphAdd2"+oi.getId());
					String insphCity = request.getParameter("insphCity"+oi.getId());
					String insphZip = request.getParameter("insphZip"+oi.getId());
					String insphPhone = request.getParameter("insphPhone"+oi.getId());

					MySqlDataStoreUtilities.storeInsuranceTransaction(transactionID + "", user.getId(), user.getName(), insurance.getId(), insurance.getName(), insurance.getCategory(), insurance.getSubCategory(), insurance.getPrice(), insurance.getDuration(), insurance.getDeductables(), insurance.getTotalCov(), insEmail, insphName, insphAge, insphAdd1, insphAdd2, insphCity, insphZip, insphPhone );
				}
			}

			//remove the order details from cart after processing			
			OrdersHashMap.orders.remove(utility.username());	

			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order Confirmation</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h2>Success! </h2><br>");
			pw.print("<h3>Your transaction id is <span style = 'font-weight:bold;'>&nbsp;"+(transactionID) + "</span></h3><br>");
			pw.print("<h4 style = 'text-align: center;'> Use this ID to manage your orders.");
			pw.print("</div></div></div>");		
			utility.printHtml("Footer.html");
		}else
		{
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h4 style='color:red'>Please enter valid address and creditcard number</h4>");
			pw.print("</h2></div></div></div>");		
			utility.printHtml("Footer.html");
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		
	}
}
