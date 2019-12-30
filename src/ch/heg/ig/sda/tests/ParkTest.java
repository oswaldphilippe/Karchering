package ch.heg.ig.sda.tests;

import ch.heg.ig.sda.business.Park;
import ch.heg.ig.sda.business.PetrolCar;
import ch.heg.ig.sda.business.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkTest {

    @Test
    public void ParkAddVehicle() {
        // Given
        Park p = new Park();

        // When
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        boolean isAdded = p.addVehicle(v);

        // Then
        assertTrue(isAdded);
    }
}