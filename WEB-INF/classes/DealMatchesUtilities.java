import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DealMatchesUtilities")

public class DealMatchesUtilities extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

        HashMap<String,DoctorType> selectedDoctors=new HashMap<String,DoctorType>();
		try
		{
            pw.print("<div id='content'>");
            pw.print("<div class='post'>");
            pw.print("<div class='entry'>");
            pw.print("<div style = 'display: flex; justify-content: center;'>");
            pw.print("<span class='location-name badge badge-pill badge-info' >Fetching Location...</span>");
            pw.print("</div>");
            pw.print("<h5 style = 'text-align: center' class='display-4'>Top Trending Tweets</h5>");
            pw.print("<br> <br>");
		
			String line=null;
			String TOMCAT_HOME = System.getProperty("catalina.home");

            HashMap<String,DoctorType> productmap=MySqlDataStoreUtilities.getData();
			int i = 0;
			for(Map.Entry<String, DoctorType> entry : productmap.entrySet())
			{
                if(selectedDoctors.size()<2 && !selectedDoctors.containsKey(entry.getKey()))
                {	
                    BufferedReader reader = new BufferedReader(new FileReader (new File(TOMCAT_HOME+"\\webapps\\Healthhub\\DealMatches.txt")));
                    line=reader.readLine().toLowerCase();	
                    if(line==null)
                    {
                        pw.print("<div class='card bg-light'>");
                        pw.print("<div class='card-body'>");
                        pw.print("<h5 style = 'text-align: center'>No Offers Found</h5>");
                        pw.print("</div>");
                        pw.print("</div>");
                        break;
                    }	
                    else
                    {	
                        do 
                        {	
                            if(line.contains(entry.getKey()))
                            {
                                pw.print("<div class='card bg-light'>");
                                pw.print("<div class='card-body'>");
                                pw.print("<p style = 'text-align: center' class = 'lead'>"+line+"</p>");
                                pw.print("</div>");
                                pw.print("</div>");
                                pw.print("<br/>");

                                selectedDoctors.put(entry.getKey(),entry.getValue());
                                break;
                            } 
                        } 
                        while((line = reader.readLine()) != null);
                    }
                }
			}
        }
        catch(Exception e)
        {
            pw.print("<div class='card bg-light'>");
            pw.print("<div class='card-body'>");
            pw.print("<h4 style = 'text-align: center'>No Offers Found</h4>");
            pw.print("</div>");
            pw.print("</div>");
        }
		pw.print("</div>");
		pw.print("</div>");
		pw.print("<div class='post'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>Trending Doctors with HealthHub</h5>");
        pw.print("<div class='entry'>");
        
		if(selectedDoctors.size()==0)
		{
            pw.print("<br> <br>");

		    pw.print("<div class='card'>");
            pw.print("<div class='card-body'>");
            pw.print("<h4 style = 'text-align: center'>No Deals Found</h4>");
            pw.print("</div>");
            pw.print("</div>");	
		}
		else
		{
            pw.print("<table id='bestseller'>");
            pw.print("<tr>");
            for(Map.Entry<String, DoctorType> entry : selectedDoctors.entrySet())
            {
                pw.print("<td>");

                pw.print("<div class='card  bg-light' style=' margin-left: auto; margin-right:auto;'>");
                pw.print("<img src='images/doctors/"+entry.getValue().getImage()+"' class='card-img-top' alt='...'>");
                pw.print("<div class='card-body'>");
                pw.print("<h5 class='card-title'>"+entry.getValue().getName()+"</h5>");
                pw.print("<h6 class='card-subtitle mb-2 text-muted'>"+entry.getValue().getCategory()+"</h6>");
                pw.print("<p class='card-text'>"+entry.getValue().getCity()+"</p>");
                
                pw.print("<form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='" +entry.getValue().getName() + "'>"+
                        "<input type='hidden' name='type' value='doctors'>"+
                        "<input type='hidden' name='maker' value='"+entry.getValue().getCategory()+"'>"+
                        "<input type='hidden' name='price' value='"+entry.getValue().getPrice()+"'>"+
                        "<input type='submit' value='WriteReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
                        
                pw.print("<form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getValue().getName() +"'>"+
                        "<input type='hidden' name='type' value='doctors'>"+
                        "<input type='hidden' name='maker' value='"+entry.getValue().getCategory()+"'>"+
                        "<input type='hidden' name='price' value='"+entry.getValue().getPrice()+"'>"+
                        "<input type='submit' value='ViewReview' class='btn btn-info' style = 'display: block; margin-left: auto; margin-right:auto;'></form><br/>");
                pw.print("</div>");
                pw.print("</div>");
            
                pw.print("</td>");
            }
            pw.print("</tr></table>");
		}
		pw.print("</div></div></div>");
	}
}
