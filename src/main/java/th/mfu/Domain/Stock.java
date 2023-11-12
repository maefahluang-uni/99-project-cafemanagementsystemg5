package th.mfu.Domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="TBL_STOCK")
    
public class Stock {
    @Column(name="Name")
    private String name;
    @Column(name="Value")
    private int  value;
    @Column(name="Date")
    private Date date;

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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    

}


