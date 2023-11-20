package th.mfu.Domain;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    // private Cart cart;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // public Cart getCart() {
    //     return cart;
    // }
    // public void setCart(Cart cart) {
    //     this.cart = cart;
    // }
}
