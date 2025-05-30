package com.fitnesstracker.model;
public class Exercise {
    private String name;
    private int reps;
    private int sets;

    public Exercise(String name, int reps, int sets) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    // String method
    @Override
    public String toString() {
        return String.format("%s (Sets: %d, Reps: %d)", name, sets, reps);
    }
}