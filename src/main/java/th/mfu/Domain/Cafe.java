package th.mfu.Domain;

import java.lang.annotation.Inherited;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Menu;
    private Date date;
    private int price;
    private int ID;
    public String getMenu() {
        return Menu;
    }
    public void setMenu(String menu) {
        Menu = menu;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }

    
}
