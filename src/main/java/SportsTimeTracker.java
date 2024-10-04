import java.util.HashMap;
import java.util.Map;

public class SportsTimeTracker {
    private Map<String, Integer> activities = new HashMap<>();

    public void logActivity(String activity, int hours) {
        activities.put(activity, activities.getOrDefault(activity, 0) + hours);
    }

    public void viewActivities() {
        activities.forEach((activity, hours) -> System.out.println(activity + ": " + hours + " hours"));
    }

    public int calculateTotalTime() {
        return activities.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        SportsTimeTracker tracker = new SportsTimeTracker();
        tracker.logActivity("Football", 2);
        tracker.logActivity("Basketball", 1);
        tracker.viewActivities();
        System.out.println("Total time spent: " + tracker.calculateTotalTime() + " hours");
    }
}
