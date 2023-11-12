package th.mfu.Domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

    @Entity
public class Stock {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int  value;
    private Date date;


    public Stock(Long id, String name, int value, Date date) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
    }
    
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    

}


