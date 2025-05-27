package main.java.com.fitnesstracker;

import java.util.ArrayList;

public class User {
    
    private int userId;
    private String name;
    private String email;
    private ArrayList<Workout> workouts;
    private ArrayList<Goal> goals;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.goals = new ArrayList<>();
        this.workouts = new ArrayList<>();
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Modifiers
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public boolean removeGoal(Goal goal) {
        return goals.remove(goal);
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public boolean removeWorkout(Workout workout) {
        return workouts.remove(workout);
    }

}
