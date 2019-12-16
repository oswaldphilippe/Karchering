package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.ElectricCar;
import ch.heg.ig.sda.business.Park;
import ch.heg.ig.sda.business.PetrolCar;
import ch.heg.ig.sda.business.Vehicle;

public class Main {

    private Park park;

    public Main() {
        park = new Park();
    }

    public void run() {
        createVehicles();
    }

    public static void main(String[] args) { new Main().run(); }

    private void createVehicles() {
        Vehicle car1 = new ElectricCar(1, "NE12341", "Tesla 2", 5, "Tesla", 900);
        Vehicle car2 = new ElectricCar(2, "NE12342", "Tesla 3", 5, "Tesla", 1000);
        Vehicle car3 = new ElectricCar(3, "NE12343", "Tesla 2", 5, "Tesla", 900);
        Vehicle car4 = new ElectricCar(4, "NE12344", "Tesla 2", 5, "Tesla", 900);

        Vehicle car5 = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        Vehicle car6 = new PetrolCar(6, "NE12346", "Polo", 5, "Volkswagen", 60);
        Vehicle car7 = new PetrolCar(7, "NE12347", "TT", 5, "Audi", 60);
        Vehicle car8 = new PetrolCar(8, "NE12348", "Golf 2", 5, "Volkswagen", 60);

        park.addVehicle(car1);
        park.addVehicle(car2);
        park.addVehicle(car3);
        park.addVehicle(car4);
        park.addVehicle(car5);
        park.addVehicle(car6);
        park.addVehicle(car7);
        park.addVehicle(car8);
    }
}
