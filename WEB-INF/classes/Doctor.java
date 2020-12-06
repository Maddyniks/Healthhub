import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Doctor")

public class Doctor extends HttpServlet {

	/* Doctor Page Displays all the Doctors and their Information in Best Deal */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");
        

		/* Checks the Phones type whether it is microsft or sony or nintendo */

		HashMap<String, DoctorType> hm = new HashMap<String, DoctorType>();
		if(CategoryName==null){
			System.out.println("SaxParserDataStore.doctors.size = " + SaxParserDataStore.doctors.size());
			hm.putAll(SaxParserDataStore.doctors);
			name = "";
		}
		else
		{
		   if(CategoryName.equals("Cardiologist"))
		   {
			 for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
			 {
				if(entry.getValue().getCategory().equals("Cardiologist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Cardiologist";
		   }
		   else if(CategoryName.equals("Endocrinologist"))
		    {
			for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Endocrinologist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				 name = "Endocrinologist";
			}
			else if(CategoryName.equals("Dentist"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Dentist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Dentist";
			}
			else if(CategoryName.equals("Physician"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Physician"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Physician";
			}
			else if(CategoryName.equals("Dermatologist"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Dermatologist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Dermatologist";
			}
			else if(CategoryName.equals("Surgeon"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Surgeon"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Surgeon";
			}
			else if(CategoryName.equals("Allergist"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Allergist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Allergist";
			}
			else if(CategoryName.equals("Anesthesiologist"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Anesthesiologist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Anesthesiologist";
			}
			else if(CategoryName.equals("Physiotherapist"))
			{
				for(Map.Entry<String,DoctorType> entry : SaxParserDataStore.doctors.entrySet())
				{
				 if(entry.getValue().getCategory().equals("Physiotherapist"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Physiotherapist";
			}
		}

		
		/* Header, Left Navigation Bar are Printed.

		All the Doctors and Doctor information are dispalyed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" Doctors</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, DoctorType> entry : hm.entrySet())
		{
			DoctorType doctor = entry.getValue();
			//System.out.println(doctor.getName() + " | " + doctor.getCity() + " | " + doctor.getZip());
			if(i%3==1) pw.print("<tr>");
			pw.print("<td>");

			pw.print("<div class='card' style='width: 20rem; margin-left: auto; margin-right:auto;'>");
			pw.print("<img src='images/doctors/"+doctor.getImage()+"' class='card-img-top' alt='...'>");
			pw.print("<div class='card-body'>");
			pw.print("<h5 class='card-title'>"+doctor.getName()+"</h5>");
			pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+doctor.getCategory()+"</h6>");
			pw.print("<p class='card-text'>"+doctor.getCity()+"</p>");
			pw.print("<form name ='ViewItem' action='ViewItem' method='post'>");
			pw.print("<input type='hidden' name='name' value='"+doctor.getName()+"'>"+
					"<input type='hidden' name='type' value='doctors'>"+
					"<input type='hidden' name='maker' value='"+doctor.getCategory()+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-primary' style = 'display: block; margin-left: auto; margin-right:auto;' value='View Doctor'></form><br/>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='doctors'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-success' style = 'display: block; margin-left: auto; margin-right:auto;' value='Book Appointment'></form><br/>");
			
			pw.print("<form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='" + doctor.getName() + "'>"+
					"<input type='hidden' name='type' value='doctors'>"+
					"<input type='hidden' name='maker' value='"+doctor.getCategory()+"'>"+
					"<input type='hidden' name='price' value='"+doctor.getPrice()+"'>"+
					"<input type='submit' value='WriteReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
					
			pw.print("<form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+ doctor.getName() +"'>"+
					"<input type='hidden' name='type' value='doctors'>"+
					"<input type='hidden' name='maker' value='"+doctor.getCategory()+"'>"+
					"<input type='hidden' name='price' value='"+doctor.getPrice()+"'>"+
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
