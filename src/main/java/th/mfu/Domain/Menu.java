package th.mfu.Domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.ResultSet;
@Entity
public class Menu {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int price;
    private String name;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "barista_id")
    private Barista barista;



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Barista getBarista() {
        return barista;
    }
    public void setBarista(Barista barista) {
        this.barista = barista;
    }
    
}


