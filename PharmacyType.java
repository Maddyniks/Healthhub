import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PharmacyType")

/* 
	PharmacyType class contains class variables name,price,image,retailer,condition,discount.

	PharmacyType class has a constructor with Arguments name,price,image,retailer,condition,discount.
	  
	PharmacyType class contains getters and setters for name,price,image,retailer,condition,discount.

*/

public class PharmacyType extends HttpServlet{
	private String id;
	private String name;
	private String image;
	private String description;
	private String category;
	private String phone;
	private String emailid;
	private String city;
	private String zip;
	private String lat;
	private String longi;
	
	public PharmacyType(String id, String name, String image, String description, String category, String phone, String emailid, String city, String zip, String lat, String longi){
		this.id = id;
		this.name=name;
		this.image=image;
		this.description = description;
		this.category = category;
		this.phone = phone;
		this.emailid = emailid;
		this.city = city;
		this.zip = zip;
		this.lat = lat;
		this.longi = longi;
	}
	
	public PharmacyType(){
		
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

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailid;
	}

	public void setEmailId(String phone) {
		this.emailid = emailid;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	
}
