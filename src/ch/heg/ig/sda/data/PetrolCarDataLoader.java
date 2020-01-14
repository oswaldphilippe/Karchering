package ch.heg.ig.sda.data;

import ch.heg.ig.sda.business.Park;
import ch.heg.ig.sda.business.Parking;
import ch.heg.ig.sda.business.PetrolCar;
import ch.heg.ig.sda.business.Vehicle;

public class PetrolCarDataLoader extends DataLoader {

    public PetrolCarDataLoader(Park p) {
        super(p);
    }

    @Override
    protected void doCsvParse(String[] splittedLine) {


        Vehicle v = new PetrolCar(
                Integer.parseInt(splittedLine[0]),
                splittedLine[1],
                splittedLine[2],
                Integer.parseInt(splittedLine[3]),
                splittedLine[4],
                Float.parseFloat(splittedLine[5])
        );
        this.p.addVehicle(v);
    }
}
