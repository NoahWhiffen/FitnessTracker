package com.fitnesstracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Enter the ID of the workout you'd like to delete: ");
        int workoutToDelete = scanner.nextInt();
        workoutService.deleteWorkout(workoutToDelete);
    }

    private static void updateGoal() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        User user = workoutService.findUserByUsername();

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Goal goal = user.getGoals();

        if (goal == null) {
            System.out.println("No goal found for this user.");
            return;
        } else {
            System.out.println("Current Goal Description: " + goal.getDescription());
            System.out.println("Enter new description (leave blank to keep curent): ");
            String description = scanner.nextLine();
            if (!description.trim().isEmpty()) {
                goal.setDescription(description);
            }

            System.out.println("Current Target: " + goal.getTarget());
            System.out.println("Enter new target (leave blank to keep current)");
            String target = scanner.nextLine();
            if (!target.trim().isEmpty()) {
                goal.setTarget(target);
            }

            System.out.println("Is the goal achieved? (true/false): ");
            String achievedStr = scanner.nextLine();
            if (!achievedStr.trim().isEmpty()) {
            boolean achieved = Boolean.parseBoolean(achievedStr);
            goal.setAchieved(achieved);
        }

        System.out.println("Goal updated successfully.");
        }
    }
}
