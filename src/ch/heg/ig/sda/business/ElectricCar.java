package ch.heg.ig.sda.business;

import ch.heg.ig.sda.business.Vehicle;

public class ElectricCar extends Vehicle {

    private float batteryLife;

    public ElectricCar(int id, String registrationPlate, String model, int personCapacity, String brand, float batteryLife) {
        super(id, registrationPlate, model, personCapacity, brand);
        this.batteryLife = batteryLife;
    }
}