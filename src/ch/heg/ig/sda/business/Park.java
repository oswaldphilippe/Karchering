package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Park {
    private HashSet<Parking> parkings;
    private HashSet<Vehicle> vehicles;
    public Park(){

    }
    public List<Parking> parkingsToList(){
        List<Parking> listParkings = new ArrayList<Parking>(parkings);
        return listParkings;
    }
    public List<Vehicle> vehiclesToList(){
        List<Vehicle> listVehicles = new ArrayList<Vehicle>(vehicles);
        return listVehicles;
    }

    public boolean addVehicle(Vehicle v){
        return vehicles.add(v);
    }

    public boolean addParking(Parking p){
        return parkings.add(p);
    }

    public boolean addVehicleToParking(Vehicle v, Parking p){
        if(!v.getParking().equals(p) && vehicleExists(v) && parkingExists(p)){
            return p.addVehicle(v);
        }
        else{
            return false;
        }
    }
    
    public boolean removeVehicle(Vehicle v){
        if(v.hasParking()){
            v.getParking().removeVehicle(v);
        }
        return vehicles.remove(v);
    }
    
    public boolean removeParking(Parking p){
        if(!p.isEmpty()){
            return false;
        }
        return parkings.remove(p);
    }
    
    public boolean vehicleExists(Vehicle v){
        return vehicles.contains(v);
    }
    
    public boolean parkingExists(Parking p){
        return parkings.contains(p);
    }
}
