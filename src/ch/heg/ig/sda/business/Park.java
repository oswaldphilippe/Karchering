package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Park {
    private HashSet<Parking> parkings;
    private HashSet<Vehicle> vehicles;

    public Park() {
        parkings = new HashSet<>();
        vehicles = new HashSet<>();
    }

    public List<Parking> getParkings() {
        return new ArrayList<>(parkings);
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public boolean addVehicle(Vehicle v){
        return vehicles.add(v);
    }

    public boolean addParking(Parking p) {
        return parkings.add(p);
    }

    public boolean addVehicleToParking(Vehicle v, Parking p) {
        checkParkingExists(p);
        checkVehicleExists(v);

        if (!v.hasParking()) {
            if (p.addVehicle(v)) {
                v.setParking(p);
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicleFromParking(Vehicle v, Parking p) {
        checkParkingExists(p);
        checkVehicleExists(v);

        if (v.hasParking()) {
            if (p.removeVehicle(v)) {
                v.setParking(null);
                return true;
            }
        }
        return false;
    }

    public boolean moveVehicle(Vehicle v, Parking newParking) {
        checkParkingExists(newParking);
        checkVehicleExists(v);

        if (newParking.getFreeSpace() > 0) {
            // Remove vehicle from old parking
            if (v.hasParking()) {
                removeVehicleFromParking(v, v.getParking());
            }
            // Add to new parking
            return addVehicleToParking(v, newParking);
        }
        return false;
    }
    
    public boolean removeVehicle(Vehicle v) {
        checkVehicleExists(v);

        // Remove vehicle from its parking first
        if (v.hasParking()) {
            removeVehicleFromParking(v, v.getParking());
        }
        return vehicles.remove(v);
    }
    
    public boolean removeParking(Parking p) throws IllegalStateException {
        checkParkingExists(p);

        // Parking must be empty
        if (!p.isEmpty()) {
            throw new IllegalStateException("Le parking doit être vide");
        }
        return parkings.remove(p);
    }
    
    public void checkVehicleExists(Vehicle v) throws IllegalArgumentException {
        if (!vehicles.contains(v)) {
            throw new IllegalArgumentException("Le véhicule n'existe pas dans le parc");
        }
    }
    
    public void checkParkingExists(Parking p) throws IllegalArgumentException {
        if (!parkings.contains(p)) {
            throw new IllegalArgumentException("Le parking n'existe pas dans le parc");
        }
    }
}
