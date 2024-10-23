import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrescriptionTest {

    @Test
    public void testValidPrescription() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/24", "Dr. Anderson");
        assertTrue(result, "Valid prescription should return true");
    }

    @Test
    public void testInvalidFirstName() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "J", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/24", "Dr. Anderson");
        assertFalse(result, "First name with less than 4 characters should return false");
    }

    @Test
    public void testInvalidLastName() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "D", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/24", "Dr. Anderson");
        assertFalse(result, "Last name with less than 4 characters should return false");
    }

    @Test
    public void testInvalidAddress() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "Short Address", -1.50f, -2.25f, 90,
                "23/10/24", "Dr. Anderson");
        assertFalse(result, "Address with less than 20 characters should return false");
    }

    @Test
    public void testInvalidSphere() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -21.00f, -2.25f, 90, "23/10/24", "Dr. Anderson");
        assertFalse(result, "Sphere outside the range of -20.00 to 20.00 should return false");
    }

    @Test
    public void testInvalidCylinder() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -5.00f, 90, "23/10/24", "Dr. Anderson");
        assertFalse(result, "Cylinder outside the range of -4.00 to 4.00 should return false");
    }

    @Test
    public void testInvalidAxis() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 200, "23/10/24", "Dr. Anderson");
        assertFalse(result, "Axis outside the range of 0 to 180 should return false");
    }

    @Test
    public void testInvalidExamDate() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/2024", "Dr. Anderson");
        assertFalse(result, "Invalid date format (not DD/MM/YY) should return false");
    }

    @Test
    public void testInvalidOptometristName() {
        Prescription presc = new Prescription();
        boolean result = presc.addPrescription(
                "John", "Doe", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/24", "Dr. A");
        assertFalse(result, "Optometrist name with less than 8 characters should return false");
    }
}
