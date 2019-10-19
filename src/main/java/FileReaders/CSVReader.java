package FileReaders;



import Entity.Contact;
import Entity.Customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private List<Customer> customers = new ArrayList<>();
    private List<Contact> contacts = new ArrayList<>();
    private CSVHandler CSVhandler = new CSVHandler();

    public void readCSVFile(String filePath) {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        try {
            inputStream = new FileInputStream(filePath);
            scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                CSVhandler.parseLine(line);
                customers.add(CSVhandler.getCustomer());
                contacts.addAll(CSVhandler.getCustomerContacts());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (scanner != null) {
                    scanner.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
