package main.java.com.fitnesstracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workout {
    private int workoutId;
    private LocalDate date;
    private String type;
    private int duration; // In minutes
    private ArrayList<Exercise> exercises; 

    public Workout(LocalDate date, String type, int duration) {
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.exercises = new ArrayList<>();
    }

    // Getters
    public int getWorkoutId() {
        return workoutId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<Exercises> getExercises() {
        return exercises;
    }

    // Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Exercises> setExercises() {
        this.exercises = exercises;
    }

    // Modifiers
}
