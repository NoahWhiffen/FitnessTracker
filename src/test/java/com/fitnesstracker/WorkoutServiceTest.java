package com.fitnesstracker.service;

import com.fitnesstracker.dao.WorkoutDAO;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.service.WorkoutService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WorkoutServiceTest {
  
  private WorkoutService workoutService;
  private WorkoutDAO mockDAO;

  @Before
  public void setUp() {
    mockDAO = mock(WorkoutDAO.class);
    workoutService = new WorkoutService(mockDAO);
  }

  @Test
  public void testAddWorkoutValid() {
    LocalDate date = LocalDate.of(2025, 05, 29);
    Workout workout = new Workout(date, "chest day", 75);
    workoutService.addWorkout(workout);

    verify(mockDAO, times(1)).addWorkout(workout);
  }

  @Test
  public void testDeleteWorkout() {
    workoutService.deleteWorkout(1);

    verify(mockDAO, times(1)).deleteWorkout(1);
  }
}