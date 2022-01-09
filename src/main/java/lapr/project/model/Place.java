package lapr.project.model;

import java.util.Objects;

public abstract class Place {

    private String id;
    private double latitude;
    private double longitude;
    private int elevation;
    private String description;

    public Place() {
        this.id = "null";
        this.latitude = 0;
        this.longitude = 0;
        this.elevation = 0;
        this.description = "null desc";
    }

    public Place(String id, double latitude, double longitude, int elevation, String description) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getElevation() {
        return elevation;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, elevation, description);
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
        final Place other = (Place) obj;
        return Double.compare(latitude, other.latitude) == 0
                && Double.compare(longitude, other.longitude) == 0;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Latitude: %.3f, Longitude: %.3f, Elevation: %d, Description: %s", id, latitude, longitude, elevation, description);
    }

}

