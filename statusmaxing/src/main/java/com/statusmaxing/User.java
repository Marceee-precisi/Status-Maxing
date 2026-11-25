package com.statusmaxing;

public class User {
    private String name;
    private int age;
    private String gender;
    private double weightLbs;
    private double heightInches;

    public User(String name, int age, String gender, double weightLbs, double heightInches) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if (heightInches <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        if (weightLbs < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weightLbs = weightLbs;
        this.heightInches = heightInches;
    }

    public double calculateBMI() {
        return weightLbs * 703 / (heightInches * heightInches);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(double weightLbs) {
        if (weightLbs < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.weightLbs = weightLbs;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(double heightInches) {
        if (heightInches <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        this.heightInches = heightInches;
    }
}
