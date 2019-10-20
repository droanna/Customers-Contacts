import DAO.ContactDAO;
import DAO.CustomerDAO;
import FileReaders.CSVReader.CSVReader;
import FileReaders.XMLReader.XMLReader;
import SQLGenerator.DataBaseGenerator;

public class Main {

    public static void main(String[] args) {


        DataBaseGenerator dataBaseGenerator = new DataBaseGenerator();
        dataBaseGenerator.createDatabaseStructure();


        XMLReader xmlReader = new XMLReader();
        xmlReader.readXMLFile("dane_osoby_xml.txt");
        CustomerDAO customerDAO = new CustomerDAO();
        ContactDAO contactDAO = new ContactDAO();
        customerDAO.insertAll(xmlReader.getCustomers());
        contactDAO.insertAll(xmlReader.getContacts());

        CSVReader csvReader = new CSVReader();
        csvReader.readCSVFile("dane_osoby_csv.txt");
        customerDAO.insertAll(csvReader.getCustomers());
        contactDAO.insertAll(csvReader.getContacts());
    }
}
