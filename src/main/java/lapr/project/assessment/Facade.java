package lapr.project.assessment;

import lapr.project.controller.*;
import lapr.project.data.*;
import lapr.project.model.*;
import lapr.project.utils.*;

import java.io.*;
import java.math.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Facade implements Serviceable {

    @Override
    public int addBicycles(String s) {
        ParkController parkController1 = new ParkController();
        BicycleController bicycleController1 = new BicycleController();
        List<String> list = Utils.loadCsv(s);
        List<Bicycle> bList = new ArrayList<>();
        int countBicycles = 0;
        try {
            if (list != null) {
                for (String b : list) {
                    String[] aux = b.split(";");
                    String description = aux[0].trim();
                    int weight = Integer.parseInt(aux[1].trim());
                    double parkLatitude = Double.parseDouble(aux[2].trim());
                    double parkLongitude = Double.parseDouble(aux[3].trim());
                    double aerodynamicCoefficient = Double.parseDouble(aux[4].trim());
                    double frontalArea = Double.parseDouble(aux[5].trim());
                    String[] aux1 = aux[6].trim().split("'");
                    int wheelSize = Integer.parseInt(aux1[0]);
                    Bicycle aux2 = new Bicycle(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, wheelSize);
                    try {
                        if (parkController1.getParkByCoordinates(aux2.getParkLatitude(), aux2.getParkLongitude()) == null) {
                            throw new NullPointerException();
                        }
                    } catch (Exception ex) {
                        throw new NullPointerException();
                    }
                    bList.add(aux2);
                }
                if (bicycleController1.addBicycle(bList)) {
                    countBicycles = bList.size();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countBicycles;
    }

    @Override
    public int addEscooters(String s) {
        ParkController parkController1 = new ParkController();
        EScooterController escooterController1 = new EScooterController();
        List<String> list = Utils.loadCsv(s);
        List<EScooter> eList = new ArrayList<>();
        int countEScooters = 0;
        try {
            if (list != null) {
                for (String es : list) {
                    String[] aux = es.split(";");
                    String description = aux[0].trim();
                    int weight = Integer.parseInt(aux[1].trim());
                    double latitude = Double.parseDouble(aux[3].trim());
                    double longitude = Double.parseDouble(aux[4].trim());
                    double aerodynamicCoefficient = Double.parseDouble(aux[7].trim());
                    double frontalArea = Double.parseDouble(aux[8].trim());
                    String type = aux[2].trim();
                    if (type.equalsIgnoreCase("city")) {
                        type = "CI";
                    }
                    if (type.equalsIgnoreCase("off-road")) {
                        type = "OR";
                    }

                    int maxBatteryCapacity = Integer.parseInt(aux[5].trim());
                    int actualBatteryCapacity = Integer.parseInt(aux[6].trim());
                    int motor = Integer.parseInt(aux[9].trim());
                    EScooter aux2 = new EScooter(description, weight, latitude, longitude, aerodynamicCoefficient, frontalArea, type, maxBatteryCapacity, actualBatteryCapacity, motor);
                    try {
                        if (parkController1.getParkByCoordinates(aux2.getParkLatitude(), aux2.getParkLongitude()) == null) {
                            throw new NullPointerException();
                        }
                    } catch (Exception ex) {
                        throw new NullPointerException();
                    }
                    eList.add(aux2);
                }
                if (escooterController1.addEScooter(eList)) {
                    countEScooters = eList.size();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countEScooters;
    }

    @Override
    public int addParks(String s) {
        ParkController parkController1 = new ParkController();
        List<String> list = Utils.loadCsv(s);
        List<Park> pList = new ArrayList<>();
        int countParks = 0;
        try {
            if (list != null) {
                for (String p : list) {
                    String[] aux = p.split(";");
                    String id = aux[0].trim();
                    double latitude = Double.parseDouble(aux[1].trim());
                    double longitude = Double.parseDouble(aux[2].trim());
                    int elevation = Integer.parseInt(aux[3].trim());
                    String description = aux[4].trim();
                    int maxNumberBicycles = Integer.parseInt(aux[5].trim());
                    int maxNumberEScooters = Integer.parseInt(aux[6].trim());
                    double inputVoltage = Double.parseDouble(aux[7].trim());
                    double inputCurrent = Double.parseDouble(aux[8].trim());
                    Park aux2 = new Park(id, latitude, longitude, elevation, description, maxNumberBicycles, maxNumberEScooters, inputVoltage, inputCurrent);
                    pList.add(aux2);
                }
                if (parkController1.addPark(pList)) {
                    countParks = pList.size();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return countParks;
        }
    }

    @Override
    public int removePark(String s) {
        ParkController parkController1 = new ParkController();
        try {
            Park aux = parkController1.getPark(s);
            if (aux == null) {
                return 0;
            }
            if (parkController1.removePark(aux)) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addPOIs(String s) {
        PoiController poiController1 = new PoiController();
        List<String> list = Utils.loadCsv(s);
        List<Poi> pList = new ArrayList<>();
        int countPois = 0;
        try {
            int numberId = poiController1.getNumberOfPois();
            if (list != null) {
                for (String p : list) {
                    String[] aux = p.split(";");
                    String id = "P" + numberId;
                    double latitude = Double.parseDouble(aux[0].trim());
                    double longitude = Double.parseDouble(aux[1].trim());
                    int elevation = Integer.parseInt(aux[2].trim());
                    String description = aux[3].trim();
                    Poi aux2 = new Poi(id, latitude, longitude, elevation, description);
                    pList.add(aux2);
                    numberId++;
                }
                if (poiController1.addPoi(pList)) {
                    countPois = pList.size();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countPois;
    }

    @Override
    public int addUsers(String s) {
        UserController userController = new UserController();
        List<String> list = Utils.loadCsv(s);
        List<User> uList = new ArrayList<>();
        int countUsers = 0;
        try {
            if (list != null) {
                for (String b : list) {
                    String[] aux = b.split(";");
                    String name = aux[0].trim();
                    String email = aux[1].trim();
                    int height = Integer.parseInt(aux[2].trim());
                    int weight = Integer.parseInt(aux[3].trim());
                    double cyclingSpeed = Double.parseDouble(aux[4].trim());
                    double visa = Double.parseDouble(aux[5].trim());
                    char gender = aux[6].trim().charAt(0);
                    String password = aux[7].trim();
                    User aux2 = new User(name, email, password, height, weight, gender, cyclingSpeed, visa, 0);
                    uList.add(aux2);
                }
                if (userController.addUser(uList)) {
                    countUsers = uList.size();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countUsers;
    }

    @Override
    public int addPaths(String s) {
        PathController pathController1 = new PathController();
        ParkController parkController1 = new ParkController();
        PoiController poiController1 = new PoiController();
        List<String> list = Utils.loadCsv(s);
        List<Path> pList = new ArrayList<>();
        int countPaths = 0;
        try {
            if (list != null) {
                for (String p : list) {
                    String[] aux = p.split(";");
                    double latitude1 = Double.parseDouble(aux[0].trim());
                    double longitude1 = Double.parseDouble(aux[1].trim());
                    Place place = parkController1.getParkByCoordinates(latitude1, longitude1);
                    if (place == null) {
                        place = poiController1.getPoiByCoordinates(latitude1, longitude1);
                    }
                    if (place == null) {
                        throw new IllegalArgumentException();
                    }
                    double latitude2 = Double.parseDouble(aux[2].trim());
                    double longitude2 = Double.parseDouble(aux[3].trim());
                    place = parkController1.getParkByCoordinates(latitude2, longitude2);
                    if (place == null) {
                        place = poiController1.getPoiByCoordinates(latitude2, longitude2);
                    }
                    if (place == null) {
                        throw new IllegalArgumentException();
                    }
                    double kineticCoefficient = Double.parseDouble(aux[4].trim());
                    int windDirection = Integer.parseInt(aux[5].trim());
                    double windSpeed = Double.parseDouble(aux[6].trim());
                    Path aux2 = new Path(latitude1, longitude1, latitude2, longitude2, kineticCoefficient, windDirection, windSpeed);
                    pList.add(aux2);
                }
                if (pathController1.addPath(pList)) {
                    countPaths = pList.size();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countPaths;
    }

    @Override
    public int getNumberOfBicyclesAtPark(double parkLatitude, double parkLongitude, String outputFileName) {
        try {
            ParkController parkController = new ParkController();
            StringBuilder str = new StringBuilder();
            List<Bicycle> auxList = parkController.getBicyclesByCords(parkLatitude, parkLongitude);

            str.append("Bicycle Description").append(";").append("Wheel Size").append("\n");

            for (Bicycle bcl : auxList) {
                str.append(bcl.getDescription()).append(";").append(bcl.getWheelSize()).append("\n");
            }

            Utils.writeFile(str.toString(), outputFileName);
            return auxList.size();
        } catch (NullPointerException | IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getNumberOfBicyclesAtPark(String parkID, String outputFileName) {
        try {
            ParkController parkController = new ParkController();
            StringBuilder str = new StringBuilder();
            List<Bicycle> auxList = parkController.getBicyclesByParkID(parkID);

            str.append("Bicycle Description").append(";").append("Wheel Size").append("\n");

            for (Bicycle bcl : auxList) {
                str.append(bcl.getDescription()).append(";").append(bcl.getWheelSize()).append("\n");
            }

            Utils.writeFile(str.toString(), outputFileName);
            return auxList.size();
        } catch (NullPointerException | IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public void getNearestParks(double v, double v1, String s) {
        ParkController parkController1 = new ParkController();
        PoiController poiController1 = new PoiController();
        PathController pathController1 = new PathController();
        GraphController graphController1 = new GraphController();
        List<Park> parks = new ArrayList<>();
        List<Poi> pois = new ArrayList<>();
        List<Place> places = new ArrayList<>();
        List<Path> paths = new ArrayList<>();
        BufferedWriter writer = null;

        List<Park> nearestParks = new ArrayList<>();
        Place place = null;
        try {
            place = parkController1.getParkByCoordinates(v, v1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (place == null) {
            try {
                place = poiController1.getPoiByCoordinates(v, v1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (place != null) {
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            nearestParks = graphController1.getNearestParks(place, 1);
            DistancesComparator c = new DistancesComparator(v, v1, place.getElevation());
            Collections.sort(nearestParks, c);
        }
        try {
            writer = new BufferedWriter(new FileWriter(s));
            writer.write("Latitude;Longitude;Distance in meters");
            writer.newLine();
            writer.write(String.format("%f%f%d", v, v1, 0));
            for (int i = 1; i < nearestParks.size(); i++) {
                double lat = nearestParks.get(i).getLatitude();
                double lon = nearestParks.get(i).getLongitude();
                writer.write(String.format("%f%f%d", lat, lon, Math.round(Distances.distance(v, v1, lat, lon, 0) * 1000)));
                writer.newLine();
            }
        } catch (IOException exx) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, exx);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void getNearestParks(double v, double v1, String s, int i) {
        ParkController parkController1 = new ParkController();
        PoiController poiController1 = new PoiController();
        PathController pathController1 = new PathController();
        GraphController graphController1 = new GraphController();
        List<Park> parks = new ArrayList<>();
        List<Poi> pois = new ArrayList<>();
        List<Place> places = new ArrayList<>();
        List<Path> paths = new ArrayList<>();
        BufferedWriter writer = null;

        List<Park> nearestParks = new ArrayList<>();
        Place place = null;
        try {
            place = parkController1.getParkByCoordinates(v, v1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (place == null) {
            try {
                place = poiController1.getPoiByCoordinates(v, v1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (place != null) {
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            nearestParks = graphController1.getNearestParks(place, i);
            DistancesComparator c = new DistancesComparator(v, v1, place.getElevation());
            Collections.sort(nearestParks, c);
        }
        try {
            writer = new BufferedWriter(new FileWriter(s));
            writer.write("Latitude;Longitude;Distance in meters");
            writer.newLine();
            writer.write(String.format("%f%f%d", v, v1, 0));
            for (int j = 1; j < nearestParks.size(); j++) {
                double lat = nearestParks.get(j).getLatitude();
                double lon = nearestParks.get(j).getLongitude();
                writer.write(String.format("%f%f%d", lat, lon, Math.round(Distances.distance(v, v1, lat, lon, 0) * 1000)));
                writer.newLine();
            }
        } catch (IOException exx) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, exx);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int getFreeBicycleSlotsAtPark(String parkID, String s1) {
        try {
            ParkController parkController = new ParkController();
            return parkController.hasFreeSlotsBicyclesByParkID(parkID);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getFreeEscooterSlotsAtPark(String parkID, String s1) {
        try {
            ParkController parkController = new ParkController();
            return parkController.hasFreeSlotsEScootersByParkID(parkID);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int linearDistanceTo(double v, double v1, double v2, double v3) {
        double distance = 0;
        distance = Distances.distance(v, v1, v2, v3, 0.0);
        return (int) distance * 1000;
    }

    @Override
    public int pathDistanceTo(double v, double v1, double v2, double v3) {
        PoiController poiController1 = new PoiController();
        ParkController parkController1 = new ParkController();
        GraphController graphController1 = new GraphController();
        Place c1 = null;
        try {
            c1 = poiController1.getPoiByCoordinates(v, v1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (c1 == null) {
            try {
                c1 = parkController1.getParkByCoordinates(v, v1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (c1 == null) {
                return 0;
            }
        }
        Place c2 = null;
        try {
            c2 = poiController1.getPoiByCoordinates(v2, v3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (c2 == null) {
            try {
                c2 = parkController1.getParkByCoordinates(v2, v3);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (c2 == null) {
                return 0;
            }
        }
        LinkedList<Place> shortRoute = new LinkedList<>();
        return (int) graphController1.getShortestPathDistance(c1, c2, shortRoute) * 1000;
    }

    @Override
    public long unlockBicycle(String s, String s1) {
        RentController rentController = new RentController();

        try {
            String id = "";

            int idAux = (rentController.getNumberOfRents() + 1);
            if (Utils.lengthOfANum(idAux) > 1) {
                id = "R" + idAux;
            } else {
                id = "R0" + idAux;
            }

            if (rentController.addRentB(id, s, s1)) {
                return rentController.getRentMilisseconds(id);
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long unlockEscooter(String s, String s1) {
        RentController rentController = new RentController();

        try {
            String id = "";

            int idAux = (rentController.getNumberOfRents() + 1);
            if (Utils.lengthOfANum(idAux) > 1) {
                id = "R" + idAux;
            } else {
                id = "R0" + idAux;
            }

            if (rentController.addRentE(id, s, s1)) {
                return rentController.getRentMilisseconds(id);
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long unlockAnyEscooterAtPark(String string, String string1, String string2) {
        EScooterController escooterController = new EScooterController();
        RentController rentController = new RentController();
        try {
            String id = "";

            String idVehicle = escooterController.getHighestBatteryScooter(string).getDescription();
            int idAux = (rentController.getNumberOfRents() + 1);
            if (Utils.lengthOfANum(idAux) > 1) {
                id = "R" + idAux;
            } else {
                id = "R0" + idAux;
            }

            rentController.addRentE(id, string1, idVehicle);
            return rentController.getRentMilisseconds(id);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long lockBicycle(String bikeDisc, double v, double v1, String username) {
        ParkController parkController = new ParkController();
        RentController rentController = new RentController();
        try {
            Place initialPark = rentController.getParkByRent(username);

            Place endPark = parkController.getParkByCoordinates(v, v1);

            double distance = Distances.distance(initialPark.getLatitude(), initialPark.getLongitude(), endPark.getLatitude(),
                    endPark.getLongitude(), endPark.getElevation() - initialPark.getElevation());

            String rentId = rentController.getRentByUsername(username);
            rentController.lockVehicleB(bikeDisc, username, endPark.getId(), distance);
            return rentController.getRentUpdateMilisseconds(rentId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long lockBicycle(String s, String s1, String s2) {
        ParkController parkController = new ParkController();
        RentController rentController = new RentController();
        try {
            Place initialPark = rentController.getParkByRent(s2);

            Place endPark = parkController.getPark(s1);

            double distance = Distances.distance(initialPark.getLatitude(), initialPark.getLongitude(), endPark.getLatitude(),
                    endPark.getLongitude(), endPark.getElevation() - initialPark.getElevation());

            String rentId = rentController.getRentByUsername(s2);
            rentController.lockVehicleB(s, s2, endPark.getId(), distance);
            return rentController.getRentUpdateMilisseconds(rentId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long lockEscooter(String s, double v, double v1, String s1) {
        ParkController parkController = new ParkController();
        RentController rentController = new RentController();
        try {
            Place initialPark = rentController.getParkByRent(s1);

            Place endPark = parkController.getParkByCoordinates(v, v1);

            double distance = Distances.distance(initialPark.getLatitude(), initialPark.getLongitude(), endPark.getLatitude(),
                    endPark.getLongitude(), endPark.getElevation() - initialPark.getElevation());

            String rentId = rentController.getRentByUsername(s1);
            rentController.lockVehicleE(s, s1, endPark.getId(), distance);
            return rentController.getRentUpdateMilisseconds(rentId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long lockEscooter(String s, String s1, String s2) {
        ParkController parkController = new ParkController();
        RentController rentController = new RentController();
        try {
            Place initialPark = rentController.getParkByRent(s2);

            Place endPark = parkController.getPark(s1);

            double distance = Distances.distance(initialPark.getLatitude(), initialPark.getLongitude(), endPark.getLatitude(),
                    endPark.getLongitude(), endPark.getElevation() - initialPark.getElevation());

            String rentId = rentController.getRentByUsername(s2);
            rentController.lockVehicleE(s, s2, endPark.getId(), distance);
            return rentController.getRentUpdateMilisseconds(rentId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int suggestEscootersToGoFromOneParkToAnother(String s, String s1, double v, double v1, String s2) {
        ParkController pc = new ParkController();
        EScooterController esc = new EScooterController();

        Park actual = null; //actual park
        try {
            actual = pc.getPark(s);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Park destination = null; //destination park
        try {
            destination = pc.getParkByCoordinates(v, v1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            return esc.suggestEscootersToGoFromOneParkToAnother(actual, destination, s1, s2); //number of suggested escooters
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public long mostEnergyEfficientRouteBetweenTwoParks(String s, String s1, String s2, String s3, String s4, String s5) {
        double energy = 0;
        try {
            ParkController parkController1 = new ParkController();
            UserController userController1 = new UserController();
            GraphController graphController1 = new GraphController();
            PathController pathController1 = new PathController();
            PoiController poiController1 = new PoiController();
            EScooterController escooterController1 = new EScooterController();
            Park p1 = parkController1.getPark(s);
            Park p2 = parkController1.getPark(s1);
            LinkedList<Place> shortRoute = new LinkedList<>();
            double totalDistance = 0;
            if (p1 != null && p2 != null) {
                List<Park> parks = new ArrayList<>();
                List<Poi> pois = new ArrayList<>();
                List<Place> places = new ArrayList<>();
                List<Path> paths = new ArrayList<>();
                paths = pathController1.getAllPaths();
                parks = parkController1.getAllParks();
                pois = poiController1.getAllPois();
                places.addAll(parks);
                places.addAll(pois);
                graphController1.fillGraph(places, paths);
                if (s2.equalsIgnoreCase("bicycle")) {
                    totalDistance = graphController1.getShortestPathDistance(p1, p2, shortRoute);
                    energy = userController1.getEnergyWithBicycle(s4, totalDistance);
                } else {
                    if (s2.equalsIgnoreCase("escooter")) {
                        totalDistance = graphController1.getShortestPathDistance(p1, p2, shortRoute);
                        List<EScooter> escooters = escooterController1.getAllEScooters();
                        energy = escooterController1.getEnergyWithEScooters(escooters, totalDistance);
                    }
                }
                LinkedList<LinkedList<Place>> paths1 = new LinkedList<>();
                paths1.add(shortRoute);
                graphController1.writePathsFile(0, paths1, s5, p2.getElevation() - p1.getElevation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (long) energy;
    }

    @Override
    public int getNumberOfEscootersAtPark(double latitudePark, double longitudePark, String outputFileName) {
        try {
            ParkController parkController = new ParkController();
            StringBuilder str = new StringBuilder();
            List<EScooter> auxList = parkController.getEScootersByParkCoords(latitudePark, longitudePark);
            str.append("EScooter Description").append(";").append("EScooter Type").append(";").append("Actual Battery").append("\n");
            for (EScooter es1 : auxList) {
                str.append(es1.getDescription()).append(";").append(es1.getEsType()).append(";").append(es1.getActualBatteryCapacity()).append("\n");
            }
            Utils.writeFile(str.toString(), outputFileName);
            return auxList.size();
        } catch (NullPointerException | IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getNumberOfEScootersAtPark(String parkID, String outputFileName) {
        try {
            ParkController parkController = new ParkController();
            StringBuilder str = new StringBuilder();
            List<EScooter> auxList = parkController.getEScootersByParkID(parkID);
            str.append("EScooter Description").append(";").append("EScooter Type").append(";").append("Actual Battery").append("\n");
            for (EScooter es1 : auxList) {
                str.append(es1.getDescription()).append(";").append(es1.getEsType()).append(";").append(es1.getActualBatteryCapacity()).append("\n");
            }
            Utils.writeFile(str.toString(), parkID);
            return auxList.size();
        } catch (NullPointerException | IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getFreeSlotsAtParkForMyLoanedVehicle(String parkID, String username) {
        try {
            ParkController parkController = new ParkController();
            return parkController.hasFreeSlotsLoanedVehicle(parkID, username);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public long unlockAnyEscooterAtParkForDestination(String parkId, String username, double lati, double longi, String outputFile) {
        ParkController parkController = new ParkController();
        EScooterController escooterController = new EScooterController();
        RentController rentController = new RentController();
        try {
            Place initialPark = parkController.getPark(parkId);
            System.out.println(initialPark.getDescription());
            Place endPark = parkController.getParkByCoordinates(lati, longi);
            System.out.println(endPark.getDescription());
            double energyCost = Distances.calculateCost(initialPark, endPark, 250);
            System.out.println(energyCost);
            List<EScooter> listEscooters = escooterController.getEScooterForEnergy(initialPark.getId(), energyCost);

            String id = "";
            EScooter aux = listEscooters.get(0);
            int idAux = (rentController.getNumberOfRents() + 1);
            if (Utils.lengthOfANum(idAux) > 1) {
                id = "R" + idAux;
            } else {
                id = "R0" + idAux;
            }

            if (rentController.addRent(id, username, aux.getDescription())) {
                FileWriter writer1 = new FileWriter(outputFile);
                BufferedWriter writer = new BufferedWriter(writer1);
                writer.write("EScooter description;type;actual battery capacity");
                writer.newLine();
                writer.write(aux.getDescription() + ";" + aux.getEsType() + ";" + aux.getActualBatteryCapacity());
                writer.close();
                writer1.close();
            }
            return rentController.getRentMilisseconds(id);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double getUserCurrentDebt(String string, String string1) {
        RentController rentController = new RentController();
        UserController userController = new UserController();
        try {
            ArrayList<String> invoice = rentController.getAllRentsByUsername(string);

            if (invoice.size() != 0) {
                FileWriter writer1 = null;
                BufferedWriter writer = null;
                try {
                    writer1 = new FileWriter(string1);
                    writer = new BufferedWriter(writer1);
                    writer.write("vehice description;vehicle unlock time;vehicle lock time;origin park id;destination park id;total time spent in seconds;charged value");
                    writer.newLine();
                    for (String s : invoice) {
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                    writer1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return userController.getCurrentDebt(string);
        } catch (NumberFormatException | SQLException e) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public double getUserCurrentPoints(String username, String outputFile) {
        UserController userController = new UserController();
        RentController rentController = new RentController();
        double currentPoints = 0;
        FileWriter writer1 = null;
        BufferedWriter writer = null;
        try {
            currentPoints = userController.getCurrentPoints(username);
            ArrayList<String> rents = rentController.getAllRentsAndPointsByUsername(username);
            if (rents.size() != 0) {
                try {
                    writer1 = new FileWriter(outputFile);
                    writer = new BufferedWriter(writer1);
                    writer.write("vehice description;vehicle unlock time;vehicle lock time;origin park id;destination park id;points");
                    for (String s : rents) {
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                    writer1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return currentPoints;
        }
    }

    @Override
    public double calculateElectricalEnergyToTravelFromOneLocationToAnother(double d, double d1, double d2, double d3, String string) {
        try {
            ParkController parkController1 = new ParkController();
            PoiController poiController1 = new PoiController();
            Place p1 = parkController1.getParkByCoordinates(d, d1);
            Place p2 = parkController1.getParkByCoordinates(d2, d3);
            if (p1 == null) {
                p1 = poiController1.getPoiByCoordinates(d, d1);
            }
            if (p2 == null) {
                p2 = poiController1.getPoiByCoordinates(d2, d3);
            }
            if (p1 != null && p2 != null) {
                int motor = 250;
                return Distances.calculateCost(p1, p2, 250);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long forHowLongAVehicleIsUnlocked(String vehicleID) {
        try {
            RentController rentController = new RentController();
            return rentController.forHowLongAVehicleIsUnlocked(vehicleID);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public long shortestRouteBetweenTwoParksForGivenPOIs(String string, String string1, String string2, String string3) {
        double distance = 0;
        try {
            ParkController parkController1 = new ParkController();
            PathController pathController1 = new PathController();
            PoiController poiController1 = new PoiController();
            GraphController graphController1 = new GraphController();
            Park p1 = parkController1.getPark(string);
            Park p2 = parkController1.getPark(string1);
            if (p1 == null || p2 == null) {
                return (long) distance;
            }
            List<Park> parks = new ArrayList<>();
            List<Poi> pois = new ArrayList<>();
            List<Place> places = new ArrayList<>();
            List<Path> paths = new ArrayList<>();
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            List<String> list = Utils.loadCsv(string2);
            List<Place> pList = new ArrayList<>();
            if (list != null) {
                for (String p : list) {
                    String[] aux = p.split(";");
                    double latitude = Double.parseDouble(aux[0].trim());
                    double longitude = Double.parseDouble(aux[1].trim());
                    Poi aux2 = poiController1.getPoiByCoordinates(latitude, longitude);
                    pList.add(aux2);
                }
                List<Place> shortRoute = new ArrayList<>();
                distance = graphController1.getShortestPathPassingThroughtPlacesDistance(p1, p2, pList, shortRoute);
                LinkedList<LinkedList<Place>> paths1 = new LinkedList<>();
                paths1.add((LinkedList<Place>) shortRoute);
                graphController1.writePathsFile(0, paths1, string3, p2.getElevation() - p1.getElevation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (long) distance * 1000;
    }

    @Override
    public long shortestRouteBetweenTwoParksForGivenPOIs(double d, double d1, double d2, double d3, String string, String string1) {
        double distance = 0;
        try {
            ParkController parkController1 = new ParkController();
            PathController pathController1 = new PathController();
            PoiController poiController1 = new PoiController();
            GraphController graphController1 = new GraphController();
            Park p1 = parkController1.getParkByCoordinates(d, d1);
            Park p2 = parkController1.getParkByCoordinates(d2, d3);
            if (p1 == null || p2 == null) {
                return (long) distance;
            }
            List<Park> parks = new ArrayList<>();
            List<Poi> pois = new ArrayList<>();
            List<Place> places = new ArrayList<>();
            List<Path> paths = new ArrayList<>();
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            List<String> list = Utils.loadCsv(string);
            List<Place> pList = new ArrayList<>();
            if (list != null) {
                for (String p : list) {
                    String[] aux = p.split(";");
                    double latitude = Double.parseDouble(aux[0].trim());
                    double longitude = Double.parseDouble(aux[1].trim());
                    Poi aux2 = poiController1.getPoiByCoordinates(latitude, longitude);
                    pList.add(aux2);
                }
                List<Place> shortRoute = new ArrayList<>();
                distance = graphController1.getShortestPathPassingThroughtPlacesDistance(p1, p2, pList, shortRoute);
                LinkedList<LinkedList<Place>> paths1 = new LinkedList<>();
                paths1.add((LinkedList<Place>) shortRoute);
                graphController1.writePathsFile(0, paths1, string1, p2.getElevation() - p1.getElevation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (long) distance * 1000;
    }

    @Override
    public long getParkChargingReport(String parkID, String outputFileName) {
        try {
            ParkController parkController = new ParkController();
            Map<EScooter, Double> auxHashMap = parkController.getChargingEScootersByParkID(parkID);
            StringBuilder contentDisplay = new StringBuilder();
            contentDisplay.append("EScooter Description").append(";").append("Actual Battery").append(";").append("Time to Full Charge In Seconds").append("\n");

            for (EScooter eS : auxHashMap.keySet()) {
                if (eS != null) {
                    if (eS.getActualBatteryCapacity() < eS.getMaxBatteryCapacity()) {
                        contentDisplay.append(eS.getDescription()).append(";").append(eS.getActualBatteryCapacity()).append(";").append(auxHashMap.get(eS)).append("\n");
                    }
                }
            }
            Utils.writeFile(contentDisplay.toString(), outputFileName);
            return auxHashMap.size();
        } catch (NullPointerException | IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int suggestRoutesBetweenTwoLocations(String string, String string1, String string2, String string3, String string4, int i, boolean bln,
                                                String string5, String string6, String string7) {
        GraphController graphController = new GraphController();
        ParkController parkController = new ParkController();
        PathController pathController = new PathController();
        PoiController poiController = new PoiController();
        int maxNumberOfSuggestions = 0;
        try {
            Park originPark = parkController.getPark(string);
            Park destinationPark = parkController.getPark(string1);
            int elevation = destinationPark.getElevation() - originPark.getElevation();
            ArrayList<Place> inputPois = (ArrayList<Place>) graphController.getInputPOIs(string6);
            List<LinkedList<Place>> paths = new ArrayList<>();
            LinkedList<Place> path = new LinkedList<>();
            path.push(originPark);
            List<Park> parks = new ArrayList<>();
            List<Poi> pois = new ArrayList<>();
            List<Place> places = new ArrayList<>();
            List<Path> paths1 = new ArrayList<>();
            paths1 = pathController.getAllPaths();
            parks = parkController.getAllParks();
            pois = poiController.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController.fillGraph(places, paths1);
            graphController.allPaths(originPark, destinationPark, path, paths, inputPois);

            if (graphController.sortPaths(string5, bln, paths)) {
                return 0;
            }
            return graphController.writePathsFile(i, paths, string7, elevation);

        } catch (IOException | SQLException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxNumberOfSuggestions;
    }

    @Override
    public long shortestRouteBetweenTwoParks(double d, double d1, double d2, double d3, int i, String string) {
        double distance = 0;
        try {
            ParkController parkController1 = new ParkController();
            PathController pathController1 = new PathController();
            PoiController poiController1 = new PoiController();
            GraphController graphController1 = new GraphController();
            Park p1 = parkController1.getParkByCoordinates(d, d1);
            Park p2 = parkController1.getParkByCoordinates(d2, d3);
            if (p1 == null || p2 == null) {
                return (long) distance;
            }
            List<Park> parks = new ArrayList<>();
            List<Poi> pois = new ArrayList<>();
            List<Place> places = new ArrayList<>();
            List<Path> paths = new ArrayList<>();
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            LinkedList<Place> shortRoute = new LinkedList<>();
            distance = graphController1.getShortestPathDistance(p1, p2, shortRoute);
            LinkedList<LinkedList<Place>> paths1 = new LinkedList<>();
            paths1.add((LinkedList<Place>) shortRoute);
            graphController1.writePathsFile(0, paths1, string, p2.getElevation() - p1.getElevation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (long) distance * 1000;
    }

    @Override
    public long shortestRouteBetweenTwoParks(String string, String string1, int i, String string2) {
        double distance = 0;
        try {
            ParkController parkController1 = new ParkController();
            PathController pathController1 = new PathController();
            PoiController poiController1 = new PoiController();
            GraphController graphController1 = new GraphController();
            Park p1 = parkController1.getPark(string);
            Park p2 = parkController1.getPark(string);
            if (p1 == null || p2 == null) {
                return (long) distance;
            }
            List<Park> parks = new ArrayList<>();
            List<Poi> pois = new ArrayList<>();
            List<Place> places = new ArrayList<>();
            List<Path> paths = new ArrayList<>();
            paths = pathController1.getAllPaths();
            parks = parkController1.getAllParks();
            pois = poiController1.getAllPois();
            places.addAll(parks);
            places.addAll(pois);
            graphController1.fillGraph(places, paths);
            LinkedList<Place> shortRoute = new LinkedList<>();
            distance = graphController1.getShortestPathDistance(p1, p2, shortRoute);
            LinkedList<LinkedList<Place>> paths1 = new LinkedList<>();
            paths1.add((LinkedList<Place>) shortRoute);
            graphController1.writePathsFile(0, paths1, string, p2.getElevation() - p1.getElevation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (long) distance * 1000;
    }

    @Override
    public int registerUser(String name, String email, String pass, String visa, int i, int i1, BigDecimal bd, String gend) {
        UserController userController = new UserController();
        try {
            User aux2 = new User(name, email, pass, i, i1, gend.charAt(0), bd.doubleValue(), Double.parseDouble(visa), 0);
            if (userController.addUser(aux2)) {
                return 1;
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getInvoiceForMonth(int month, String username, String outputfile) {
        UserController userController = new UserController();
        RentController rentController = new RentController();
        double cost = 0;
        int monthAux = 0;
        try {
            ArrayList<String> invoice = rentController.getAllRentsByUsername(username);
            cost = userController.getCurrentDebt(username);
            if (month == 1) {
                monthAux = 12;
            } else {
                monthAux = month - 1;
            }
            if (invoice.size() != 0) {
                FileWriter writer1 = null;
                BufferedWriter writer = null;
                try {
                    writer1 = new FileWriter(outputfile);
                    writer = new BufferedWriter(writer1);
                    writer.write(username);
                    writer.newLine();
                    writer.write("Previous points: " + userController.getPointsForMonth(monthAux, username));
                    writer.newLine();
                    writer.write("Earned points: " + userController.getPointsForMonth(month, username));
                    writer.newLine();
                    writer.write("Discounted points: " + 0);
                    writer.newLine();
                    writer.write("Actual points: " + rentController.getTotalPoints(username));
                    writer.newLine();
                    writer.write("Charged Value: " + cost);
                    writer.newLine();
                    writer.write("vehice description;vehicle unlock time;vehicle lock time;origin park id;destination park id;total time spent in seconds;charged value");
                    writer.newLine();
                    for (String s : invoice) {

                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                    writer1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return cost;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return cost;
        }
    }

    public void cleanAndSet() throws IOException, SQLException {
        DataHandler dh = new DataHandler();
        dh.scriptRunner("target/classes/script_cleaner.sql");
    }

    public boolean sendEmail(String dEmail, String subject, String body) {
        EmailHandler eh = new EmailHandler();
        return eh.sendEmail(dEmail, subject, body);
    }
}
