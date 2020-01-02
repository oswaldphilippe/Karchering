package ch.heg.ig.sda.tests;

import ch.heg.ig.sda.business.Park;
import ch.heg.ig.sda.business.Parking;
import ch.heg.ig.sda.business.PetrolCar;
import ch.heg.ig.sda.business.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkTest {

    @Test
    public void ParkAddVehicleTrueWhenNotAlreadyAdded() {
        // Given
        Park p = new Park();

        // When
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        boolean isAdded = p.addVehicle(v);

        // Then
        assertTrue(isAdded);
    }

    @Test
    public void ParkAddVehicleFalseWhenAlreadyAdded() {
        // Given
        Park p = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        boolean isAddedFirstTime = p.addVehicle(v);

        // When
        boolean isAddedSecondTime = p.addVehicle(v);

        // Then
        assertFalse(isAddedSecondTime);
    }

    @Test
    public void ParkAddParkingTrueWhenNotAlreadyAdded() {
        // Given
        Park park = new Park();

        // When
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        boolean isAdded = park.addParking(parking);

        // Then
        assertTrue(isAdded);
    }

    @Test
    public void ParkAddParkingFalseWhenAlreadyAdded() {
        // Given
        Park park = new Park();
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        boolean isAddedFirstTime = park.addParking(parking);

        // When
        boolean isAddedSecondTime = park.addParking(parking);

        // Then
        assertFalse(isAddedSecondTime);
    }

    @Test
    public void ParkRemoveVehicleTrueWhenRemoved() {
        // Given
        Park p = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        p.addVehicle(v);

        // When
        boolean isRemoved = p.removeVehicle(v);

        // Then
        assertTrue(isRemoved);
    }

    @Test
    public void ParkRemoveVehicleFalseWhenNotRemoved() {
        // Given
        Park p = new Park();

        // When
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        boolean isRemoved = p.removeVehicle(v);

        // Then
        assertFalse(isRemoved);
    }

    @Test
    public void ParkRemoveParkingTrueWhenRemoved() {
        // Given
        Park park = new Park();
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        park.addParking(parking);

        // When
        boolean isRemoved = park.removeParking(parking);

        // Then
        assertTrue(isRemoved);
    }

    @Test
    public void ParkRemoveParkingFalseWhenNotRemoved() {
        // Given
        Park park = new Park();

        // When
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        boolean isRemoved = park.removeParking(parking);

        // Then
        assertFalse(isRemoved);
    }
}