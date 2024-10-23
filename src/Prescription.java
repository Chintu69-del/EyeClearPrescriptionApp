import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {

    // Attributes of a prescription
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int axis;
    private String examDate;
    private String optometrist;

    // Constructor for Prescription
    public Prescription() {
        // Empty constructor
    }

    // Method to add a prescription
    public boolean addPrescription(String firstName, String lastName, String address,
                                   float sphere, float cylinder, int axis,
                                   String examDate, String optometrist) {
        // Debug statements for input validation
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Sphere: " + sphere);
        System.out.println("Cylinder: " + cylinder);
        System.out.println("Axis: " + axis);
        System.out.println("Exam Date: " + examDate);
        System.out.println("Optometrist: " + optometrist);

        // Validate all conditions
        if (!isValidName(firstName) || !isValidName(lastName)) {
            System.out.println("Invalid first name or last name.");
            return false;
        }

        if (!isValidAddress(address)) {
            System.out.println("Invalid address.");
            return false;
        }

        if (!isValidSphere(sphere) || !isValidCylinder(cylinder) || !isValidAxis(axis)) {
            System.out.println("Invalid sphere, cylinder, or axis values.");
            return false;
        }

        if (!isValidExamDate(examDate)) {
            System.out.println("Invalid exam date.");
            return false;
        }

        if (!isValidOptometrist(optometrist)) {
            System.out.println("Invalid optometrist name.");
            return false;
        }

        // If all validations pass, write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/presc.txt", true))) {
            writer.write(firstName + " " + lastName + ", " + address + ", Sphere: " + sphere +
                    ", Cylinder: " + cylinder + ", Axis: " + axis + ", Exam Date: " + examDate +
                    ", Optometrist: " + optometrist);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("Prescription added successfully.");
        return true;
    }

    // Validation methods
    private boolean isValidName(String name) {
        System.out.println("Validating name: " + name + " (Length: " + name.length() + ")");
        return name != null && name.length() >= 4 && name.length() <= 15;
    }

    private boolean isValidAddress(String address) {
        System.out.println("Validating address: " + address + " (Length: " + address.length() + ")");
        return address != null && address.length() >= 20;
    }

    private boolean isValidSphere(float sphere) {
        System.out.println("Validating sphere: " + sphere);
        return sphere >= -20.00 && sphere <= 20.00;
    }

    private boolean isValidCylinder(float cylinder) {
        System.out.println("Validating cylinder: " + cylinder);
        return cylinder >= -4.00 && cylinder <= 4.00;
    }

    private boolean isValidAxis(int axis) {
        System.out.println("Validating axis: " + axis);
        return axis >= 0 && axis <= 180;
    }

    private boolean isValidExamDate(String date) {
        System.out.println("Validating exam date: " + date);
        // Assuming the date is provided in DD/MM/YY format
        return date.matches("\\d{2}/\\d{2}/\\d{2}");
    }

    private boolean isValidOptometrist(String optometrist) {
        System.out.println("Validating optometrist name: " + optometrist + " (Length: " + optometrist.length() + ")");
        return optometrist != null && optometrist.length() >= 8 && optometrist.length() <= 25;
    }
}
