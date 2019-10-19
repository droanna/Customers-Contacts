package FileReaders;

import Entity.Contact;
import Entity.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {

    boolean bName = false;
    boolean bSurname = false;
    boolean bAge = false;
    boolean bphone = false;
    boolean bemail = false;
    boolean bjabber = false;
    boolean bunknown = false;

    private List<Customer> customers = new ArrayList<>();
    private List<Contact> contacts = new ArrayList<>();
    private List<Contact> customerContacts = new ArrayList<>();
    private Customer customer;
    private Contact contact;
    private StringBuilder data;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            customer = new Customer();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("surname")) {
            bSurname = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("email")) {
            contact = new Contact();
            bemail = true;
        } else if (qName.equalsIgnoreCase("phone")) {
            contact = new Contact();
            bphone = true;
        } else if (qName.equalsIgnoreCase("jabber")) {
            contact = new Contact();
            bjabber = true;
        } else if (!qName.equalsIgnoreCase("persons") && !qName.equalsIgnoreCase("person") && !qName.equalsIgnoreCase("name")
                && !qName.equalsIgnoreCase("surname") && !qName.equalsIgnoreCase("age") && !qName.equalsIgnoreCase("city") && !qName.equalsIgnoreCase("contacts")
                && !qName.equalsIgnoreCase("phone") && !qName.equalsIgnoreCase("email") && !qName.equalsIgnoreCase("jabber")) {
            contact = new Contact();
            bunknown = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(bName){
            customer.setName(data.toString());
            bName = false;
        } else if(bSurname){
            customer.setSurname(data.toString());
            bSurname = false;
        } else if(bAge){
            customer.setAge(Integer.parseInt(data.toString()));
            bAge = false;
        } else if(bemail){
            contact.setType(1);
            contact.setContact(data.toString());
            contact.setCustomer(customer);
            customerContacts.add(contact);
            bemail = false;
        } else if(bphone){
            contact.setType(2);
            contact.setContact(data.toString());
            contact.setCustomer(customer);
            customerContacts.add(contact);
            bphone = false;
        } else if(bjabber){
            contact.setType(3);
            contact.setContact(data.toString());
            contact.setCustomer(customer);
            customerContacts.add(contact);
            bjabber = false;
        } else if(bunknown){
            contact.setType(0);
            contact.setContact(data.toString());
            contact.setCustomer(customer);
            customerContacts.add(contact);
            bunknown = false;
        }

        if(qName.equalsIgnoreCase("person")){
            customers.add(customer);
            contacts.addAll(customerContacts);
            customerContacts.clear();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
