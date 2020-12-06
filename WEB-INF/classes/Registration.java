import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Calendar;
import java.util.TimeZone;

@WebServlet("/Registration")

public class Registration extends HttpServlet {
	private String error_msg;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayRegistration(request, response, pw, false);
	}

	/*   Username,Password,Usertype information are Obtained from HttpServletRequest variable and validates whether
		 the User Credential Already Exists or else User Details are Added to the Users HashMap */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);

		String userID = String.valueOf(Calendar.getInstance(TimeZone.getTimeZone("GMT--5")).getTime().getTime()/1000);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String usertype = "customer";
		if(!utility.isLoggedin())
			usertype = request.getParameter("usertype");

		//if password and repassword does not match show error message

		if(!password.equals(repassword))
		{
			error_msg = "Passwords doesn't match!";
		}
		else
		{
			HashMap<String, User> hm = new HashMap<String, User>();
			
			//get the user details from MySQL 
			try
			{
				hm = MySqlDataStoreUtilities.selectUser();
			}
			catch(Exception e)
			{
				
			}

			// if the user already exist show error that already exist

			if(hm.containsKey(username))
				error_msg = "Username already exist as " + usertype;
			else
			{
				/*create a user object and store details into hashmap
				store the user hashmap into file  */
				
				User user = new User(userID, username, password, usertype);
				hm.put(username, user);
				
				MySqlDataStoreUtilities.insertUser(userID, username, password, usertype);	

				HttpSession session = request.getSession(true);				
				session.setAttribute("login_msg", "Your "+usertype+" account has been created. Please login");
				if(!utility.isLoggedin()){
					response.sendRedirect("Login"); return;
				} else {
					response.sendRedirect("Account"); return;
				}
			}
		}

		//display the error message
		if(utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", error_msg);
			response.sendRedirect("Account"); return;
		}
		displayRegistration(request, response, pw, true);	
	}

	/*  displayRegistration function displays the Registration page of New User */
	protected void displayRegistration(HttpServletRequest request, HttpServletResponse response, PrintWriter pw, boolean error) throws ServletException, IOException 
	{
		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");

		pw.print("<div class='post' style='float: none; width: 100%'>");
		pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Sign Up</a></h2>"
				+ "<div class='entry'>"
				+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
		if (error)
			pw.print("<span class='badge badge-pill badge-danger'>"+error_msg+"</span>");

		pw.print("<form method='post' action='Registration'>");
		pw.print("<div class='form-group'>");
		pw.print("<label for='exampleInputEmail1'>Username</label>");
		pw.print("<input type='text' name='username' class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' required>");
		pw.print("<small id='emailHelp' class='form-text text-muted'>We'll never share your Username with anyone else.</small>");
		pw.print("</div>");
		pw.print("<div class='form-group'>");
		pw.print("<label for='exampleInputPassword1'>Password</label>");
		pw.print("<input type='password' name='password' class='form-control' id='exampleInputPassword1' required>");
		pw.print("</div>");
		pw.print("<div class='form-group'>");
		pw.print("<label for='exampleInputPassword2'>Confirm Password</label>");
		pw.print("<input type='password' name='repassword' class='form-control' id='exampleInputPassword2' required>");
		pw.print("<input type='hidden' name='usertype' value='customer' class='form-control' required>");
		pw.print("</div>");
		pw.print("<button type='submit' name='ByUser' class='btn btn-primary' value='Create User'>Create User</button>");
		pw.print("</form>");

		pw.print("</div></div></div>");

		utility.printHtml("Footer.html");
	}


}
