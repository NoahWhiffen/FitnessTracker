package com.fitnesstracker;

import com.fitnesstracker.model.Workout;
import com.fitnesstracker.service.WorkoutService;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class WorkoutServiceTest {

    private WorkoutService workoutService;

    @Before
    public void setUp() {
        workoutService = new WorkoutService();
    }

    @Test
    public void testAddWorkoutValid() {
        Workout workout = new Workout(LocalDate.of(2025, 5, 29), "chest day", 75);

        workoutService.addWorkout(workout);

        List<Workout> allWorkouts = workoutService.getAllWorkouts();
        assertEquals(1, allWorkouts.size());
        assertEquals("chest day", allWorkouts.get(0).getType());
        assertEquals(1, allWorkouts.get(0).getWorkoutId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWorkoutInvalidType() {
        Workout workout = new Workout(LocalDate.of(2025, 5, 29), "", 30);

        workoutService.addWorkout(workout);
    }

    @Test
    public void testDeleteWorkout() {
        Workout workout1 = new Workout(LocalDate.of(2025, 5, 29), "leg day", 60);
        workoutService.addWorkout(workout1);

        Workout workout2 = new Workout(LocalDate.of(2025, 6, 1), "back day", 45);
        workoutService.addWorkout(workout2);

        workoutService.deleteWorkout(workout1.getWorkoutId());

        List<Workout> allWorkouts = workoutService.getAllWorkouts();
        assertEquals(1, allWorkouts.size());
        assertEquals("back day", allWorkouts.get(0).getType());
    }

    @Test
    public void testUpdateWorkout() {
        Workout workout = new Workout(LocalDate.of(2025, 5, 29), "shoulders", 50);
        workoutService.addWorkout(workout);

        Workout updatedWorkout = new Workout(workout.getWorkoutId(), LocalDate.of(2025, 5, 30), "shoulders updated", 55);

        workoutService.updateWorkout(updatedWorkout);

        List<Workout> allWorkouts = workoutService.getAllWorkouts();
        assertEquals(1, allWorkouts.size());
        assertEquals("shoulders updated", allWorkouts.get(0).getType());
        assertEquals(55, allWorkouts.get(0).getDuration());
        assertEquals(LocalDate.of(2025, 5, 30), allWorkouts.get(0).getDate());
    }
}
