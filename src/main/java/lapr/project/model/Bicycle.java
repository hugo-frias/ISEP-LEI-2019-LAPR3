package lapr.project.model;

public class Bicycle extends Vehicle {

    private int wheelSize;
    
    public Bicycle(String description, int weight, double parkLatitude, double parkLongitude, double aerodynamicCoefficient, double frontalArea, int wheel_size) {
        super(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea);
        this.wheelSize = wheel_size;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
    
}