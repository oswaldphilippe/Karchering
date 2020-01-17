package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.data.DataLoader;
import ch.heg.ig.sda.data.ElectricCarDataLoader;
import ch.heg.ig.sda.data.ParkingDataLoader;
import ch.heg.ig.sda.data.PetrolCarDataLoader;

import java.util.List;

public class Main {

    private Park park;

    public Main() {
        park = new Park();
    }

    private void run() {
        evaluateParkingLoadingTime();
        evaluateVehiclesLoadingTime();
        evaluateGetParkingsTime();
        evaluateGetVehiclesTime();
        evaluateAddParkingTime();
        evaluateAddVehicleToParkingTime();
        evaluateMoveVehicleTime();
        evaluateDeleteVehicleTime();
    }

    public static void main(String[] args) { new Main().run(); }


    private void evaluateParkingLoadingTime() {
        long startTime = System.currentTimeMillis();
        int nbParkings = loadParkings();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de chargement des " + nbParkings + " parkings : " + elapsedTime + "ms");
    }

    private void evaluateVehiclesLoadingTime() {
        long startTime = System.currentTimeMillis();
        int nbVehicles = loadVehicles();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de chargement des " + nbVehicles + " véhicules : " + elapsedTime + "ms");
    }

    private void evaluateGetParkingsTime() {
        long startTime = System.currentTimeMillis();
        park.getParkings();
        long endTime = System.currentTimeMillis();
        int nbParkings = park.getParkings().size();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps d'obtention des " + nbParkings + " parkings : " + elapsedTime + "ms");
    }

    private void evaluateGetVehiclesTime() {
        long startTime = System.currentTimeMillis();
        park.getVehicles();
        long endTime = System.currentTimeMillis();
        int nbVehicles = park.getVehicles().size();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps d'obtention des " + nbVehicles + " véhicules : " + elapsedTime + "ms");
    }

    private void evaluateAddParkingTime() {
        Parking p = new Parking(401,"rue de la colline 3","2202",234.5,295.4,20);
        long startTime = System.currentTimeMillis();
        park.addParking(p);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps d'ajout d'un parking : " + elapsedTime + "ms");
    }

    private void evaluateAddVehicleToParkingTime() {
        Parking p = park.getParkings().get(12);
        Vehicle v = new PetrolCar(2001,"NE1369","Duster",5,"Dacia",80);
        this.park.addVehicle(v);
        long startTime = System.currentTimeMillis();
        park.addVehicleToParking(v, p);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps d'ajout d'un véhicule dans un parking : " + elapsedTime + "ms");
    }

    private void evaluateMoveVehicleTime() {
        Parking p1 = park.getParkings().get(0);
        Parking p2 = park.getParkings().get(300);
        Vehicle v = new PetrolCar(2002,"NE1369","Duster",5,"Dacia",80);
        this.park.addVehicle(v);
        park.addVehicleToParking(v, p1);

        long startTime = System.currentTimeMillis();
        park.moveVehicle(v, p2);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de déplacement d'un véhicule dans un nouveau parking : " + elapsedTime + "ms");
    }

    private void evaluateDeleteVehicleTime() {
        Parking p = park.getParkings().get(200);
        Vehicle v = park.getVehicles().get(1000);
        park.addVehicleToParking(v, p);

        long startTime = System.currentTimeMillis();
        park.removeVehicle(v);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de suppression d'un véhicule du parc : " + elapsedTime + "ms");
    }

    private int loadParkings() {
        DataLoader dl = new ParkingDataLoader(this.park);
        return dl.loadFromCsv("./resources/400_parkings.csv");
    }

    private int loadVehicles() {
        DataLoader pDl = new PetrolCarDataLoader(this.park);
        DataLoader eDl = new ElectricCarDataLoader(this.park);
        int i = pDl.loadFromCsv("./resources/1000_petrol_cars.csv");
        return i + eDl.loadFromCsv("./resources/1000_electric_cars.csv");
    }

}
