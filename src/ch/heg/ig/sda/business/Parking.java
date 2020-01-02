package ch.heg.ig.sda.business;

import ch.heg.ig.sda.business.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class Parking {

    private Set<Vehicle> vehicles;
    private int id;
    private String address;
    private String zipCode;
    private double latitude;
    private double longitude;
    private int capacity;

    public Parking(int id, String address, String zipCode, double latitude, double longitude, int capacity) {
        this();
        this.id = id;
        this.address = address;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacity = capacity;
    }

    public Parking() {
        this.vehicles = new HashSet<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addVehicle(Vehicle vehicle) throws IllegalStateException{
        if(this.getFreeSpace() <= 0){
            throw new IllegalStateException("Plus de place dans le parking.");
        }
        return this.vehicles.add(vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return this.vehicles.remove(vehicle);
    }

    public boolean containsVehicle(Vehicle vehicle) {
        return this.vehicles.contains(vehicle);
    }

    public int getFreeSpace() {
        return this.capacity - this.vehicles.size();
    }

    public boolean isEmpty(){
        return this.vehicles.size() == 0;
    }

}