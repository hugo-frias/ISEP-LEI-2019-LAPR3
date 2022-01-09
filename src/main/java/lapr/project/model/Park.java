package lapr.project.model;

import java.util.Objects;

public class Park extends Place {

    private int maxNumberBicycles;
    private int maxNumberEScooters;
    private double inputVoltage;
    private double inputCurrent;

    public Park(String parkID, double latitude, double longitude, int elevation, String parkDescription, int maxNumberBicycles, int maxNumberEScooters, double inputVoltage, double inputCurrent) {
        super(parkID, latitude, longitude, elevation, parkDescription);
        this.maxNumberBicycles = maxNumberBicycles;
        this.maxNumberEScooters = maxNumberEScooters;
        this.inputVoltage = inputVoltage;
        this.inputCurrent = inputCurrent;
    }

    public Park() {
        super();
        this.maxNumberBicycles = 0;
        this.maxNumberEScooters = 0;
        this.inputVoltage = 0;
        this.inputCurrent = 0;
    }

    public int getMaxNumberBicycles() {
        return this.maxNumberBicycles;

    }

    public int getMaxNumberEScooters() {
        return this.maxNumberEScooters;
    }

    public double getInputVoltage() {
        return inputVoltage;
    }

    public double getInputCurrent() {
        return inputCurrent;
    }

    public void setMaxNumberBicycles(int maxNumberBicycles) {
        this.maxNumberBicycles = maxNumberBicycles;
    }

    public void setMaxNumberEScooters(int maxNumberEScooters) {
        this.maxNumberEScooters = maxNumberEScooters;
    }

    public void setInputVoltage(double inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public void setInputCurrent(double inputCurrent) {
        this.inputCurrent = inputCurrent;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(maxNumberBicycles, maxNumberEScooters, inputVoltage, inputCurrent);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Park other = (Park) obj;
        return this.getId().equalsIgnoreCase(other.getId());
    }

    @Override
    public String toString() {
        return String.format("%s, MaxNumberBicyles: %d, MaxNumberEScooters: %d, InputVoltage: %.3f, InputCurrent: %.3f", super.toString(), maxNumberBicycles, maxNumberEScooters, inputVoltage, inputCurrent);
    }

}

