package FileReaders;

import Entity.Contact;
import Entity.Customer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLReader {

    private List<Customer> customers;
    private List<Contact> contacts;


    public void readXMLFile(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(new File(filePath), xmlHandler);
            customers = xmlHandler.getCustomers();
            contacts = xmlHandler.getContacts();
        } catch (IOException | SAXException | ParserConfigurationException e){
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
