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

    @Test(expected = IllegalArgumentException.class)
    public void ParkRemoveVehicleFalseWhenNotRemoved() {
        // Given
        Park p = new Park();

        // When
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);

        // Then
        p.removeVehicle(v);
    }

    @Test
    public void ParkRemoveVehicleRemovesVehicleFromItsParking() {
        // Given
        Park park = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        park.addVehicle(v);
        park.addParking(parking);
        park.addVehicleToParking(v, parking);

        // When
        boolean isRemoved = park.removeVehicle(v);

        // Then
        assertTrue(isRemoved);
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

    @Test(expected = IllegalArgumentException.class)
    public void ParkRemoveParkingExceptionWhenNotRemoved() {
        // Given
        Park park = new Park();

        // When
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);

        // Then
        park.removeParking(parking);
    }

    @Test
    public void ParkAddParkingToVehicleParkingHasVehicle() {
        // Given
        Park park = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        park.addVehicle(v);
        park.addParking(parking);

        // When
        park.addVehicleToParking(v, parking);

        // Then
        assertTrue(parking.containsVehicle(v));
    }

    @Test
    public void ParkAddParkingToVehicleVehicleHasParking() {
        // Given
        Park park = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        park.addVehicle(v);
        park.addParking(parking);

        // When
        park.addVehicleToParking(v, parking);

        // Then
        assertEquals(v.getParking(), parking);
    }

    @Test
    public void ParkRemoveVehicleFromParkingParkingRemovedFromVehicle() {
        // Given
        Park park = new Park();
        Vehicle v = new PetrolCar(5, "NE12345", "Golf 2", 5, "Volkswagen", 60);
        Parking parking = new Parking(1, "Neuchâtel, Rue de la Gare", "2000", 46.95, 6.85, 5);
        park.addVehicle(v);
        park.addParking(parking);
        park.addVehicleToParking(v, parking);

        // When
        park.removeVehicleFromParking(v, parking);

        // Then
        assertNull(v.getParking());
    }
}