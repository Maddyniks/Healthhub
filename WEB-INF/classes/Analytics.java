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
        pw.print("<h5 style = 'text-align: center' class='display-4'>Registration's on Healthhub</h5>");
        pw.print("<div class='entry'><table id='registered'>");
        pw.print("<tr>");
        pw.print("<td>");
        pw.print("Doctors Registered on Healthhub");
        pw.print("</td>");
        pw.print("<td>");
        pw.print(doctorregister);
        pw.print("</td>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td>");
        pw.print("Pharmacy Registered on Healthhub");
        pw.print("</td>");
        pw.print("<td>");
        pw.print(pharmacyregister);
        pw.print("</td>");
        pw.print("</tr>");
        pw.print("<tr>");
        pw.print("<td>");
        pw.print("Insurance Sold on Healthhub");
        pw.print("</td>");
        pw.print("<td>");
        pw.print(insuranceregister);
        pw.print("</td>");
        pw.print("</tr>");
        pw.print("</table></div></div></div>");

        utility.printHtml("Footer.html");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}