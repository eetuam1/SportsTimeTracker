import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SportsTimeTrackerTest {
    private SportsTimeTracker tracker; // Changed from SportsTimeTrackerTest to SportsTimeTracker
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        tracker = new SportsTimeTracker(); // Initialize the tracker instance
        System.setOut(new PrintStream(outContent)); // Redirect system output to the output stream for testing
    }

    @Test
    public void testLogActivity() {
        tracker.logActivity("Running", 30); // Call logActivity on tracker
        assertEquals(1, tracker.getNumberOfActivities(), "There should be one activity logged."); // Call getNumberOfActivities on tracker
        assertEquals("Running - 30 minutes", tracker.getLastActivity(), "The activity description should match."); // Call getLastActivity on tracker
    }

    @Test
    public void testViewActivities() {
        tracker.logActivity("Swimming", 45); // Call logActivity on tracker
        tracker.viewActivities(); // Call viewActivities on tracker

        String actualOutput = normalizeLineEndings(outContent.toString());
        String expectedOutput = normalizeLineEndings("Logged Activities:\nSwimming - 45 minutes");
        assertEquals(expectedOutput, actualOutput, "The view output should match the logged activities.");
    }

    @Test
    public void testCalculateTotalTime() {
        tracker.logActivity("Cycling", 60); // Call logActivity on tracker
        tracker.logActivity("Walking", 30); // Call logActivity on tracker
        tracker.calculateTotalTime(); // Call calculateTotalTime on tracker

        String expectedMessage = "Total time spent on sports this week: 90 minutes";
        assertTrue(normalizeLineEndings(outContent.toString()).contains(expectedMessage), "The total time should be calculated as 90 minutes.");
    }

    private String normalizeLineEndings(String input) {
        return input.replace("\r\n", "\n").trim();
    }
}
