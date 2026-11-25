package com.statusmaxing;

public class FinancialProfile {
    private double monthlyIncome;
    private double savings;
    private double totalDebt;

    public FinancialProfile(double monthlyIncome, double savings, double totalDebt) {
        if (monthlyIncome < 0 || savings < 0 || totalDebt < 0) {
            throw new IllegalArgumentException("Money values cannot be negative.");
        }
        this.monthlyIncome = monthlyIncome;
        this.savings = savings;
        this.totalDebt = totalDebt;
    }

    public double calculateNetWorth() {
        return savings - totalDebt;
    }

    public String evaluateFinancialStanding() {
        double netWorth = calculateNetWorth();
        if (netWorth < 0) {
            return "BROKE NPC";
        }
        if (netWorth < 10000) {
            return "SIDE QUEST";
        }
        if (netWorth < 50000) {
            return "GRINDING";
        }
        if (netWorth < 250000) {
            return "HIGH ROLLER";
        }
        return "FINAL BOSS";
    }

    public boolean canAffordMilestone(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
        return savings >= cost;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        if (monthlyIncome < 0) {
            throw new IllegalArgumentException("Monthly income cannot be negative.");
        }
        this.monthlyIncome = monthlyIncome;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        if (savings < 0) {
            throw new IllegalArgumentException("Savings cannot be negative.");
        }
        this.savings = savings;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        if (totalDebt < 0) {
            throw new IllegalArgumentException("Total debt cannot be negative.");
        }
        this.totalDebt = totalDebt;
    }
}
