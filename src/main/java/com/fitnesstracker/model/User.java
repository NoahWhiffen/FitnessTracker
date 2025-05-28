import java.util.ArrayList;

public class User {
    
    private int userId;
    private String name;
    private String username;
    private ArrayList<Workout> workouts;
    private ArrayList<Goal> goals;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        this.goals = new ArrayList<>();
        this.workouts = new ArrayList<>();
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Modifiers
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public boolean removeGoal(Goal goal) {
        return goals.remove(goal);
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public boolean removeWorkout(Workout workout) {
        return workouts.remove(workout);
    }

}
