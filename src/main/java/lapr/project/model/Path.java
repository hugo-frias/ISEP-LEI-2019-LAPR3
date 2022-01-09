package lapr.project.model;

import java.util.Objects;

public class Path {

    private double latitudeA;
    private double longitudeA;
    private double latitudeB;
    private double longitudeB;
    private double kineticCoefficient;
    private int windDirection;
    private double windSpeed;

    public Path() {
    }

    public Path(double latitudeA, double longitudeA, double latitudeB, double longitudeB, double kineticCoefficient, int windDirection, double windSpeed) {
        this.latitudeA = latitudeA;
        this.longitudeA = longitudeA;
        this.latitudeB = latitudeB;
        this.longitudeB = longitudeB;
        this.kineticCoefficient = kineticCoefficient;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public double getLatitudeA() {
        return latitudeA;
    }

    public double getLongitudeA() {
        return longitudeA;
    }

    public double getLatitudeB() {
        return latitudeB;
    }

    public double getLongitudeB() {
        return longitudeB;
    }

    public double getKineticCoefficient() {
        return kineticCoefficient;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setLatitudeA(double latitudeA) {
        this.latitudeA = latitudeA;
    }

    public void setLongitudeA(double longitudeA) {
        this.longitudeA = longitudeA;
    }

    public void setLatitudeB(double latitudeB) {
        this.latitudeB = latitudeB;
    }

    public void setLongitudeB(double longitudeB) {
        this.longitudeB = longitudeB;
    }

    public void setKineticCoefficient(double kineticCoefficient) {
        this.kineticCoefficient = kineticCoefficient;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Path{" + "latitudeA=" + latitudeA + ", longitudeA=" + longitudeA + ", latitudeB=" + latitudeB + ", longitudeB=" + longitudeB + ", kineticCoefficient=" + kineticCoefficient + ", windDirection=" + windDirection + ", windSpeed=" + windSpeed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;
        Path path = (Path) o;
        return Double.compare(path.latitudeA, latitudeA) == 0 &&
                Double.compare(path.longitudeA, longitudeA) == 0 &&
                Double.compare(path.latitudeB, latitudeB) == 0 &&
                Double.compare(path.longitudeB, longitudeB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitudeA, longitudeA, latitudeB, longitudeB, kineticCoefficient, windDirection, windSpeed);
    }
}
