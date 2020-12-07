import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.google.gson.Gson;

@WebServlet("/Trending")

public class Trending extends HttpServlet {

    ArrayList<Mostsold> mostsold = new ArrayList<Mostsold>();
    ArrayList<Mostsoldzip> mostsoldzip = new ArrayList<Mostsoldzip>();
    ArrayList<BestRating> bestrated = new ArrayList<BestRating>();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        mostsold = MongoDBDataStoreUtilities.mostsoldProducts();
        //System.out.println("mostsold size:" + mostsold.size());
        mostsoldzip = MongoDBDataStoreUtilities.mostsoldZip();
        System.out.println("mostsoldzip: "+mostsoldzip.size());
        bestrated = MongoDBDataStoreUtilities.topProducts();

        for (Mostsoldzip mostsoldzip1: mostsoldzip){
            System.out.println(mostsoldzip1.getZipcode());
            System.out.println(mostsoldzip1.getCount());
        }


        ArrayList<DoctorTransactionType> doctors = new ArrayList<DoctorTransactionType>();

        try{
            doctors = MySqlDataStoreUtilities.getDoctorTransactions();
            System.out.println("SIZE:"+doctors.size());
            for (DoctorTransactionType doctort: doctors){
                System.out.println(doctort.getDoctorID());
            }
    

        }
        catch(Exception e){

        }

        String name = "Trending";
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");
        pw.print("<div id='content'><div class='post'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>User's Favorite</h5>");
        pw.print("<div class='entry'><table id='bestseller'>");
        Iterator itr2 = bestrated.iterator();
        while (itr2.hasNext()) {
            BestRating best = (BestRating) itr2.next();
            pw.print("<tr>");
            pw.print("<td>");
            pw.print(best.getProductname().replace("_"," "));
            pw.print("</td>");
            pw.print("<td>");
            pw.print(best.getRating());
            pw.print("</td>");
            pw.print("</tr>");
        }
        pw.print("</table></div></div></div>");

        pw.print("<div id='content'><div class='post'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>Popular Locations</h5>");
        pw.print("<div class='entry'><table id='bestseller'>");
        Iterator itr1 = mostsoldzip.iterator();
        while (itr1.hasNext()) {
            Mostsoldzip mostzip = (Mostsoldzip) itr1.next();
            pw.print("<tr>");
            pw.println("<td border: 1px >");
            System.out.println(mostzip.getZipcode());
            pw.println(mostzip.getZipcode());
            pw.println("</td>");
            pw.println("<td border: 1px >");
            pw.println(mostzip.getCount());
            pw.println("</td>");
            pw.println("</tr>");
        }
        pw.print("</table></div></div></div>");

        pw.print("<div id='content'><div class='post'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>Popular on HealthHub</h5>");
        pw.print("<div class='entry'><table id='bestseller'>");

        Iterator itr = mostsold.iterator();
        while (itr.hasNext()) {
            Mostsold most = (Mostsold) itr.next();
            pw.println("<tr>");
            pw.println("<td border: 1px >");
            pw.println(most.getProductname().replace("_"," "));
            pw.println("</td>");
            pw.println("<td border: 1px >");
            pw.println(most.getCount());
            pw.println("</td>");
            pw.println("</tr>");
        }
        pw.print("</table></div></div></div>");

        pw.println("<section id='content' style=\"width:100%;background-color:white;\">");
		pw.println("<article> <h1 align=\"center\"><span style='color:red;'>"+"Sales Chart</span></h1> ");
		pw.println("<div id=\"sales_barchart\" ></div>");
		pw.println("</article></section>");
		
        //displaySalesTable(doctors, pw);

        //	pw.print("</table></div></div></div>");
        utility.printHtml("Footer.html");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
                
                          
                                        
    }

    // void displaySalesTable(ArrayList<DoctorTransactionType> productList, PrintWriter pw)
	// {
	// 	int size = productList.size();

				
	// 	if(size>0)
	// 	{	
	// 		//pw.print("<br><h3 style = 'text-align: center;'> Sales Table</h3><br>");
	// 		pw.print("<button id='btnGetChartData2' class='btnbuy'>View Chart</button>");
	// 		pw.println("<div id='chart_div'></div><br/>");
	// 		pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
	// 		pw.println("<script type='text/javascript' src='DataVisualization.js'></script>");
			
	// 		// pw.print("<table class='gridtable' style = \"width: 100%;\"><tr>");
	// 		// pw.print("<th style = 'text-align: center;'>No.</th>");
	// 		// pw.print("<th style = 'text-align: center;'>Product Name</th>");
	// 		// pw.print("<th style = 'text-align: center;'>Sale Price </th>");
	// 		// pw.print("<th style = 'text-align: center;'>No. of items sold</th>");
	// 		// pw.print("<th style = 'text-align: center;'>Net Revenue</th></tr>");
        
    //         // int count = 1;
    //         // for(Product temp : productList)	
    //         // {
               
    //         //     pw.print("<tr>");					
    //         //     pw.print("<td>"+count+"</td>");
    //         //     pw.print("<td >"+temp.getproductName()+"</td>");
    //         //     pw.print("<td> $ "+getNewPrice(temp.getproductPrice(), temp.getproductDiscount())+"</td>");
	// 		// 	pw.print("<td> "+temp.getstock()+"</td>");
    //         //     pw.print("<td >$ "+getRevenue(temp.getstock(), getNewPrice(temp.getproductPrice(), temp.getproductDiscount()))+"</td>");
    //         //     pw.print("</tr>"); 
    //         //     count++;
    //         // }
	// 		// pw.print("</table>");
	// 	}
	// 	else
	// 	{
	// 		pw.print("<h4 style='color:red; text-align:center;'>There are no product to display.</h4>");
	// 	}

	// 	pw.print("</table>");		
    // }
    

}
