package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "CarEntity.deleteAllRows", query = "DELETE from CarEntity")
public class CarEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String make;
    private String model;
    private int price;

    public CarEntity() {
    }

    public CarEntity(int year, String make, String model, int price) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
