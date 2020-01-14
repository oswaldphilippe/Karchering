package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.data.DataLoader;
import ch.heg.ig.sda.data.ElectricCarDataLoader;
import ch.heg.ig.sda.data.ParkingDataLoader;
import ch.heg.ig.sda.data.PetrolCarDataLoader;

public class Main {

    private Park park;

    public Main() {
        park = new Park();
    }

    private void run() {
        evaluateParkingLoadingTime();
        evaluateVehiclesLoadingTime();
    }

    public static void main(String[] args) { new Main().run(); }


    private void evaluateParkingLoadingTime() {
        System.out.println("Chargement des parkings...");
        long startTime = System.currentTimeMillis();
        int nbParkings = loadParkings();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de chargement des " + nbParkings + " parkings : " + elapsedTime + "ms");
    }

    private void evaluateVehiclesLoadingTime() {
        System.out.println("Chargement des véhicules...");
        long startTime = System.currentTimeMillis();
        int nbVehicles = loadVehicles();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Temps de chargement des " + nbVehicles + " véhicules : " + elapsedTime + "ms");
    }

    private int loadParkings() {
        DataLoader dl = new ParkingDataLoader(this.park);
        return dl.loadFromCsv("./resources/400_parkings.csv");
    }

    private int loadVehicles() {
        DataLoader pDl = new PetrolCarDataLoader(this.park);
        DataLoader eDl = new ElectricCarDataLoader(this.park);
        int i = 0;
        i += pDl.loadFromCsv("./resources/1000_petrol_cars.csv");
        return i + eDl.loadFromCsv("./resources/1000_electric_cars.csv");
    }

}
