import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PharmacyTransactionType")
public class PharmacyTransactionType extends HttpServlet{
    String transactionID;
    String userID;
    String userName;
    String pharmacyID;
    String pharmacyName;
    String pharmacyCategory;
    String pharmacyCity;
    String pharmacyZip;
    String pharmacyLat;
    String pharmacyLon;
    String appointmentDate;
    String appointmentTime;
    String appointmentDesc;
    String currentStatus;

    public PharmacyTransactionType(String transactionID, String userID, String userName, String pharmacyID, String pharmacyName, String pharmacyCategory, String pharmacyCity, String pharmacyZip, String pharmacyLat, String pharmacyLon, String appointmentDate, String appointmentTime, String appointmentDesc, String currentStatus) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.userName = userName;
        this.pharmacyID = pharmacyID;
        this.pharmacyName = pharmacyName;
        this.pharmacyCategory = pharmacyCategory;
        this.pharmacyCity = pharmacyCity;
        this.pharmacyZip = pharmacyZip;
        this.pharmacyLat = pharmacyLat;
        this.pharmacyLon = pharmacyLon;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentDesc = appointmentDesc;
        this.currentStatus = currentStatus;
    }

    public PharmacyTransactionType()
    {
        
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

    public String getPharmacyID() {
        return this.pharmacyID;
    }

    public void setPharmacyID(String pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public String getPharmacyName() {
        return this.pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyCategory() {
        return this.pharmacyCategory;
    }

    public void setPharmacyCategory(String pharmacyCategory) {
        this.pharmacyCategory = pharmacyCategory;
    }

    public String getPharmacyCity() {
        return this.pharmacyCity;
    }

    public void setPharmacyCity(String pharmacyCity) {
        this.pharmacyCity = pharmacyCity;
    }

    public String getPharmacyZip() {
        return this.pharmacyZip;
    }

    public void setPharmacyZip(String pharmacyZip) {
        this.pharmacyZip = pharmacyZip;
    }

    public String getPharmacyLat() {
        return this.pharmacyLat;
    }

    public void setPharmacyLat(String pharmacyLat) {
        this.pharmacyLat = pharmacyLat;
    }

    public String getPharmacyLon() {
        return this.pharmacyLon;
    }

    public void setPharmacyLon(String pharmacyLon) {
        this.pharmacyLon = pharmacyLon;
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