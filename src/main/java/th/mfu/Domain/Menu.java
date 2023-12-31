package th.mfu.Domain;
import javax.persistence.CascadeType;
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
    private Long Id;
    private Long price;
    private String name;

    @ManyToOne
    @JoinColumn(name = "barista_id")
    private Barista barista;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Barista getBarista() {
        return barista;
    }
    public void setBarista(Barista barista) {
        this.barista = barista;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}


