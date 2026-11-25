package com.statusmaxing;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alex", 24, "unspecified", 170, 70);
        FinancialProfile profile = new FinancialProfile(3800, 16500, 2000);
        GoalItem goal = new GoalItem("House Down Payment", 60000, 60);
        ScoreCalculator calculator = new ScoreCalculator();

        double bmi = user.calculateBMI();
        double netWorth = profile.calculateNetWorth();
        String tier = profile.evaluateFinancialStanding();
        int statusScore = calculator.computeStatusScore(user, profile);
        double goalProbability = calculator.calculateGoalProbability(profile, goal, 500);

        System.out.println("StatusMaxing Demo");
        System.out.println("-----------------");
        System.out.printf("BMI: %.2f%n", bmi);
        System.out.printf("Net Worth: $%.2f%n", netWorth);
        System.out.println("Financial Standing: " + tier);
        System.out.println("Status Score: " + statusScore);
        System.out.printf("Goal Probability (%s): %.2f%%%n", goal.getGoalName(), goalProbability);
    }
}
