package ru.itis.main.models;

public class Auto {
    private int id;
    private String model;
    private String color;
    private int mileage;

    public Auto(String model, String color, int mileage) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString() {
        return this.id + " " +
                this.model + " " +
                this.color + " " +
                this.mileage;
    }
}
