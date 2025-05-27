package main.java.com.fitnesstracker;

public class Goal {
    private int goalId;
    private String description;
    private String target;
    private boolean achieved;

    public Goal(String description, String target, boolean achieved) {
        this.description = description;
        this.target = target;
        this.achieved = achieved;
    }

    // Getters
    public int getGoalId() {
        return goalId;
    }

    public String getDescription() {
        return description;
    }

    public String getTarget() {
        return target;
    }

    public boolean isAchieved() {
        return achieved;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    // Modifiers

}
