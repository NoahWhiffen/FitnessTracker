import java.sql.SQLException;
import java.util.List;

public class WorkoutClassService {

    private WorkoutClassDAO workoutDAO = new WorkoutClassDAO();

    public void addWorkoutClass(WorkoutClass workoutClass) {
        if (workoutClass.getWorkoutClassType().isEmpty()) {
            throw new IllegalArgumentException("Workout type is required.");
        }
        workoutDAO.addWorkoutClass(workoutClass);
        System.out.println("Workout class added successfully with ID: " + workoutClass.getWorkoutClassId());
    }

    public void updateWorkoutClass(WorkoutClass workoutClass) {
        workoutDAO.updateWorkoutClass(workoutClass);
        System.out.println("Workout class updated successfully.");
    }

    public void deleteWorkoutClass(int workoutClassId) {
        workoutDAO.deleteWorkoutClass(workoutClassId);
        System.out.println("Workout class deleted successfully.");
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        return workoutDAO.getAllClasses();
    }

    public List<WorkoutClass> getWorkoutClassesByTrainer(int trainerId) {
        return workoutDAO.getWorkoutClassesByTrainer(trainerId);
    }

}
