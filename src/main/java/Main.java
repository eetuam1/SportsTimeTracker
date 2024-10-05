import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportsTimeTracker logger = new SportsTimeTracker (); // Create an instance of the logger
        boolean running = true; // Control variable for the loop

        // Main application loop
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Log an activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent on activities");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Handle user's choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter activity description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter activity duration (in minutes): ");
                        try {
                            int duration = scanner.nextInt();
                            logger.logActivity(description, duration); // Log the new activity
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid duration in minutes.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                        break;
                    case 2:
                        logger.viewActivities(); // Display all logged activities
                        break;
                    case 3:
                        logger.calculateTotalTime(); // Calculate and display total time
                        break;
                    case 4:
                        running = false; // Exit the loop
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close(); // Close the scanner resource
    }
}