package lapr.project.model;

import java.util.Objects;

public abstract class Vehicle {
    private String id;
    private int weight;
    private double parkLatitude;
    private double parkLongitude;
    private double aerodynamicCoefficient;
    private double frontalArea;

    public Vehicle(String description, int weight, double parkLatitude, double parkLongitude, double aerodynamicCoefficient, double frontalArea) {
        this.id = description;
        this.weight = weight;
        this.parkLatitude = parkLatitude;
        this.parkLongitude = parkLongitude;
        this.aerodynamicCoefficient = aerodynamicCoefficient;
        this.frontalArea = frontalArea;
    }

    public Vehicle() {
        this.id = "description";
        this.weight = 0;
        this.parkLatitude = 0;
        this.parkLongitude = 0;
        this.aerodynamicCoefficient = 0;
        this.frontalArea = 0;
    }


    public String getDescription() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public double getParkLatitude() {
        return parkLatitude;
    }

    public double getParkLongitude() {
        return parkLongitude;
    }

    public double getAerodynamicCoefficient() {
        return aerodynamicCoefficient;
    }

    public double getFrontalArea() {
        return frontalArea;
    }

    public void setDescription(String description) {
        this.id = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setParkLatitude(double parkLatitude) {
        this.parkLatitude = parkLatitude;
    }

    public void setParkLongitude(double parkLongitude) {
        this.parkLongitude = parkLongitude;
    }

    public void setAerodynamicCoefficient(double aerodynamicCoefficient) {
        this.aerodynamicCoefficient = aerodynamicCoefficient;
    }

    public void setFrontalArea(double frontalArea) {
        this.frontalArea = frontalArea;
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
        final Vehicle other = (Vehicle) obj;

        return (other.getDescription().equals(this.getDescription()));

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea);
    }

    @Override
    public String toString() {
        return "Vehicle{" + "description=" + id + ", weight=" + weight + ", parkLatitude=" + parkLatitude + ", parkLongitude=" + parkLongitude + ", aerodynamicCoefficient=" + aerodynamicCoefficient + ", frontalArea=" + frontalArea + '}';
    }


}
