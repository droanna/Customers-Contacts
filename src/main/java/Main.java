import DAO.ContactDAO;
import DAO.CustomerDAO;
import FileReaders.CSVReader;
import FileReaders.XMLReader;

public class Main {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createTable();
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.createTable();
//
//        XMLReader xmlReader = new XMLReader();
//        xmlReader.readXMLFile("dane_osoby_xml.txt");
//        customerDAO.insertAll(xmlReader.getCustomers());
//        contactDAO.insertAll(xmlReader.getContacts());

        CSVReader csvReader = new CSVReader();
        csvReader.readCSVFile("dane_osoby_csv.txt");
        customerDAO.insertAll(csvReader.getCustomers());
        contactDAO.insertAll(csvReader.getContacts());
    }
}
