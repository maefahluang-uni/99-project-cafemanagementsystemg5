package th.mfu.Domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Barista {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ID")
    private Integer password;
    @Column(name="password")




    @OneToMany(mappedBy = "barista")
    private List<Customer> customers;
    public DailySale getDailySale() {
        return dailySale;
    }
    public void setDailySale(DailySale dailySale) {
        this.dailySale = dailySale;
    }
    @OneToOne(mappedBy = "barista")
    private DailySale dailySale;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }
    
    
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    
}
