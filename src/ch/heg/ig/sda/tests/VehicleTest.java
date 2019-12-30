package ch.heg.ig.sda.tests;

import ch.heg.ig.sda.business.ElectricCar;
import ch.heg.ig.sda.business.Parking;
import ch.heg.ig.sda.business.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void VehicleSetParkingIsEqualToGetParking() {
        // Given
        Vehicle v = new ElectricCar(1, "NE12341", "Tesla 2", 5, "Tesla", 900);
        Parking pSet = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        v.setParking(pSet);

        // When
        Parking pGet = v.getParking();

        // Then
        assertEquals(pSet, pGet);
    }

    @Test
    public void VehicleHasParkingWhenParkingIsSet() {
        // Given
        Vehicle v = new ElectricCar(1, "NE12341", "Tesla 2", 5, "Tesla", 900);
        Parking pSet = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        v.setParking(pSet);

        // When
        boolean actualHasParking = v.hasParking();

        // Then
        assertTrue(actualHasParking);
    }

    @Test
    public void VehicleHasParkingWhenNoParkingSet() {
        // Given
        Vehicle v = new ElectricCar(1, "NE12341", "Tesla 2", 5, "Tesla", 900);

        // When
        boolean actualHasParking = v.hasParking();

        // Then
        assertFalse(actualHasParking);
    }
}