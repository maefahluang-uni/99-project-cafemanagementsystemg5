package th.mfu.Domain;


import java.util.*;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ADMIN")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;
    @Column(name="Date")
    private Date date;
    @Column(name="Value")
    private int value;

    @OneToMany(mappedBy = "admin")
    private List<Stock> stocks;
     @OneToOne(mappedBy = "admin")
    private DailySale dailySale;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", date=" + date + ", value=" + value + "]";
    }
    public List<Stock> getStocks() {
        return stocks;
    }
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    public DailySale getDailySale() {
        return dailySale;
    }
    public void setDailySale(DailySale dailySale) {
        this.dailySale = dailySale;
    }

    
    
    
    
}
