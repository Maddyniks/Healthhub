import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoctorTransactionType")
public class DoctorTransactionType extends HttpServlet{
    String transactionID;
    String userID;
    String userName;
    String doctorID;
    String doctorName;
    double doctorPrice;
    String doctorCategory;
    String doctorCity;
    String doctorZip;
    String doctorLat;
    String doctorLon;
    String appointmentDate;
    String appointmentTime;
    String appointmentDesc;
    String currentStatus;


    public DoctorTransactionType(String transactionID, String userID, String userName, String doctorID, String doctorName, double doctorPrice, String doctorCategory, String doctorCity, String doctorZip, String doctorLat, String doctorLon, String appointmentDate, String appointmentTime, String appointmentDesc, String currentStatus) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.userName = userName;
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorPrice = doctorPrice;
        this.doctorCategory = doctorCategory;
        this.doctorCity = doctorCity;
        this.doctorZip = doctorZip;
        this.doctorLat = doctorLat;
        this.doctorLon = doctorLon;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentDesc = appointmentDesc;
        this.currentStatus = currentStatus;
    }

    public DoctorTransactionType(){
        
    }
	
	

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDoctorID() {
        return this.doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getDoctorPrice() {
        return this.doctorPrice;
    }

    public void setDoctorPrice(double doctorPrice) {
        this.doctorPrice = doctorPrice;
    }

    public String getDoctorCategory() {
        return this.doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }

    public String getDoctorCity() {
        return this.doctorCity;
    }

    public void setDoctorCity(String doctorCity) {
        this.doctorCity = doctorCity;
    }

    public String getDoctorZip() {
        return this.doctorZip;
    }

    public void setDoctorZip(String doctorZip) {
        this.doctorZip = doctorZip;
    }

    public String getDoctorLat() {
        return this.doctorLat;
    }

    public void setDoctorLat(String doctorLat) {
        this.doctorLat = doctorLat;
    }

    public String getDoctorLon() {
        return this.doctorLon;
    }

    public void setDoctorLon(String doctorLon) {
        this.doctorLon = doctorLon;
    }

    public String getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return this.appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentDesc() {
        return this.appointmentDesc;
    }

    public void setAppointmentDesc(String appointmentDesc) {
        this.appointmentDesc = appointmentDesc;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    
}
