package th.mfu.Domain;

import java.util.*; 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToOne
    // @JoinColumn(name = "customer_id")
    // private Customer owner; // Customer only

    // @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    // private List<Menu> data;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // public Customer getOwner() {
    //     return owner;
    // }
    // public void setOwner(Customer owner) {
    //     this.owner = owner;
    // }
    // public List<Menu> getData() {
    //     return data;
    // }
    // public void setData(List<Menu> data) {
    //     this.data = data;
    // }
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }
}
