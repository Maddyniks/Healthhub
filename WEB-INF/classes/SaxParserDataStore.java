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
    SSType soundsystem;
	PhoneType phone;
   
    static HashMap<String,DoctorType> doctors;
    static HashMap<String,SSType> soundsystems;
	static HashMap<String,PhoneType> phones;
  
    String consoleXmlFileName;
	
    String elementValueRead;
	String currentElement="";
    public SaxParserDataStore()
	{
	}
	public SaxParserDataStore(String consoleXmlFileName) {
    this.consoleXmlFileName = consoleXmlFileName;
    doctors = new HashMap<String, DoctorType>();
	soundsystems=new  HashMap<String, SSType>();
	phones=new HashMap<String, PhoneType>();
	
	
	
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
	
	// when xml start element is parsed store the id into respective hashmap for Doctor, soundsystems etc 
    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {
        if (elementName.equalsIgnoreCase("Doctor")) 
		{
			currentElement="Doctor";
			doctor = new DoctorType();
            doctor.setId(attributes.getValue("id"));
		}
        if (elementName.equalsIgnoreCase("phone"))
		{
			currentElement="phone";
			phone = new PhoneType();
            phone.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("soundsystem"))
		{
			currentElement="soundsystem";
			soundsystem= new SSType();
            soundsystem.setId(attributes.getValue("id"));
		}
    }
	// when xml end element is parsed store the data into respective hashmap for Doctor,soundsystems etc respectively
    @Override
	public void endElement(String str1, String str2, String element) throws SAXException 
	{
		element = element.trim();
		//System.out.println("element = " + element + " | Value = " + elementValueRead);
        if (element.equalsIgnoreCase("image")) {
		    if(currentElement.equals("Doctor"))
				doctor.setImage(elementValueRead);
        	if(currentElement.equals("soundsystem"))
				soundsystem.setImage(elementValueRead);
            if(currentElement.equals("phone"))
				phone.setImage(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("description")) {
		    if(currentElement.equals("Doctor"))
				doctor.setDescription(elementValueRead);
        	if(currentElement.equals("soundsystem"))
				soundsystem.setDescription(elementValueRead);
            if(currentElement.equals("phone"))
				phone.setDescription(elementValueRead);    
			return;
        }
		if (element.equalsIgnoreCase("discount")) {
        	if(currentElement.equals("soundsystem"))
				soundsystem.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("phone"))
				phone.setDiscount(Double.parseDouble(elementValueRead));
			return;
	    }
		if (element.equalsIgnoreCase("condition")) {
        	if(currentElement.equals("soundsystem"))
				soundsystem.setCondition(elementValueRead);
            if(currentElement.equals("phone"))
				phone.setCondition(elementValueRead); 
			return;  
		}
		if (element.equalsIgnoreCase("manufacturer")) {
        	if(currentElement.equals("soundsystem"))
				soundsystem.setRetailer(elementValueRead);
            if(currentElement.equals("phone"))
				phone.setRetailer(elementValueRead);    
			return;
		}
		if(element.equalsIgnoreCase("category")){
			if(currentElement.equals("Doctor"))
				doctor.setCategory(elementValueRead);
			return;
		}
        if (element.equalsIgnoreCase("name")) {
            if(currentElement.equals("Doctor"))
				doctor.setName(elementValueRead);
        	if(currentElement.equals("soundsystem"))
				soundsystem.setName(elementValueRead);
            if(currentElement.equals("phone"))
				phone.setName(elementValueRead); 
			return;
		}
		if(element.equalsIgnoreCase("phoneNumber")){
			if(currentElement.equals("Doctor"))
				doctor.setPhone(elementValueRead);
			return;
		}
		if(element.equalsIgnoreCase("city")){
			if(currentElement.equals("Doctor"))
					doctor.setCity(elementValueRead);
			return;
		}
		if(element.equalsIgnoreCase("zip")){
			if(currentElement.equals("Doctor"))
				doctor.setZip(elementValueRead);
			return;
		}
		if(element.equalsIgnoreCase("latitude")){
			if(currentElement.equals("Doctor"))
				doctor.setLat(elementValueRead);
			return;
		}
		if(element.equalsIgnoreCase("longitude")){
			if(currentElement.equals("Doctor"))
				doctor.setLongi(elementValueRead);
			return;
		}
        if(element.equalsIgnoreCase("price")){
			if(currentElement.equals("Doctor"))
				doctor.setPrice(Double.parseDouble(elementValueRead));
        	if(currentElement.equals("soundsystem"))
				soundsystem.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("phone"))
				phone.setPrice(Double.parseDouble(elementValueRead));   
			return;
		}
		

		try
		{
			if (element.equals("Doctor")) {
				// System.out.println("Name: " + doctor.getName());
				// System.out.println("ID: " + doctor.getId());
				// System.out.println("Price: " + doctor.getPrice());
				// System.out.println("Category: " + doctor.getCategory());
				// System.out.println("Image: " + doctor.getImage());
				// System.out.println("Desc: " + doctor.getDescription());
				// System.out.println("Phone: " + doctor.getPhone());
				// System.out.println("ZIP: " + doctor.getZip());
				// System.out.println("City: " + doctor.getCity());
				// System.out.println("Lat: " + doctor.getLat());
				doctors.put(doctor.getId(),doctor);
				//MySqlDataStoreUtilities.insertProduct("doctor", doctor.getId(), doctor.getName(), doctor.getPrice(), doctor.getImage(), doctor.getRetailer(), doctor.getCondition(), doctor.getDiscount(), doctor.getDescription());  
				return;
			}
	 
			if (element.equals("phone")) {	
				phones.put(phone.getId(),phone);
				MySqlDataStoreUtilities.insertProduct("phone", phone.getId(), phone.getName(), phone.getPrice(), phone.getImage(), phone.getRetailer(), phone.getCondition(), phone.getDiscount(), phone.getDescription());  
				return;
			}
			if (element.equals("soundsystem")) {	  
				soundsystems.put(soundsystem.getId(),soundsystem);
				MySqlDataStoreUtilities.insertProduct("soundsystem", soundsystem.getId(), soundsystem.getName(), soundsystem.getPrice(), soundsystem.getImage(), soundsystem.getRetailer(), soundsystem.getCondition(), soundsystem.getDiscount(), soundsystem.getDescription());
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
