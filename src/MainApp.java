public class MainApp {

    public static void main(String[] args) {
        // Create an instance of Prescription and add a prescription
        Prescription presc = new Prescription();

        // Update the last name to have at least 4 characters
        boolean isPrescAdded = presc.addPrescription(
                "John", "Doeh", "123 Example Street, Suburb, Country, 12345",
                -1.50f, -2.25f, 90, "23/10/24", "Dr. Anderson");

        if (isPrescAdded) {
            System.out.println("Prescription added successfully!");
        } else {
            System.out.println("Failed to add prescription.");
        }

        // Create an instance of Remark and add two remarks
        Remark remark = new Remark();

        // First remark with at least 6 words
        boolean isRemarkAdded1 = remark.addRemark(
                "Patient shows significant improvement in their overall condition.", "optometrist");
        if (isRemarkAdded1) {
            System.out.println("First remark added successfully!");
        } else {
            System.out.println("Failed to add first remark.");
        }

        // Second remark with at least 6 words
        boolean isRemarkAdded2 = remark.addRemark(
                "Client reports vision has improved significantly since the last visit.", "client");
        if (isRemarkAdded2) {
            System.out.println("Second remark added successfully!");
        } else {
            System.out.println("Failed to add second remark.");
        }

        // Attempt to add a third remark, which should fail due to the 2-remark limit
        boolean isRemarkAdded3 = remark.addRemark(
                "Trying to add a third remark to see if it fails.", "client");
        if (!isRemarkAdded3) {
            System.out.println("Failed to add third remark as expected (maximum 2 remarks allowed).");
        }
    }
}
