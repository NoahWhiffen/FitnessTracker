import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {

    public void addWorkout(Workout workout) {
        String sql = "INSERT INTO workout_classes (class_type, class_description, trainer_id) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, workout.getWorkoutType());
            pstmt.setString(2, workout.getWorkoutDescription());
            pstmt.setInt(3, workout.getTrainerId());

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
        String sql = "UPDATE workout_classes SET class_type = ?, class_description = ?, trainer_id = ? WHERE class_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, workout.getWorkoutType());
            pstmt.setString(2, workout.getWorkoutDescription());
            pstmt.setInt(3, workout.getTrainerId());
            pstmt.setInt(4, workout.getWorkoutId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkout(int workoutId) {
        String sql = "DELETE FROM workout_classes WHERE class_id = ?";

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
        String sql = "SELECT * FROM workout_classes";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Workout workout = new Workout(
                        rs.getInt("class_id"),
                        rs.getString("class_type"),
                        rs.getString("class_description"),
                        rs.getInt("trainer_id")
                );
                workouts.add(workout);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workouts;
    }

    public List<Workout> getWorkoutsByTrainer(int trainerId) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workout_classes WHERE trainer_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, trainerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Workout workout = new Workout(
                        rs.getInt("class_id"),
                        rs.getString("class_type"),
                        rs.getString("class_description"),
                        rs.getInt("trainer_id")
                );
                workouts.add(workout);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workouts;
    }
}
