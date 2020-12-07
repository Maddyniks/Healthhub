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

@WebServlet("/Analytics")

public class Analytics extends HttpServlet {

    ArrayList<String> register = new ArrayList<>();
    String insuranceregister="",pharmacyregister="",doctorregister="";

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        doctorregister = MySqlDataStoreUtilities.getRegistered();
        insuranceregister = MySqlDataStoreUtilities.getRegisteredInsurance();
        pharmacyregister = MySqlDataStoreUtilities.getRegisteredPharma();

        System.out.println(doctorregister);
        System.out.println(insuranceregister);
        System.out.println(pharmacyregister);

        String name = "Analytics";
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");
        pw.print("<div id='content'><div class='post'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>Healthhub Statistics</h5>");


        pw.print("<div style = 'display:flex; flex-direction: row; justify-content:center; '>");

        pw.print("<div class='card bg-light' style = 'margin: 0.5rem; padding:0.5rem;'>");
        pw.print("<h6 class='card-title' style = 'text-align: center'>Doctors Registered on Healthhub</h6>");
        pw.print("<div class='card-body'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>"+doctorregister+"</h5>");
        pw.print("</div>");
        pw.print("</div>");

        pw.print("<div class='card bg-light' style = 'margin: 0.5rem; padding:0.5rem;'>");
        pw.print("<h6 class='card-title' style = 'text-align: center'>Pharmacy Registered on Healthhub</h6>");
        pw.print("<div class='card-body'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>"+pharmacyregister+"</h5>");
        pw.print("</div>");
        pw.print("</div>");

        pw.print("<div class='card bg-light' style = 'margin: 0.5rem; padding:0.5rem;'>");
        pw.print("<h6 class='card-title' style = 'text-align: center'>Insurance Sold on Healthhub</h6>");
        pw.print("<div class='card-body'>");
        pw.print("<h5 style = 'text-align: center' class='display-4'>"+insuranceregister+"</h5>");
        pw.print("</div>");
        pw.print("</div>");
       
        pw.print("</div>");

        pw.print("</div>");

        pw.print("</div>");

        utility.printHtml("Footer.html");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}