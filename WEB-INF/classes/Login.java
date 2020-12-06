import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and 
		password are validated and added to session variable and display Login Function is called */

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		HashMap<String, User> hm = new HashMap<String, User>();
		
		try
		{		 
		  hm = MySqlDataStoreUtilities.selectUser();
		}
		catch(Exception e)
		{
				
		}
		User user = hm.get(username);
		if(user!=null)
		{
		 String user_password = user.getPassword();
		 if (password.equals(user_password)) 
			{
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user.getName());
			session.setAttribute("usertype", user.getUsertype());
			System.out.println("Username = " + user.getName() + "Type = " +  user.getUsertype() + "\n");
			response.sendRedirect("Home");
			return;
			}
		}
		displayLogin(request, response, pw, true);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayLogin(request, response, pw, false);
	}


	/*  Login Screen is Displayed, Registered User specifies credentials and logins into the Best Deal Application. */
	protected void displayLogin(HttpServletRequest request,
			HttpServletResponse response, PrintWriter pw, boolean error)
			throws ServletException, IOException {

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<div class='post' style='float: none; width: 100%'>");
		pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Login</a></h2>"
				+ "<div class='entry'>"
				+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
		if (error)
			pw.print("<span class='badge badge-pill badge-danger'>Please check your username and password !</span>");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("login_msg")!=null){			
			pw.print("<span class='badge badge-pill badge-danger'>"+session.getAttribute("login_msg")+"</span>");
			session.removeAttribute("login_msg");
		}

		pw.print("<form  method='post' action='Login'>");
		pw.print("<div class='form-group'>");
		pw.print("<label for='exampleInputEmail1'>Username</label>");
		pw.print("<input type='text' name='username' class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' required>");
		pw.print("<small id='emailHelp' class='form-text text-muted'>We'll never share your email with anyone else.</small>");
		pw.print("</div>");
		pw.print("<div class='form-group'>");
		pw.print("<label for='exampleInputPassword1'>Password</label>");
		pw.print("<input type='password' name='password' class='form-control' id='exampleInputPassword1' required>");
		pw.print("<a href='Registration' class='badge badge-primary'>New User? Sign up here!</a>");
		pw.print("</div>");
		pw.print("<button type='submit' class='btn btn-primary'>Login</button>");
		pw.print("</form>");

		pw.print("</div></div></div>");
		
		utility.printHtml("Footer.html");
	}

}
