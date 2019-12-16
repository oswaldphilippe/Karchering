package ch.heg.ig.sda.business;

import ch.heg.ig.sda.business.Parking;

public abstract class Vehicle {

    private Parking parking;
    private int id;
    private String registrationPlate;
    private String model;
    private int personCapacity;
    private String brand;

    public Vehicle(int id, String registrationPlate, String model, int personCapacity, String brand) {
        this.id = id;
        this.registrationPlate = registrationPlate;
        this.model = model;
        this.personCapacity = personCapacity;
        this.brand = brand;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}