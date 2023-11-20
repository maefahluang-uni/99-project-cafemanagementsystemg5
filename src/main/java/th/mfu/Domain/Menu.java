package th.mfu.Domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.ResultSet;
@Entity
public class Menu {
    @Id
    private String name;
    private int price;

    // @ManyToOne
    // @JoinColumn(name = "cart_id")
    // private Cart cart;

    // public Cart getCart() {
    //     return cart;
    // }
    // public void setCart(Cart cart) {
    //     this.cart = cart;
    // }
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
}


