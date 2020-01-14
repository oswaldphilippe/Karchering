package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.*;

import java.io.*;

public class Main {

    private Park park;

    public Main() {
        park = new Park();
    }

    private void run() {
        evaluateParkingLoadingTime();
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

    }

    private int loadParkings() {
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
            System.out.println("Added " + (i - 1) + " parkings to park");
            return i-1;
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
        return 0;
    }

    private void loadVehicles() {

    }
}
