package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import lapr.project.model.Bicycle;
import lapr.project.model.EScooter;
import lapr.project.model.Park;
import lapr.project.model.Path;
import oracle.jdbc.OracleTypes;

public class ParkDB extends DataHandler {

    public static Park callGetPark(String identifier, CallableStatement callStmt) throws SQLException {
        callStmt.registerOutParameter(1, OracleTypes.CURSOR); //standard para o output

        callStmt.setString(2, identifier);

        callStmt.execute();

        ResultSet rSet = (ResultSet) callStmt.getObject(1);

        return elaboratePark(rSet);
    }

    private static Park elaboratePark(ResultSet rSet) throws SQLException {
        if (rSet.next()) {
            String pID = rSet.getString(1);
            double pLatitude = rSet.getDouble(2);
            double pLongitude = rSet.getDouble(3);
            int elevation = rSet.getInt(4);
            String pDescription = rSet.getString(5);
            int maxNumberBicycles = rSet.getInt(6);
            int maxNumberEScooters = rSet.getInt(7);
            double inputVoltage = rSet.getDouble(8);
            double inputCurrent = rSet.getDouble(9);

            return new Park(pID, pLatitude, pLongitude, elevation, pDescription, maxNumberBicycles, maxNumberEScooters, inputVoltage, inputCurrent);
        }
        return null;
    }

    public boolean addPark(List<Park> list) throws SQLException {
        boolean check = true;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (Park p : list) {
                if (!addPark(p.getId(), p.getLatitude(), p.getLongitude(), p.getElevation(), p.getDescription(), p.getMaxNumberBicycles(), p.getMaxNumberEScooters(), p.getInputVoltage(), p.getInputCurrent())) {
                    check = false;
                    throw new SQLException();
                }
            }
            con.commit();
            return check;
        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                con.rollback();
                con.setAutoCommit(true);
            }
            closeAll();
            return check;
        }
    }

    public boolean addPark(Park park) throws SQLException {
        openConnection();
        try {
            return addPark(park.getId(), park.getLatitude(), park.getLongitude(), park.getElevation(), park.getDescription(), park.getMaxNumberBicycles(), park.getMaxNumberEScooters(), park.getInputVoltage(), park.getInputCurrent());
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            closeAll();
            return false;
        }
    }

    private boolean addPark(String parkID, double latitude, double longitude, int elevation, String parkDescription, int maxNumberBicycles, int maxNumberEScooters, double inputVoltage, double inputCurrent) throws SQLException {
        CallableStatement callStmt = null;
        try {

            callStmt = getConnection().prepareCall("{ call addPark(?,?,?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, parkID);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);
            callStmt.setInt(4, elevation);
            callStmt.setString(5, parkDescription);
            callStmt.setInt(6, maxNumberBicycles);
            callStmt.setInt(7, maxNumberEScooters);
            callStmt.setInt(8, 0);
            callStmt.setInt(9, 0);
            callStmt.setDouble(10, inputVoltage);
            callStmt.setDouble(11, inputCurrent);

            callStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        return false;
    }

    public void updatePark(Park p) throws SQLException {
        updatePark(p.getId(), p.getLatitude(), p.getLongitude(), p.getElevation(), p.getDescription(), p.getMaxNumberBicycles(), p.getMaxNumberEScooters(), p.getInputVoltage(), p.getInputCurrent());
    }

    private void updatePark(String parkID, double latitude, double longitude, int elevation, String parkDescription, int maxNumberBicycles, int maxNumberEScooters, double inputVoltage, double inputCurrent) throws SQLException {
        CallableStatement callStmt = null;
        try {
            openConnection();

            callStmt = getConnection().prepareCall("{ call updatePark(?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, parkID);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);
            callStmt.setInt(4, elevation);
            callStmt.setString(5, parkDescription);
            callStmt.setInt(6, maxNumberBicycles);
            callStmt.setInt(7, maxNumberEScooters);
            callStmt.setDouble(8, inputVoltage);
            callStmt.setDouble(9, inputCurrent);

            callStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
        }
    }

    public int getMaxNumberOfBicyclesByParkCoords(double latitude, double longitude) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (latitude == 0 || longitude == 0) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call getMaxNumberOfBicyclesByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getMaxNumberOfBicyclesByParkCoords".
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);

            // Executa a invocação da função "getMaxNumberOfBicyclesByParkCoords".
            callStmt.execute();

            // Guarda o valor retornado num inteiro "maxNumberOfBicycles".
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int getMaxNumberOfBicyclesByParkID(String parkID) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call getMaxNumberOfBicyclesByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getMaxNumberOfBicyclesByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "getMaxNumberOfBicyclesByParkID".
            callStmt.execute();

            // Guarda o valor retornado num inteiro "maxNumberOfBicycles".
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int getMaxNumberOfEScootersByParkCoords(double latitude, double longitude) throws SQLException {
        CallableStatement callStmt = null;
        try {
            
            if(latitude == 0 || longitude == 0) {
                return 0;
            }
            
            callStmt = getConnection().prepareCall("{ ? = call getMaxNumberOfEScootersByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getMaxNumberOfEScootersByParkCoords".
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);

            // Executa a invocação da função "getMaxNumberOfEScootersByParkCoords".
            callStmt.execute();

            // Guarda o valor retornado num inteiro "maxNumberOfEScooters".
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int getMaxNumberOfScooters(String parkID) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call getMaxNumberOfEScootersByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getMaxNumberOfEScootersByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "getMaxNumberOfEScootersByParkID".
            callStmt.execute();

            // Guarda o valor retornado num inteiro "maxNumberOfEScooters".
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int hasFreeSlotsBicyclesByParkCords(double parkLatitude, double parkLongitude) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkLatitude == 0 || parkLongitude == 0) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call hasFreeSlotsBicyclesByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            // Especifica o parâmetro de entrada da função "hasFreeSlotsBicyclesByParkCoords".
            callStmt.setDouble(2, parkLatitude);
            callStmt.setDouble(3, parkLongitude);

            // Executa a invocação da função "hasFreeSlotsBicyclesByParkCoords".
            callStmt.execute();

            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int hasFreeSlotsBicyclesByParkID(String parkID) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call hasFreeSlotsBicyclesByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            // Especifica o parâmetro de entrada da função "hasFreeSlotsBicyclesByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "hasFreeSlotsBicyclesByParkID".
            callStmt.execute();

            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public Park getPark(String parkID) throws SQLException {

        CallableStatement callStmt = null;
        Park p = null;

        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkById(?) }");
            p = callGetPark(parkID, callStmt);
        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("No Park with ID:" + parkID);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return p;
        }
    }

    public int hasFreeSlotsEScootersByParkID(String parkID) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call hasFreeSlotsEScootersByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            // Especifica o parâmetro de entrada da função "hasFreeSlotsEScootersByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "hasFreeSlotsEScootersByParkID".
            callStmt.execute();

            // Guarda o cursor retornado num integer.
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int hasFreeSlotsLoanedVehicle(String parkID, String username) throws SQLException {
        CallableStatement callStmt = null;
        try {
            if (parkID == null || username == null || parkID.isEmpty() || username.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call hasFreeSlotsLoanedVehicle(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            // Especifica o parâmetro de entrada da função "hasFreeSlotsLoanedVehicle".
            callStmt.setString(2, parkID);
            callStmt.setString(3, username);

            // Executa a invocação da função "hasFreeSlotsLoanedVehicle".
            callStmt.execute();

            // Guarda o cursor retornado num integer.
            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public List<Bicycle> getBicyclesByParkCoords(double latitudePark, double longitudePark) throws SQLException {
        List<Bicycle> contentList = new ArrayList<>();
        CallableStatement callStmt = null;
        try {

            if (latitudePark == 0 || longitudePark == 0) {
                return new ArrayList<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getBicyclesByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getBicyclesByParkCoords".
            callStmt.setDouble(2, latitudePark);
            callStmt.setDouble(3, longitudePark);

            // Executa a invocação da função "getBicyclesByParkCoords".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String bicycleDescription = rSet.getString(1);
                int weight = rSet.getInt(2);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                double aero = rSet.getDouble(5);
                double fontal = rSet.getDouble(6);
                int wheelSize = rSet.getInt(7);

                contentList.add(new Bicycle(bicycleDescription, weight, parkLatitude, parkLongitude, aero, fontal, wheelSize));
            }
            return contentList;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public List<Bicycle> getBicyclesByParkID(String parkID) throws SQLException {
        List<Bicycle> contentList = new ArrayList<>();
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return new ArrayList<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getBicyclesByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getBicyclesByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "getBicyclesByParkID".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String bicycleDescription = rSet.getString(1);
                int weight = rSet.getInt(2);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                double aero = rSet.getDouble(5);
                double fontal = rSet.getDouble(6);
                int wheelSize = rSet.getInt(7);

                contentList.add(new Bicycle(bicycleDescription, weight, parkLatitude, parkLongitude, aero, fontal, wheelSize));
            }
            return contentList;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public List<EScooter> getEScootersByParkCoords(double latitudePark, double longitudePark) throws SQLException {
        List<EScooter> contentList = new ArrayList<>();
        CallableStatement callStmt = null;
        try {

            if (latitudePark == 0 || longitudePark == 0) {
                return new ArrayList<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getEScootersByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Especifica o parâmetro de entrada da função "getEScootersByParkCoords".
            callStmt.setDouble(2, latitudePark);
            callStmt.setDouble(3, longitudePark);

            // Executa a invocação da função "getEScootersByParkCoords".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String description = rSet.getString(1);
                int weight = rSet.getInt(2);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                double aerodynamicCoefficient = rSet.getDouble(5);
                double frontalArea = rSet.getDouble(6);
                String esType = rSet.getString(7);
                int maxBatteryCapacity = rSet.getInt(8);
                int actualBatteryCapacity = rSet.getInt(9);
                int motor = rSet.getInt(10);

                contentList.add(new EScooter(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor));
            }
            return contentList;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public List<EScooter> getEScootersByParkID(String parkID) throws SQLException {
        List<EScooter> contentList = new ArrayList<>();
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return new ArrayList<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getEScootersByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Especifica o parâmetro de entrada da função "getEScootersByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "getEScootersByParkID".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String description = rSet.getString(1);
                int weight = rSet.getInt(2);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                double aerodynamicCoefficient = rSet.getDouble(5);
                double frontalArea = rSet.getDouble(6);
                String esType = rSet.getString(7);
                int maxBatteryCapacity = rSet.getInt(8);
                int actualBatteryCapacity = rSet.getInt(9);
                int motor = rSet.getInt(10);

                contentList.add(new EScooter(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor));
            }
            return contentList;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public Map<EScooter, Double> getChargingEScootersByParkID(String parkID) throws SQLException {
        Map<EScooter, Double> contentList = new HashMap<>();
        CallableStatement callStmt = null;
        try {

            if (parkID == null || parkID.isEmpty()) {
                return new HashMap<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getChargingEScootersByParkID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Especifica o parâmetro de entrada da função "getChargingEScootersByParkID".
            callStmt.setString(2, parkID);

            // Executa a invocação da função "getChargingEScootersByParkID".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String description = rSet.getString(1);
                int weight = rSet.getInt(2);
                double latitude = rSet.getDouble(3);
                double longitude = rSet.getDouble(4);
                double aero = rSet.getDouble(5);
                double frontal = rSet.getDouble(6);
                String eStype = rSet.getString(7);
                int maxBattery = rSet.getInt(8);
                int actualBattery = rSet.getInt(9);
                int motor = rSet.getInt(10);
                double timeToFullCharge = rSet.getDouble(11);

                contentList.put(new EScooter(description, weight, latitude, longitude, aero, frontal, eStype, maxBattery, actualBattery, motor), timeToFullCharge);
            }
            return contentList;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new HashMap<>();

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean removePark(Park p) throws SQLException {
        CallableStatement callStmt = null;
        boolean check = false;
        try {
            if (super.getConnection() == null) {
                openConnection();
            }

            if (p == null) {
                return false;
            }

            callStmt = getConnection().prepareCall("{ call removePark(?) }");

            callStmt.setString(1, p.getId());

            callStmt.execute();

            callStmt.execute();

            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            if (super.getConnection() != null) {
                super.closeAll();
            }
            return check;
        }
    }

    public Park getPark(double latitude, double longitude) throws SQLException {

        CallableStatement callStmt = null;
        Park p = null;

        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = getConnection().prepareCall("{ ? = call getParkByCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getParkByCoordenates".
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);

            // Executa a invocação da função "getParkByCoordenates".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            p = elaboratePark(rSet);

        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("No Park with latitude:" + latitude + ", longitude:" + longitude);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            if (super.getConnection() != null) {
                closeAll();
            }
            return p;
        }

    }

    public int hasFreeSlotsEScootersByParkCoords(double parkLatitude, double parkLongitude) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (parkLatitude <= 0 || parkLongitude <= 0) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call hasFreeSlotsEScootersByParkCoords(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            // Especifica o parâmetro de entrada da função "hasFreeSlotsEScootersByParkCoords".
            callStmt.setDouble(2, parkLatitude);
            callStmt.setDouble(3, parkLongitude);

            // Executa a invocação da função "hasFreeSlotsEScootersByParkCoords".
            callStmt.execute();

            return callStmt.getInt(1);
        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }
    
    public List<Park> getAllParks() {
        ArrayList<Park> parks = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            openConnection();

            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT id_park FROM Park");

            while (rs.next()) {
                parks.add(getPark(rs.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            closeAll();
        }
        return parks;
    }
}
