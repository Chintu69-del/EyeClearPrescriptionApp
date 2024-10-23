import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemarkTest {

    @Test
    public void testValidRemark() {
        Remark remark = new Remark();
        boolean result = remark.addRemark("Patient shows significant improvement.", "optometrist");
        assertTrue(result, "Valid remark should return true");
    }

    @Test
    public void testInvalidRemarkTooFewWords() {
        Remark remark = new Remark();
        boolean result = remark.addRemark("Improvement noticed.", "optometrist");
        assertFalse(result, "Remark with fewer than 6 words should return false");
    }

    @Test
    public void testInvalidRemarkTooManyWords() {
        Remark remark = new Remark();
        boolean result = remark.addRemark("This is a really long remark that contains far more than twenty words " +
                "which is not allowed according to the specifications of this task.", "client");
        assertFalse(result, "Remark with more than 20 words should return false");
    }

    @Test
    public void testInvalidRemarkNoCapitalLetter() {
        Remark remark = new Remark();
        boolean result = remark.addRemark("patient shows significant improvement.", "optometrist");
        assertFalse(result, "Remark that doesn't start with a capital letter should return false");
    }

    @Test
    public void testInvalidCategory() {
        Remark remark = new Remark();
        boolean result = remark.addRemark("Patient shows significant improvement.", "doctor");
        assertFalse(result, "Invalid category should return false (category should be 'client' or 'optometrist')");
    }

    @Test
    public void testValidSecondRemark() {
        Remark remark = new Remark();
        remark.addRemark("Patient shows significant improvement.", "optometrist");
        boolean result = remark.addRemark("Client reports vision has improved.", "client");
        assertTrue(result, "A second valid remark should return true");
    }

    @Test
    public void testThirdRemarkExceedsLimit() {
        Remark remark = new Remark();
        remark.addRemark("Patient shows significant improvement.", "optometrist");
        remark.addRemark("Client reports vision has improved.", "client");
        boolean result = remark.addRemark("Trying to add a third remark.", "client");
        assertFalse(result, "Adding a third remark should return false (maximum 2 remarks allowed)");
    }
}
