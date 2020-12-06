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

@WebServlet("/TopZip")

public class TopZip extends HttpServlet {

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


        String name = "Trending";
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");

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

        utility.printHtml("Footer.html");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

}
