package th.mfu.Domain;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.ResultSet;
@Entity
public class Menu {
    @Id
   private String name;
   private int value;


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



}


