import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SportsTimeTrackerTest {
    private SportsTimeTracker logger; // Instance of SportsActivityLogger for testing
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // Stream to capture console output

    // Set up method to initialize the logger and redirect system output for testing
    @BeforeEach
    public void setUp() {
        logger = new SportsTimeTracker(); // Create a new instance of SportsActivityLogger before each test
        System.setOut(new PrintStream(outContent));  // Redirect system output to the output stream for capturing printed output during tests
    }

    // Test method for logging an activity
    @Test
    public void testLogActivity() {
        logger.logActivity("Running", 30); // Log a sample activity "Running" with a duration of 30 minutes
        assertEquals(1, logger.getNumberOfActivities(), "There should be one activity logged."); // Check if the number of activities is 1
        assertEquals("Running - 30 minutes", logger.getLastActivity(), "The activity description should match."); // Verify the last logged activity details
    }

    // Test method for viewing logged activities
    @Test
    public void testViewActivities() {
        logger.logActivity("Swimming", 45); // Log a sample activity "Swimming" with a duration of 45 minutes
        logger.viewActivities(); // Invoke the method to view activities

        // Capture and normalize the output for cross-platform consistency
        String actualOutput = normalizeLineEndings(outContent.toString());
        String expectedOutput = normalizeLineEndings("Logged Activities:\nSwimming - 45 minutes");

        // Assert that the actual output matches the expected output
        assertEquals(expectedOutput, actualOutput, "The view output should match the logged activities.");
    }

    // Test method for calculating the total time spent on activities
    @Test
    public void testCalculateTotalTime() {
        logger.logActivity("Cycling", 60); // Log a sample activity "Cycling" with a duration of 60 minutes
        logger.logActivity("Walking", 30); // Log another activity "Walking" with a duration of 30 minutes
        logger.calculateTotalTime(); // Invoke the method to calculate total time

        // Check if the output contains the expected total time message
        String expectedMessage = "Total time spent on sports this week: 90 minutes";
        assertTrue(normalizeLineEndings(outContent.toString()).contains(expectedMessage), "The total time should be calculated as 90 minutes.");
    }

    // Helper method to normalize line endings for cross-platform consistency
    private String normalizeLineEndings(String input) {
        return input.replace("\r\n", "\n").trim();
    }
}