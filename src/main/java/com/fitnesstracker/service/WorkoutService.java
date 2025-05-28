package com.fitnesstracker.service;

import java.util.List;
import com.fitnesstracker.dao.WorkoutDAO;
import com.fitnesstracker.model.Workout;

public class WorkoutService {

    private WorkoutDAO workoutDAO = new WorkoutDAO();

    public void addWorkout(Workout workout) {
        if (workout.getType().isEmpty()) {
            throw new IllegalArgumentException("Workout type is required.");
        }
        workoutDAO.addWorkout(workout);
        System.out.println("Workout added successfully with ID: " + workout.getWorkoutId());
    }

    public void updateWorkout(Workout workout) {
        workoutDAO.updateWorkout(workout);
        System.out.println("Workout updated successfully.");
    }

    public void deleteWorkout(int workoutId) {
        workoutDAO.deleteWorkout(workoutId);
        System.out.println("Workout deleted successfully.");
    }

    public List<Workout> getAllWorkouts() {
        return workoutDAO.getAllWorkouts();
    }

}
