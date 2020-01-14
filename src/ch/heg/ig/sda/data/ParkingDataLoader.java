package ch.heg.ig.sda.data;

import ch.heg.ig.sda.business.Park;
import ch.heg.ig.sda.business.Parking;
import ch.heg.ig.sda.business.PetrolCar;
import ch.heg.ig.sda.business.Vehicle;

public class ParkingDataLoader extends DataLoader {

    public ParkingDataLoader(Park p) {
        super(p);
    }

    @Override
    protected void doCsvParse(String[] splittedLine) {
        Parking p = new Parking(
                Integer.parseInt(splittedLine[0]),
                splittedLine[1],
                splittedLine[2],
                Double.parseDouble(splittedLine[3]),
                Double.parseDouble(splittedLine[4]),
                Integer.parseInt(splittedLine[5])
        );
        this.p.addParking(p);
    }
}
