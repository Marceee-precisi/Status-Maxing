package com.statusmaxing;

public class ScoreCalculator {

    public int computeStatusScore(User user, FinancialProfile fin) {
        double netWorth = fin.calculateNetWorth();
        double netWorthPoints = clamp(netWorth / 50000.0, 0, 1) * 400;

        double bmi = user.calculateBMI();
        double healthPoints;
        if (bmi >= 18.5 && bmi <= 24.9) {
            healthPoints = 250;
        } else {
            double distance;
            if (bmi < 18.5) {
                distance = 18.5 - bmi;
            } else {
                distance = bmi - 24.9;
            }
            healthPoints = Math.max(0, 250 - 25 * distance);
        }

        double debtToIncome = calculateDebtToIncome(fin);
        double debtPoints;
        if (debtToIncome <= 0.36) {
            debtPoints = 350;
        } else {
            debtPoints = Math.max(0, 350 - (debtToIncome - 0.36) * 1000);
        }

        double score = netWorthPoints + healthPoints + debtPoints;
        return (int) Math.round(clamp(score, 0, 1000));
    }

    public double calculateGoalProbability(FinancialProfile fin, GoalItem goal, double monthlySavingsRate) {
        double remaining = Math.max(0, goal.getTargetCost() - fin.getSavings());
        if (remaining == 0) {
            return 100;
        }
        if (monthlySavingsRate <= 0) {
            return 0;
        }

        double monthsNeeded = remaining / monthlySavingsRate;
        double probability = Math.min(100, (goal.getTargetTimelineMonths() / monthsNeeded) * 100);

        double debtToIncome = calculateDebtToIncome(fin);
        if (debtToIncome > 0.36) {
            probability -= 10;
        }

        return clamp(probability, 0, 100);
    }

    private double calculateDebtToIncome(FinancialProfile fin) {
        double annualIncome = fin.getMonthlyIncome() * 12;
        if (annualIncome == 0) {
            if (fin.getTotalDebt() > 0) {
                return 1.0;
            }
            return 0.0;
        }
        return fin.getTotalDebt() / annualIncome;
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
