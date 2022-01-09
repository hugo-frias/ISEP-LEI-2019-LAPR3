package lapr.project.model;

import lapr.project.data.UserDB;
import java.sql.SQLException;

public class User {

    private String username;
    private String email;
    private int height;
    private int weight;
    private double cyclingAvgSpeed;
    private double visaCardNumber;
    private char gender;
    private String password;
    private int points;

    public User(String username, String email, String password, int height, int weight, char gender, double cyclingAvgSpeed, double visaCardNumber, int points) {
        this.username = username;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.cyclingAvgSpeed = cyclingAvgSpeed;
        this.visaCardNumber = visaCardNumber;
        this.gender = gender;
        this.password = password;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCyclingAvgSpeed() {
        return cyclingAvgSpeed;
    }

    public void setCyclingAvgSpeed(double cyclingAvgSpeed) {
        this.cyclingAvgSpeed = cyclingAvgSpeed;
    }

    public double getVisaCardNumber() {
        return visaCardNumber;
    }

    public void setVisaCardNumber(double visaCardNumber) {
        this.visaCardNumber = visaCardNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Email: %s", this.username, this.email);
    }
}
