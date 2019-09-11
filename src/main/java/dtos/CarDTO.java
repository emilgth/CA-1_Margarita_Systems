package dtos;

import entities.CarEntity;

public class CarDTO {

    private int year;
    private String make;
    private String model;
    private int price;

    public CarDTO(CarEntity carEntity) {
        this.year = carEntity.getYear();
        this.make = carEntity.getMake();
        this.model = carEntity.getModel();
        this.price = carEntity.getPrice();
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
