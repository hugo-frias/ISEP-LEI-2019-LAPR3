package lapr.project.model;

import java.util.Date;

public class Rent {
    private String requestCode;
    private Date dateHourStart;
    private Date dateHourFinish;
    private int distanciaKm;
    private User user;
    private Vehicle vehicle;
    private Park initialPark;
    private Park endPark;


    public Rent(String requestCode, Date dateHourStart, Date dateHourFinish, int distanciaKm, User user, Vehicle vehicle, Park initialPark, Park endPark) {
        this.requestCode = requestCode;
        this.dateHourStart = (Date) dateHourStart.clone();
        this.dateHourFinish = (Date) dateHourFinish.clone();
        this.distanciaKm = distanciaKm;
        this.user = user;
        this.vehicle = vehicle;
        this.initialPark = initialPark;
        this.endPark = endPark;

    }

    public Rent() {
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String request_code) {
        this.requestCode = request_code;
    }

    public Date getDate_hour_start() {
        return (Date) dateHourStart.clone();
    }

    public void setDate_hour_start(Date date_hour_start) {
        this.dateHourStart = (Date) date_hour_start.clone();
    }

    public Date getDate_hour_finish() {
        return (Date) dateHourFinish.clone();
    }

    public void setDate_hour_finish(Date date_hour_finish) {
        this.dateHourFinish = (Date) date_hour_finish.clone();
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distancia_km) {
        this.distanciaKm = distancia_km;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Park getInitialPark() {
        return initialPark;
    }

    public void setInitialPark(Park initial_park) {
        this.initialPark = initial_park;
    }

    public Park getEndPark() {
        return endPark;
    }

    public void setEnd_park(Park end_park) {
        this.endPark = end_park;
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
        final Rent other = (Rent) obj;
        return requestCode.equals(other.requestCode);
    }


}
