import java.util.Scanner;

public class App {

    private static WorkoutService workoutService = new WorkoutService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addWorkout();
                    break;
                case "2":
                    viewAllWorkouts();
                    break;
                case "3":
                    deleteWorkout();
                    break;
                case "4":
                    viewWorkoutsByTrainer();
                    break;
                case "0":
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Fitness Tracker Menu ---");
        System.out.println("1. Add Workout");
        System.out.println("2. View All Workouts");
        System.out.println("3. Delete Workout");
        System.out.println("4. View Workouts by Trainer");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addWorkout() {

    }

    private static void viewAllWorkouts() {

    }

    private static void deleteWorkout() {

    }

    private static void viewWorkoutsByTrainer() {
        
    }
}
