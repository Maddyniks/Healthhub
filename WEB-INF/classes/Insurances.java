import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insurances")

public class Insurances extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = null;
		String CategoryName = request.getParameter("maker");
		HashMap<String, InsuranceType> hm = new HashMap<String, InsuranceType>();

		if (CategoryName == null)	
		{
			hm.putAll(SaxParserDataStore.insurances);
			name = "";
		} 
		else 
		{
			if(CategoryName.trim().equals("United-Health"))
			{
			  for(Map.Entry<String,InsuranceType> entry : SaxParserDataStore.insurances.entrySet())
			  {
				 if(entry.getValue().getCategory().equals("United Health"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
			  }
				 name = "United Health";
			}
			else if(CategoryName.equals("Aetna-Health"))
			 {
			 for(Map.Entry<String,InsuranceType> entry : SaxParserDataStore.insurances.entrySet())
				 {
				  if(entry.getValue().getCategory().equals("Aetna Health"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
				 }
				  name = "Aetna Health";
			 }
			 else if(CategoryName.equals("Kaiser-Foundation"))
			 {
				 for(Map.Entry<String,InsuranceType> entry : SaxParserDataStore.insurances.entrySet())
				 {
				  if(entry.getValue().getCategory().equals("Kaiser Foundation"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
				 }
					 name = "Kaiser Foundation";
			 }
		}
		
		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>" + name + " Insurances</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		for (Map.Entry<String, InsuranceType> entry : hm.entrySet()) {
			InsuranceType insurance = entry.getValue();
			//System.out.println(insurance.getName() + " | " + insurance.getCity() + " | " + insurance.getZip());
			if(i%3==1) pw.print("<tr>");
			pw.print("<td>");

			pw.print("<div class='card  bg-light' style=' margin-left: auto; margin-right:auto;'>");
			pw.print("<img src='images/insurances/"+insurance.getImage()+"' class='card-img-top' alt='...'>");
			pw.print("<div class='card-body'>");
			pw.print("<h5 class='card-title'>"+insurance.getName()+"</h5>");
			pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+insurance.getCategory()+"</h6>");
			pw.print("<p class='card-text'>"+insurance.getPrice()+"</p>");

			pw.print("<form name ='ViewItem' action='ViewItem' method='post'>");
			pw.print("<input type='hidden' name='name' value='"+insurance.getName()+"'>"+
					"<input type='hidden' name='type' value='Insurance'>"+
					"<input type='hidden' name='maker' value='"+insurance.getCategory()+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-primary' style = 'display: block; margin-left: auto; margin-right:auto;' value='View Insurance'></form><br/>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='Insurance'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-success' style = 'display: block; margin-left: auto; margin-right:auto;' value='Buy Now'></form><br/>");
			
			pw.print("<form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='" + insurance.getName() + "'>"+
					"<input type='hidden' name='type' value='Insurance'>"+
					"<input type='hidden' name='maker' value='"+insurance.getCategory()+"'>"+
					"<input type='hidden' name='price' value='"+insurance.getPrice()+"'>"+
					"<input type='submit' value='WriteReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
					
			pw.print("<form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+ insurance.getName() +"'>"+
					"<input type='hidden' name='type' value='Insurance'>"+
					"<input type='hidden' name='maker' value='"+insurance.getCategory()+"'>"+
					"<input type='hidden' name='price' value='"+insurance.getPrice()+"'>"+
					"<input type='submit' value='ViewReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
					
					pw.print("</div>");
					pw.print("</div>");
		
		
					
					pw.print("</td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		pw.print("</table></div></div></div>");
   
		utility.printHtml("Footer.html");

	}
}
