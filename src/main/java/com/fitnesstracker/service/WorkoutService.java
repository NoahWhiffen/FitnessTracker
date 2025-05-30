package com.fitnesstracker.service;

import com.fitnesstracker.model.Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkoutService {

    private List<Workout> workouts;
    private int nextId;

    public WorkoutService() {
        this.workouts = new ArrayList<>();
        this.nextId = 1;
    }

    public void addWorkout(Workout workout) {
        if (workout.getType() == null || workout.getType().isEmpty()) {
            throw new IllegalArgumentException("Workout type is required.");
        }
        workout.setWorkoutId(nextId++);
        workouts.add(workout);
        System.out.println("Workout added successfully with ID: " + workout.getWorkoutId());
    }

    public void updateWorkout(Workout updatedWorkout) {
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).getWorkoutId() == updatedWorkout.getWorkoutId()) {
                workouts.set(i, updatedWorkout);
                System.out.println("Workout updated successfully.");
                return;
            }
        }
        System.out.println("Workout not found.");
    }

    public void deleteWorkout(int workoutId) {
        Iterator<Workout> iterator = workouts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getWorkoutId() == workoutId) {
                iterator.remove();
                System.out.println("Workout deleted successfully.");
                return;
            }
        }
        System.out.println("Workout not found.");
    }

    public List<Workout> getAllWorkouts() {
        return new ArrayList<>(workouts);
    }
}
