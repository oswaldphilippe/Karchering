package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.*;

import java.io.*;

public class Main {

    private Park park;

    public Main() {
        park = new Park();
    }

    private void run() {
        loadParkings();
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

    private void loadParkings() {
        String csvFile = "./resources/400parkings.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));

            int i = 0;
            while ( (line = br.readLine()) != null ) {

                if (i > 0) {
                    String[] splittedLine = line.split(cvsSplitBy);
                    Parking parking = new Parking(
                            Integer.parseInt(splittedLine[0]),
                            splittedLine[1],
                            splittedLine[2],
                            Double.parseDouble(splittedLine[3]),
                            Double.parseDouble(splittedLine[4]),
                            Integer.parseInt(splittedLine[5])
                    );
                    this.park.addParking(parking);
                }

                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
