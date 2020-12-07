import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewItem")
public class ViewItem extends HttpServlet 
{
  String currentLocation = "400 E 33rd St, Chicago";

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();

    /* From the HttpServletRequest variable name,type,maker and acessories information are obtained.*/
    Utilities utility = new Utilities(request, pw);
    String name = request.getParameter("name");
    String type = request.getParameter("type");
    String maker = request.getParameter("maker");
    String access = request.getParameter("access");
   
    displayItem(request, response);
  }

  /* displayItem Function shows the products that users has bought, these products will be displayed with Total Amount.*/
  protected void displayItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Utilities utility = new Utilities(request,pw);
  
    String type = request.getParameter("type");
    String id = request.getParameter("id");
   

    utility.printHtml("Header.html");
    utility.printHtml("LeftNavigationBar.html");

    pw.print("<div id = 'content'><div class='post' style = 'padding:1rem;'>");
    switch (type) 
    {
      case "doctors":
        renderDoctorView(id, pw);
        break;

     case "Pharmacy":
        renderPharmacyView(id,pw); 
      break;

      case "Insurance":
        renderInsuranceView(id, pw);
        break;
    }
    pw.print("</div></div>");

 

 
    utility.printHtml("Footer.html");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Utilities utility = new Utilities(request, pw);
    displayItem(request, response);
  }

  protected double getNewPrice(double original, double discount) {
    return  Math.round((original * (100 - discount)) / 100);
  }

  void renderDoctorView(String doctorID, PrintWriter pw)
	{
		DoctorType doctor = MySqlDataStoreUtilities.getDoctor(doctorID);

		pw.print("<div class='card mb-3'>");
		pw.print("<div class='row no-gutters'>");
		pw.print("<div class='col-md-4'>");
		pw.print("<img src='images/doctors/"+doctor.getImage()+"' class='card-img' alt='...'>");
		pw.print("</div>");
		pw.print("<div class='col-md-8'>");
		pw.print("<div class='card-body'>");
		pw.print("<h5 class='card-title'>"+doctor.getName()+"</h5>");
		pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+doctor.getCategory()+", "+doctor.getCity()+", "+ doctor.getZip() +" </h6>");
    pw.print("<h5><span class='badge badge-primary'>Appointment fee $"+doctor.getPrice()+"</span></h5>");
    pw.print("<p style = 'text-align: left' class = 'lead'>"+doctor.getDescription()+"</p>");
    pw.print("<p style = 'text-align: left' class = 'lead'> Contact: "+doctor.getPhone()+"</p>");

    pw.print("<div style = 'display:flex; flex-direction: row; justify-content: space-between;'>");
    pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+doctor.getId()+"'>"+
					"<input type='hidden' name='type' value='doctors'>"+
					"<input type='hidden' name='maker' value='"+doctor.getCategory()+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btn btn-success' value='Book Appointment'></form><br/>");
          
    pw.print("<form action='http://maps.google.com/maps' method='get' target='_blank'>");
    pw.print("<input type='hidden' name='saddr' value = '"+currentLocation+"' />");
    pw.print("<input type='hidden' name='daddr' value='"+doctor.getCity()+"' />");
    pw.print("<input type='submit' value='Get directions' class = 'btn btn-primary'/>");
    pw.print("</form>");
    pw.print("</div>");

		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");
  }
  
  void renderPharmacyView(String id, PrintWriter pw)
	{
    PharmacyType pharmacy = MySqlDataStoreUtilities.getPharmacy(id);
    
		pw.print("<div class='card mb-3'>");
		pw.print("<div class='row no-gutters'>");
		pw.print("<div class='col-md-4'>");
		pw.print("<img src='images/pharmacies/"+pharmacy.getImage()+"' class='card-img' alt='...'>");
		pw.print("</div>");
		pw.print("<div class='col-md-8'>");
		pw.print("<div class='card-body'>");
		pw.print("<h5 class='card-title'>"+pharmacy.getName()+"</h5>");
		pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+pharmacy.getCategory()+", "+pharmacy.getCity()+", "+ pharmacy.getZip() +" </h6>");
    pw.print("<p style = 'text-align: left' class = 'lead'>"+pharmacy.getDescription()+"</p>");
    pw.print("<p style = 'text-align: left' class = 'lead'> Contact: "+pharmacy.getPhone()+"</p>");
    pw.print("<p style = 'text-align: left' class = 'lead'> Email: "+pharmacy.getEmailId()+"</p>");

    pw.print("<div style = 'display:flex; flex-direction: row; justify-content: space-between;'>");
    pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+pharmacy.getId()+"'>"+
					"<input type='hidden' name='type' value='Pharmacy'>"+
					"<input type='hidden' name='maker' value='"+pharmacy.getCategory()+"'>"+
					"<input type='hidden' name='access' value=''>"+
          "<input type='submit' class='btn btn-success' value='Book Appointment'></form><br/>");
          
    pw.print("<form action='http://maps.google.com/maps' method='get' target='_blank'>");
    pw.print("<input type='hidden' name='saddr' value = '"+currentLocation+"' />");
    pw.print("<input type='hidden' name='daddr' value='"+pharmacy.getCity()+"' />");
    pw.print("<input type='submit' value='Get directions' class = 'btn btn-primary'/>");
    pw.print("</form>");
    pw.print("</div>");

		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");

  }
  
  void renderInsuranceView(String id, PrintWriter pw)
	{
    InsuranceType insurance = MySqlDataStoreUtilities.getInsurance(id);
    
		pw.print("<div class='card mb-3'>");
		pw.print("<div class='row no-gutters'>");
		pw.print("<div class='col-md-4'>");
		pw.print("<img src='images/insurances/"+insurance.getImage()+"' class='card-img' alt='...'>");
		pw.print("</div>");
		pw.print("<div class='col-md-8'>");
		pw.print("<div class='card-body'>");
		pw.print("<h5 class='card-title'>"+insurance.getName()+"</h5>");
		pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+insurance.getCategory()+"| "+insurance.getSubCategory()+" </h6>");
		pw.print("<h5 style = 'margin-left: auto; margin-right: auto;'>");
		pw.print("<span class='badge badge-primary'>Price $ "+insurance.getPrice()+"</span>&nbsp;");
		pw.print("<span class='badge badge-secondary'>Duration "+insurance.getDuration()+"</span>&nbsp;");
		pw.print("<span class='badge badge-danger'>Deductibles $ "+insurance.getDeductables()+"</span>&nbsp;");
		pw.print("<span class='badge badge-success'>Total Coverage $ "+insurance.getTotalCov()+"</span>&nbsp;");
    pw.print("</h5>");
    pw.print("<p style = 'text-align: left' class = 'lead'>"+insurance.getDescription()+"</p>");
    pw.print("<p style = 'text-align: left' class = 'lead'> Email: "+insurance.getEmailId()+"</p>");
    
    pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+insurance.getId()+"'>"+
					"<input type='hidden' name='type' value='Insurance'>"+
					"<input type='hidden' name='maker' value='"+insurance.getCategory()+"'>"+
					"<input type='hidden' name='access' value=''>"+
          "<input type='submit' class='btn btn-success' value='Buy Now'></form><br/>");
          
		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");
		pw.print("</div>");

	}
}
