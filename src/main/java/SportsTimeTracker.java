import java.util.ArrayList;
import java.util.List;

public class SportsTimeTracker {
    // A list to store all the logged activities
    private final List<Activity> activities;

    // Constructor to initialize the activities list
    public SportsTimeTracker() {
        this.activities = new ArrayList<>();
    }

    // Nested static class to represent an individual activity
    private static class Activity {
        String description; // Description of the activity
        int duration;       // Duration of the activity in minutes

        // Constructor to initialize the activity
        public Activity(String description, int duration) {
            this.description = description;
            this.duration = duration;
        }

        // Overriding toString method to display activity information
        @Override
        public String toString() {
            return description + " - " + duration + " minutes";
        }
    }

    // Method to log a new activity
    public void logActivity(String description, int duration) {
        activities.add(new Activity(description, duration)); // Add new activity to the list
    }

    // Method to get the last logged activity
    public String getLastActivity() {
        if (!activities.isEmpty()) {
            return activities.get(activities.size() - 1).toString();
        }
        return ""; // Return an empty string if no activities are logged
    }

    // Method to get the number of logged activities
    public int getNumberOfActivities() {
        return activities.size();
    }

    // Method to display all logged activities
    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
            return;
        }
        System.out.println("Logged Activities:");
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    // Method to calculate and display the total time spent on all activities
    public void calculateTotalTime() {
        int total = activities.stream().mapToInt(a -> a.duration).sum(); // Calculate total duration
        System.out.println("Total time spent on sports this week: " + total + " minutes");
    }
}