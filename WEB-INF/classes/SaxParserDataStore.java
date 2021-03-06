import org.xml.sax.InputSource;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import  java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDataStore extends DefaultHandler {
    DoctorType doctor;
    PharmacyType pharmacy;
	InsuranceType insurance;
   
    static HashMap<String,DoctorType> doctors;
    static HashMap<String,PharmacyType> pharmacies;
	static HashMap<String,InsuranceType> insurances;
  
    String consoleXmlFileName;
	
    String elementValueRead;
	String currentElement="";
    public SaxParserDataStore()
	{
	}
	public SaxParserDataStore(String consoleXmlFileName) {
    this.consoleXmlFileName = consoleXmlFileName;
    doctors = new HashMap<String, DoctorType>();
	pharmacies=new  HashMap<String, PharmacyType>();
	insurances=new HashMap<String, InsuranceType>();
	
	
	
	//doctors = MySqlDataStoreUtilities.getDoctors();
	parseDocument();
    }

   //parse the xml using sax parser to get the data
    private void parseDocument() 
	{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try 
		{
	    SAXParser parser = factory.newSAXParser();
	    parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
	}
	
	// when xml start element is parsed store the id into respective hashmap for Doctor, pharmacies etc 
    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {
        if (elementName.equalsIgnoreCase("Doctor")) 
		{
			currentElement="Doctor";
			doctor = new DoctorType();
            doctor.setId(attributes.getValue("id"));
		}
        if (elementName.equalsIgnoreCase("Insurance"))
		{
			currentElement="Insurance";
			insurance = new InsuranceType();
            insurance.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("Pharmacy"))
		{
			currentElement="Pharmacy";
			pharmacy= new PharmacyType();
            pharmacy.setId(attributes.getValue("id"));
		}
    }
	// when xml end element is parsed store the data into respective hashmap for Doctor,pharmacies etc respectively
    @Override
	public void endElement(String str1, String str2, String element) throws SAXException 
	{
		element = element.trim();
		//System.out.println("element = " + element + " | Value = " + elementValueRead);
        if (element.equalsIgnoreCase("image")) {
		    if(currentElement.equals("Doctor"))
				doctor.setImage(elementValueRead);
        	if(currentElement.equals("Pharmacy"))
				pharmacy.setImage(elementValueRead);
            if(currentElement.equals("Insurance"))
				insurance.setImage(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("description")) {
		    if(currentElement.equals("Doctor"))
				doctor.setDescription(elementValueRead);
        	if(currentElement.equals("Pharmacy"))
				pharmacy.setDescription(elementValueRead);
            if(currentElement.equals("Insurance"))
				insurance.setDescription(elementValueRead);    
			return;
        }
		// if (element.equalsIgnoreCase("discount")) {
        //     if(currentElement.equals("phone"))
		// 		phone.setDiscount(Double.parseDouble(elementValueRead));
		// 	return;
	    // }
		// if (element.equalsIgnoreCase("condition")) {
        //     if(currentElement.equals("phone"))
		// 		phone.setCondition(elementValueRead); 
		// 	return;  
		// }
		// if (element.equalsIgnoreCase("manufacturer")) {
        //     if(currentElement.equals("phone"))
		// 		phone.setRetailer(elementValueRead);    
		// 	return;
		// }
		if(element.equalsIgnoreCase("category")){
			if(currentElement.equals("Doctor"))
				doctor.setCategory(elementValueRead);

			if(currentElement.equals("Pharmacy"))
				pharmacy.setCategory(elementValueRead);
			
			if(currentElement.equals("Insurance"))
				insurance.setCategory(elementValueRead);
			return;
		}
        if (element.equalsIgnoreCase("name")) {
            if(currentElement.equals("Doctor"))
				doctor.setName(elementValueRead);
        	if(currentElement.equals("Pharmacy"))
				pharmacy.setName(elementValueRead);
            if(currentElement.equals("Insurance"))
				insurance.setName(elementValueRead); 
			return;
		}
		if(element.equalsIgnoreCase("phoneNumber")){
			if(currentElement.equals("Doctor"))
				doctor.setPhone(elementValueRead);
			if(currentElement.equals("Pharmacy"))
				pharmacy.setPhone(elementValueRead);
			return;
		}

		if(element.equalsIgnoreCase("emailId")){			
			if(currentElement.equals("Pharmacy"))
				pharmacy.setEmailId(elementValueRead);

			if(currentElement.equals("Insurance"))
				insurance.setEmailId(elementValueRead);
			return;

		}

		if(element.equalsIgnoreCase("city")){
			if(currentElement.equals("Doctor"))
				doctor.setCity(elementValueRead);
			if(currentElement.equals("Pharmacy"))
				pharmacy.setCity(elementValueRead);
			return;

		}
		if(element.equalsIgnoreCase("zip")){
			if(currentElement.equals("Doctor"))
				doctor.setZip(elementValueRead);
			
			if(currentElement.equals("Pharmacy"))
				pharmacy.setZip(elementValueRead);
			return;

		}
		if(element.equalsIgnoreCase("latitude")){
			if(currentElement.equals("Doctor"))
				doctor.setLat(elementValueRead);

			if(currentElement.equals("Pharmacy"))
				pharmacy.setLat(elementValueRead);
			return;
		}
		if(element.equalsIgnoreCase("longitude")){
			if(currentElement.equals("Doctor"))
				doctor.setLongi(elementValueRead);

			if(currentElement.equals("Pharmacy"))
				pharmacy.setLongi(elementValueRead);
			return;
		}
        if(element.equalsIgnoreCase("price")){
			if(currentElement.equals("Doctor"))
				doctor.setPrice(Double.parseDouble(elementValueRead));

            if(currentElement.equals("Insurance"))
				insurance.setPrice(Double.parseDouble(elementValueRead));   
			return;
		}

		if(element.equalsIgnoreCase("deductables")){
            if(currentElement.equals("Insurance"))
				insurance.setDeductables(Double.parseDouble(elementValueRead));   
			return;
		}

		if(element.equalsIgnoreCase("totalcover")){
            if(currentElement.equals("Insurance"))
				insurance.setTotalCov(Double.parseDouble(elementValueRead));   
			return;
		}

		if(element.equalsIgnoreCase("duration")){
			if(currentElement.equals("Insurance"))
				insurance.setDuration(elementValueRead);
			return;
		}

		if(element.equalsIgnoreCase("subcategory")){
			if(currentElement.equals("Insurance"))
				insurance.setSubCategory(elementValueRead);
			return;
		}


		

		try
		{
			if (element.equals("Doctor")) {
				doctors.put(doctor.getId(),doctor);
				MySqlDataStoreUtilities.insertDoctor(doctor.getId(), doctor.getName(), doctor.getPrice(), doctor.getImage(), doctor.getDescription(), doctor.getCategory(), doctor.getPhone(), doctor.getCity(), doctor.getZip(), doctor.getLat(), doctor.getLongi());  
				return;
			}
	 
			if (element.equals("Insurance")) {	
				insurances.put(insurance.getId(),insurance);
				MySqlDataStoreUtilities.insertInsurance(insurance.getId(), insurance.getName(), insurance.getCategory(), insurance.getSubCategory(), insurance.getPrice(), insurance.getImage(), insurance.getDescription(), insurance.getDuration(), insurance.getEmailId(), insurance.getDeductables(), insurance.getTotalCov());  
				return;
			}
			if (element.equals("Pharmacy")) {	  
				pharmacies.put(pharmacy.getId(),pharmacy);
				MySqlDataStoreUtilities.insertPharmacy(pharmacy.getId(), pharmacy.getName(), pharmacy.getImage(), pharmacy.getDescription(), pharmacy.getCategory(), pharmacy.getPhone(), pharmacy.getEmailId(), pharmacy.getCity(), pharmacy.getZip(), pharmacy.getLat(), pharmacy.getLongi());  
				return;
			}
		}
		catch(Exception e)
		{

		} 
	
	}
	//get each element in xml tag
    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


    /////////////////////////////////////////
    // 	     Kick-Start SAX in main       //
	////////////////////////////////////////
	

	
	public static void addHashmap() {
			String TOMCAT_HOME = System.getProperty("catalina.home");	
			new SaxParserDataStore(TOMCAT_HOME+"\\webapps\\HealthHub\\ProductCatalog.xml");
		} 
}
