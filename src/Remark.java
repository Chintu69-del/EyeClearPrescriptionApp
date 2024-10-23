import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Remark {

    // Attributes for the Remark class
    private int remarkCount;  // To keep track of the number of remarks
    private static final int MAX_REMARKS = 2;  // Maximum of 2 remarks allowed

    // Constructor
    public Remark() {
        this.remarkCount = 0;
    }

    // Method to add a remark
    public boolean addRemark(String remark, String category) {
        // Debug statements for input validation
        System.out.println("Adding Remark: " + remark);
        System.out.println("Category: " + category);

        // Validate the remark and category
        if (!isValidRemark(remark)) {
            System.out.println("Invalid remark format.");
            return false;
        }

        if (!isValidCategory(category)) {
            System.out.println("Invalid category.");
            return false;
        }

        if (remarkCount >= MAX_REMARKS) {
            System.out.println("Cannot add more than 2 remarks.");
            return false;
        }

        // If all validations pass, write the remark to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/review.txt", true))) {
            writer.write("Remark: " + remark + ", Category: " + category);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Increment the remark count
        remarkCount++;
        System.out.println("Remark added successfully.");
        return true;
    }

    // Validation methods
    private boolean isValidRemark(String remark) {
        if (remark == null) {
            return false;
        }

        // Split the remark into words and check word count
        String[] words = remark.split("\\s+");
        System.out.println("Remark contains " + words.length + " words.");
        System.out.println("First word starts with: " + words[0].charAt(0));

        if (words.length < 6 || words.length > 20) {
            return false;
        }

        // Check if the first character of the first word is uppercase
        return Character.isUpperCase(words[0].charAt(0));
    }

    private boolean isValidCategory(String category) {
        // The category must be either "client" or "optometrist"
        System.out.println("Validating category: " + category);
        return "client".equals(category) || "optometrist".equals(category);
    }
}
