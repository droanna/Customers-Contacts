package FileReaders.CSVReader;

import Entity.Contact;
import Entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    boolean isDigit;
    boolean isEmail;
    boolean isPhone;
    private Customer customer;
    private Contact contact = new Contact();
    private List<Contact> customerContacts;

    public void parseLine(String line) {
        customer = new Customer();
        customerContacts = new ArrayList<>();
        String separator = ",";
        String[] elements = line.split(separator);
        customer.setName(elements[0]);
        customer.setSurname(elements[1]);
        int age = 0;
        if(!elements[2].isEmpty()) {
            age = Integer.parseInt(elements[2]);
        }
        customer.setAge(age);


        for (int i = 4; i < elements.length; i++) {
            contact = new Contact();
            contact.setCustomer(customer);
            String element = elements[i].replaceAll(" ", "");
            checkContactType(element);
            if (isPhone) {
                contact.setType(2);
            } else if (isEmail) {
                contact.setType(1);
            } else {
                contact.setType(0);
            }
            contact.setContact(element);

            customerContacts.add(contact);
        }
    }

    private void checkContactType(String element) {
        isDigit = true;
        isEmail = false;
        isPhone = false;
        for (int j = 0; j < element.length(); j++) {
            if (element.charAt(j) < 48 || element.charAt(j) > 57) {
                isDigit = false;
                if (element.charAt(j) == '@') {
                    isEmail = true;
                }
            }
        }
        if (isDigit && element.length() == 9) {
            isPhone = true;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Contact> getCustomerContacts() {
        return customerContacts;
    }
}

