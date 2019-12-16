package ch.heg.ig.sda.business;

import ch.heg.ig.sda.business.Parking;

public abstract class Vehicle {

    private Parking parking;
    private int id;
    private String registrationPlate;
    private String model;
    private int personCapacity;
    private String brand;

    public Vehicle() {
        // TODO - implement Vehicle.Vehicle
        throw new UnsupportedOperationException();
    }

}