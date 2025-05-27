import java.time.LocalDate;
import java.util.ArrayList;
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
                    addUser();
                    break;
                case "2":
                    addWorkout();
                    break;
                case "3":
                    viewAllWorkouts();
                    break;
                case "4":
                    deleteWorkout();
                    break;
                case "5":
                    updateGoal();
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
        System.out.println("1. Add User");
        System.out.println("2. Add Workout");
        System.out.println("3. View All Workouts");
        System.out.println("4. Delete Workout");
        System.out.println("5. Update a Goal");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addUser() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter desired username: ");
        String username = scanner.nextLine();

        User user = new User(name, username);
        // Come back and add a way to add to database
    }

    private static void addWorkout() {
        System.out.println("Enter date of workout: ");
        LocalDate date = scanner.nextLine();
        System.out.println("Enter workout type: ");
        String type = scanner.nextLine();
        System.out.println("Enter duration of workout: ");
        int duration = scanner.nextInt();
        System.out.println("Enter exercises completed: ");
        ArrayList<Exercise> exercises = scanner.nextLine();
    }

    private static void viewAllWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        if (workouts.isEmpty()) {
            System.out.println("No workouts found.");
        } else {
            for (Workout workout : workouts) {
                System.out.println("ID: " + workout.getWorkoutId()
                                + " Date: " + workout.getDate() 
                                + " Type: " + workout.getType()
                                + " Duration (In Minutes): " + workout.getDuration()
                                + " Exercises: " + workout.getExercises());
            }
        }
    }

    private static void deleteWorkout() {

    }

    private static void updateGoal() {

    }
}
