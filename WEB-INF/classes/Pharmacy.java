import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pharmacy")

public class Pharmacy extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
				
		String name = null;
		String CategoryName = request.getParameter("maker");

		HashMap<String, PharmacyType> hm = new HashMap<String, PharmacyType>();

		if(CategoryName==null)
		{
			System.out.println("SaxParserDataStore.pharmacies.size = " + SaxParserDataStore.pharmacies.size());
			hm.putAll(SaxParserDataStore.pharmacies);
			name = "";
		}
		else
		{
			if(CategoryName.trim().equals("CVS-Health"))
			{
			  for(Map.Entry<String,PharmacyType> entry : SaxParserDataStore.pharmacies.entrySet())
			  {
				 if(entry.getValue().getCategory().equals("CVS-Health"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
			  }
				 name = "CVS-Health";
			}
			else if(CategoryName.equals("Walgreens"))
			 {
			 for(Map.Entry<String,PharmacyType> entry : SaxParserDataStore.pharmacies.entrySet())
				 {
				  if(entry.getValue().getCategory().equals("Walgreens"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
				 }
				  name = "Walgreens";
			 }
			 else if(CategoryName.equals("Costco-Wholesale-Corp"))
			 {
				 for(Map.Entry<String,PharmacyType> entry : SaxParserDataStore.pharmacies.entrySet())
				 {
				  if(entry.getValue().getCategory().equals("Costco-Wholesale-Corp"))
				  {
					  hm.put(entry.getValue().getId(),entry.getValue());
				  }
				 }
					 name = "Costco-Wholesale-Corp";
			 }
		}

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" Pharmacies</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, PharmacyType> entry : hm.entrySet())
		{
			PharmacyType pharmacy = entry.getValue();
			//System.out.println(pharmacy.getName() + " | " + pharmacy.getCity() + " | " + pharmacy.getZip());
			if(i%3==1) pw.print("<tr>");
			pw.print("<td>");

			pw.print("<div class='card  bg-light' style=' margin-left: auto; margin-right:auto;'>");
			pw.print("<img src='images/pharmacies/"+pharmacy.getImage()+"' class='card-img-top' alt='...'>");
			pw.print("<div class='card-body'>");
			pw.print("<h5 class='card-title'>"+pharmacy.getName()+"</h5>");
			pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+pharmacy.getCategory()+"</h6>");
			pw.print("<p class='card-text'>"+pharmacy.getCity()+"</p>");
			pw.print("<form name ='ViewItem' action='ViewItem' method='post'>");
			pw.print("<input type='hidden' name='type' value='Pharmacy'>"+
					"<input type='hidden' name='id' value='"+pharmacy.getId()+"'>"+
					"<input type='submit' class='btn btn-primary' style = 'display: block; margin-left: auto; margin-right:auto;' value='View Pharmacy'></form><br/>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='Pharmacy'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-success' style = 'display: block; margin-left: auto; margin-right:auto;' value='Book Appointment'></form><br/>");

			pw.print("<form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='" + pharmacy.getName() + "'>"+
					"<input type='hidden' name='type' value='Pharmacy'>"+
					"<input type='hidden' name='maker' value='"+pharmacy.getCategory()+"'>"+
					"<input type='submit' value='WriteReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
					
			pw.print("<form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+ pharmacy.getName() +"'>"+
					"<input type='hidden' name='type' value='Pharmacy'>"+
					"<input type='hidden' name='maker' value='"+pharmacy.getCategory()+"'>"+
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
