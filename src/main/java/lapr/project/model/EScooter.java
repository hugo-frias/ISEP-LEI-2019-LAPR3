package lapr.project.model;

import java.sql.SQLException;
import java.util.Objects;

import lapr.project.data.EScooterDB;

public class EScooter extends Vehicle {

    private String esType;
    private int maxBatteryCapacity;
    private int actualBatteryCapacity;
    private int motor;

    public EScooter(String description, int weight, double parkLatitude, double parkLongitude, double aerodynamicCoefficient, double frontalArea, String esType, int maxBatteryCapacity, int actualBatteryCapacity, int motor) {
        super(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea);
        this.esType = esType;
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.actualBatteryCapacity = actualBatteryCapacity;
        this.motor = motor;
    }

    public EScooter() {
        super();
        this.esType = "Omission";
        this.maxBatteryCapacity = 0;
        this.actualBatteryCapacity = 0;
        this.motor = 0;
    }

    public String getEsType() {
        return esType;
    }

    public int getMaxBatteryCapacity() {
        return maxBatteryCapacity;
    }

    public int getActualBatteryCapacity() {
        return actualBatteryCapacity;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public void setEsType(String esType) {
        this.esType = esType;
    }

    public void setMaxBatteryCapacity(int maxBatteryCapacity) {
        this.maxBatteryCapacity = maxBatteryCapacity;
    }

    public void setActualBatteryCapacity(int actualBatteryCapacity) {
        this.actualBatteryCapacity = actualBatteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), esType, maxBatteryCapacity, actualBatteryCapacity);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "EScooter: " + super.getDescription() +
                +'{' + "esType='" + esType +
                ", maxBatteryCapacity=" + maxBatteryCapacity +
                ", actualBatteryCapacity=" + actualBatteryCapacity +
                ", motor=" + motor +
                '}' + "\n";
    }
}
