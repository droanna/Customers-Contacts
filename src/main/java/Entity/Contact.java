package Entity;

public class Contact implements Entity{

    private long id;
    private Customer customer;
    private int type;
    private String contact;
    private long customerID;

    public Contact(long id, Customer customer, int type, String contact) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.contact = contact;
    }

    public Contact() {
    }

    public Contact(Customer customer, int type, String contact) {
        this.customer = customer;
        this.type = type;
        this.contact = contact;
    }

    public Contact(long id, long customerID, int type, String contact) {
        this.id = id;
        this.type = type;
        this.contact = contact;
        this.customerID = customerID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", customer=" + customer +
                ", type=" + type +
                ", contact='" + contact + '\'' +
                '}';
    }
}
