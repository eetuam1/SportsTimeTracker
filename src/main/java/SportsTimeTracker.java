import java.util.ArrayList;
import java.util.List;

public class SportsTimeTracker {
    private final List<Activity> activities;

    public SportsTimeTracker() {
        this.activities = new ArrayList<>();
    }

    private static class Activity {
        String description;
        int duration;

        public Activity(String description, int duration) {
            this.description = description;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return description + " - " + duration + " minutes";
        }
    }

    public void logActivity(String description, int duration) {
        activities.add(new Activity(description, duration));
    }

    public String getLastActivity() {
        if (!activities.isEmpty()) {
            return activities.get(activities.size() - 1).toString();
        }
        return "";
    }

    public int getNumberOfActivities() {
        return activities.size();
    }

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

    public void calculateTotalTime() {
        int total = activities.stream().mapToInt(a -> a.duration).sum();
        System.out.println("Total time spent on sports this week: " + total + " minutes");
    }
}