package th.mfu.domain;

import java.lang.annotation.Inherited;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CafeManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Menu;
    private Date date;
    private int price;
    private int ID;
}
