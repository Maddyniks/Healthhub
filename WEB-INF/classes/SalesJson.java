import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//import org.json.JSONObject;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalesJson")

public class SalesJson extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("application/json");
		PrintWriter pw =response.getWriter();
		Gson gson=new Gson();
		// MySqlDataStoreUtilities dbInstance = new MySqlDataStoreUtilities();
		// dbInstance.getConnection();
		ArrayList<DoctorTransactionType> productList = MySqlDataStoreUtilities.getDoctorTransactions();
		String result=gson.toJson(productList);
        pw.println(result);
        
	}	
}
