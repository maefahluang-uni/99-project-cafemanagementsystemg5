package th.mfu.Domain;

import java.sql.ResultSet;
public class Menu {
   private String name;
   private int value;
    private Barista barista;
    private Admin admin;
    private Customer customer;


public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getValue() {
    return value;
}
public void setValue(int value) {
    this.value = value;
}
public Barista getBarista() {
    return barista;
}
public void setBarista(Barista barista) {
    this.barista = barista;
}
public Admin getAdmin() {
    return admin;
}
public void setAdmin(Admin admin) {
    this.admin = admin;
}
public Customer getCustomer() {
    return customer;
}
public void setCustomer(Customer customer) {
    this.customer = customer;
}
 



}


