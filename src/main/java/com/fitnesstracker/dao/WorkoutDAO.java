package com.fitnesstracker.dao;

import com.fitnesstracker.model.Workout;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {

    public void addWorkout(Workout workout) {
        String sql = "INSERT INTO workouts (date, type, duration) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setDate(1, Date.valueOf(workout.getDate()));
            pstmt.setString(2, workout.getType());
            pstmt.setInt(3, workout.getDuration());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                workout.setWorkoutId(generatedId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateWorkout(Workout workout) {
        String sql = "UPDATE workouts SET date = ?, type = ?, duration = ? WHERE workout_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(workout.getDate()));
            pstmt.setString(2, workout.getType());
            pstmt.setInt(3, workout.getDuration());
            pstmt.setInt(4, workout.getWorkoutId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkout(int workoutId) {
        String sql = "DELETE FROM workouts WHERE workout_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, workoutId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT workout_id, date, type, duration FROM workouts";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Workout workout = new Workout(
                        rs.getDate("date").toLocalDate(),
                        rs.getString("type"),
                        rs.getInt("duration")
                );
                workout.setWorkoutId(rs.getInt("workout_id"));
                workouts.add(workout);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workouts;
    }
}
