import java.time.LocalDate;
import java.util.ArrayList;

public class WorkoutService {
    private final WorkoutDAO WorkoutDAO = new WorkoutDAO();

    public void createWorkout(LocalDate date, String type, int duration) {
        Workout workout = new Workout(date, type, duration);
        WorkoutDAO.save(workout);
    }

    public List<Workout> getWorkoutsByUser(int userId) {

    }

    public Workout getWorkoutbyId(int workoutId) {

    }

    public void updateWorkout(Workout workout) {

    }

    public void deleteWorkout(int workoutId) {

    }

    public void addExerciseToWorkout(int workoutid, Exercise exercise) {

    }
}
