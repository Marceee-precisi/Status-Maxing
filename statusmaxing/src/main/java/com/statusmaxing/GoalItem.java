package com.statusmaxing;

public class GoalItem {
    private String goalName;
    private double targetCost;
    private int targetTimelineMonths;

    public GoalItem(String goalName, double targetCost, int targetTimelineMonths) {
        if (targetCost < 0) {
            throw new IllegalArgumentException("Target cost cannot be negative.");
        }
        if (targetTimelineMonths < 0) {
            throw new IllegalArgumentException("Target timeline cannot be negative.");
        }
        this.goalName = goalName;
        this.targetCost = targetCost;
        this.targetTimelineMonths = targetTimelineMonths;
    }

    public String getGoalName() {
        return goalName;
    }

    public double getTargetCost() {
        return targetCost;
    }

    public int getTargetTimelineMonths() {
        return targetTimelineMonths;
    }
}
