import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsuranceType")

/* 
	InsuranceType class contains class variables name,price,image,retailer,condition,discount.

	InsuranceType class has a constructor with Arguments name,price,image,retailer,condition,discount.
	  
	InsuranceType class contains getters and setters for name,price,image,retailer,condition,discount.
*/

public class InsuranceType extends HttpServlet{
	private String id;
	private String name;
	private String category;
	private String subcategory;
	private double price;
	private String image;
	private String description;
	private String duration;
	private String emailid;
	private double deductables;
	private double totalcov;
	
	public InsuranceType(String id, String name, String category, String subcategory, double price, String image, String description, String duration, String emailid,double deductables, double totalcov){
		this.id = id;
		this.name=name;
		this.category = category;
		this.subcategory = subcategory;
		this.price=price;
		this.image=image;
		this.description = description;
		this.duration=duration;
		this.emailid = emailid;
		this.deductables = deductables;
		this.totalcov = totalcov;
	}
	
	public InsuranceType(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subcategory;
	}
	public void setSubCategory(String subcategory) {
		this.subcategory = subcategory;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEmailId() {
		return emailid;
	}

	public void setEmailId(String emailid) {
		this.emailid = emailid;
	}

	public double getDeductables() {
		return deductables;
	}

	public void setDeductables(double deductables) {
		this.deductables = deductables;
	}

	public double getTotalCov() {
		return totalcov;
	}
	public void setTotalCov(double totalcov) {
		this.totalcov = totalcov;
	}
}
