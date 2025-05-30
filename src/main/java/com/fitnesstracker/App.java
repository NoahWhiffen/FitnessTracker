package com.fitnesstracker;

import com.fitnesstracker.model.*;
import com.fitnesstracker.service.WorkoutService;
import com.fitnesstracker.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static WorkoutService workoutService = new WorkoutService();
    private static UserService userService = new UserService();
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
                    addGoal();
                    break;
                case "6":
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
        System.out.println("5. Add a Goal");
        System.out.println("6. Update a Goal");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    // Option 1
    private static void addUser() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter desired username: ");
        String username = scanner.nextLine();

        User user = new User(name, username);
        userService.addUser(user);
        System.out.println("User added successfully!");
    }

    // Option 2
    private static void addWorkout() {
        try {
            System.out.print("Enter date of workout (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateInput);

            System.out.print("Enter workout type: ");
            String type = scanner.nextLine();

            System.out.print("Enter duration of workout in minutes: ");
            int duration = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Exercise> exercises = new ArrayList<>();
            System.out.println("Enter number of exercises (or type 'done' to finish):");

            while (true) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                try {
                    int numExercises = Integer.parseInt(input);
                    for (int i = 0; i < numExercises; i++) {
                        System.out.print("Enter name of exercise #" + (i + 1) + ": ");
                        String name = scanner.nextLine();
                        System.out.print("Enter number of sets: ");
                        int sets = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter number of reps per set: ");
                        int reps = Integer.parseInt(scanner.nextLine());

                        exercises.add(new Exercise(name, reps, sets));
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'done'.");
                }
            }

            Workout workout = new Workout(date, type, duration);
            workout.setExercises(exercises);
            workoutService.addWorkout(workout);
        } catch (Exception e) {
            System.out.println("Error adding workout: " + e.getMessage());
        }
    }

    // Option 3
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

    // Option 4
    private static void deleteWorkout() {
        System.out.println("Enter the ID of the workout you'd like to delete: ");
        int workoutToDelete = scanner.nextInt();
        workoutService.deleteWorkout(workoutToDelete);
        scanner.nextLine();
    }

    // Option 5
    private static void addGoal() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        User user = userService.findUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        
        System.out.println("Add goal description: ");
        String description = scanner.nextLine();

        System.out.println("Enter the target of your goal: ");
        String target = scanner.nextLine();

        System.out.println("Has the goal been achieved? (y/n): ");
        String achievedInput = scanner.nextLine().trim().toLowerCase();
        boolean achieved = achievedInput.equals("y");

        Goal newGoal = new Goal(description, target, achieved);

        System.out.println("Goal added: " + newGoal.getDescription());
}

    // Option 6
    private static void updateGoal() {
    System.out.println("Enter your username: ");
    String username = scanner.nextLine();

    User user = userService.findUserByUsername(username);

    if (user == null) {
        System.out.println("User not found.");
        return;
    }

    List<Goal> goals = user.getGoals();
    if (goals.isEmpty()) {
        System.out.println("No goals found for this user.");
        return;
    }

    Goal goal = goals.get(0); // Just editing the first goal for now
    System.out.println("Current Goal Description: " + goal.getDescription());
    System.out.println("Enter new description (leave blank to keep current): ");
    String description = scanner.nextLine();
    if (!description.trim().isEmpty()) {
        goal.setDescription(description);
    }

    System.out.println("Current Target: " + goal.getTarget());
    System.out.println("Enter new target (leave blank to keep current): ");
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