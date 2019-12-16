package ch.heg.ig.sda.business;

import ch.heg.ig.sda.business.Vehicle;

public class PetrolCar extends Vehicle {

    private float tankCapacity;

    public PetrolCar(int id, String registrationPlate, String model, int personCapacity, String brand, float tankCapacity) {
        super(id, registrationPlate, model, personCapacity, brand);
        this.tankCapacity = tankCapacity;
    }
}