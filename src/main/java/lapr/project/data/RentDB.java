package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import lapr.project.model.EScooter;
import lapr.project.model.Park;
import lapr.project.model.Place;
import lapr.project.model.Rent;
import lapr.project.model.User;
import lapr.project.model.Vehicle;
import oracle.jdbc.OracleTypes;

public class RentDB extends DataHandler {

    public Rent getRent(int request_code) {

        /* Objeto "callStmt" para invocar a função "getSailor" armazenada na BD.
         *
         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUser(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setInt(2, request_code);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            User auxU = null;
            if (rSet.next()) {
                //Rent(request_code
                String userUsername = rSet.getString(1);
                String userEmail = rSet.getString(2);
                int userHeight = rSet.getInt(3);
                int userWeight = rSet.getInt(4);
                double userCyclingAvgSpeed = rSet.getDouble(5);
                double userVisaCardNumber = rSet.getDouble(6);
                char userGender = rSet.getString(7).charAt(0);
                String userPassword = rSet.getString(8);

                // auxU = new User(userUsername, userEmail,  userHeight, userWeight, userCyclingAvgSpeed, userVisaCardNumber, userGender, userPassword);
            }
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeAll();
        }
        throw new IllegalArgumentException("No User with username:" + request_code);
    }

    public long addRent(Rent rent) throws SQLException {
        return addRent(rent.getRequestCode(), rent.getUser(), rent.getVehicle(), rent.getInitialPark());
    }

    public long addRent(String request_code, User user, Vehicle vehicle, Park initialPark) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (request_code == null || request_code.isEmpty() || user == null || vehicle == null || initialPark == null) {
                return 0;
            }

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call addRent(?,?,?,?) }");

            callStmt.setString(1, request_code);
            callStmt.setString(2, vehicle.getDescription());
            callStmt.setString(3, user.getEmail());
            callStmt.setString(4, initialPark.getId());

            callStmt.execute();

            long milisseconds = (long) callStmt.getObject(1);
            return milisseconds;

        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int getNumberOfRents() throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }


            callStmt = getConnection().prepareCall("{ ? = call getNumberOfRents() }");
            callStmt.registerOutParameter(1, OracleTypes.INTEGER); //standard para o output

            callStmt.execute();


            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }

    }

    public Park getParkByVehicle(String bikeDisc) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (bikeDisc == null || bikeDisc.isEmpty()) {
                return null;
            }

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{  ? =  call getParkByVehicle(?) }");

            return ParkDB.callGetPark(bikeDisc, callStmt);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Park found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }

    }

    public boolean lockVehicle(Place endPark, String username, double distance) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call updateRent(?,?,?,?) }");

            callStmt.setString(1, username);
            callStmt.setString(2, endPark.getId());
            callStmt.setDouble(3, distance);

            callStmt.execute();
            return true;

        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public String getRentByUsername(String username) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getRentByUsername(?) }");
            callStmt.registerOutParameter(1, OracleTypes.VARCHAR); //standard para o output

            callStmt.setString(2, username);

            callStmt.execute();

            return callStmt.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        throw new IllegalArgumentException("No rent found");
    }

    public Date getDateByRentId(String rentId) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call getDateByRentId(?) }");

            callStmt.setString(1, rentId);

            callStmt.execute();

            return callStmt.getDate(1);

        } catch (SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public long getTimestampInMiliseconds(Date endDate) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call getTimestampInMiliseconds(?) }");

            callStmt.setDate(1, endDate);

            callStmt.execute();

            return callStmt.getLong(1);

        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public ArrayList<String> getAllRentsByEmail(String userEmail) throws SQLException {
        ArrayList<String> rents = new ArrayList<>();
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {

            if (userEmail == null || userEmail.isEmpty()) {
                return new ArrayList<>();
            }

            callStmt = getConnection().prepareCall("{ ? = call getAllRentsByEmail(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, userEmail);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            rs = (ResultSet) callStmt.getObject(1);

            while (rs.next()) {
                int id_rent = rs.getInt(1);
                String user_email = rs.getString(2);
                String id_vehicle = rs.getString(3);
                String id_parkStart = rs.getString(4);
                String id_parkEnd = rs.getString(5);
                Date dateS = rs.getDate(6);
                Date dateF = rs.getDate(7);
                int rent_cost = rs.getInt(8);
                int distance = rs.getInt(9);
                rents.add("ID rent: " + id_rent + "User Email: " + user_email + "ID Vehicle: " + id_vehicle + " ID Start Park: " + id_parkStart + " ID Final Park: " + id_parkEnd + " Date Start: " + dateS + " Data End: " + dateF + " Rent Cost: " + rent_cost + " Distance: " + distance);

            }
            return rents;
        } catch (StackOverflowError | NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();

                if (rs != null) {
                    rs.close();
                }
            }
            closeAll();
        }
    }

    public ArrayList<String> getAllRents() throws SQLException {
        ArrayList<String> rents = new ArrayList<>();
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {

            callStmt = getConnection().prepareCall("{ ? = call getAllRents() }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Executa a invocação da função "getVehicle".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            rs = (ResultSet) callStmt.getObject(1);

            while (rs.next()) {
                int id_rent = rs.getInt(1);
                String user_email = rs.getString(2);
                String id_vehicle = rs.getString(3);
                String id_parkStart = rs.getString(4);
                String id_parkEnd = rs.getString(5);
                Date dateS = rs.getDate(6);
                Date dateF = rs.getDate(7);
                int rent_cost = rs.getInt(8);
                int distance = rs.getInt(9);
                rents.add("ID rent: " + id_rent + " User Email: " + user_email + "ID Vehicle: " + id_vehicle + " ID Start Park: " + id_parkStart + " ID Final Park: " + id_parkEnd + " Date Start: " + dateS + " Data End: " + dateF + " Rent Cost: " + rent_cost + " Distance: " + distance);
            }
            return rents;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();

                if (rs != null) {
                    rs.close();
                }
            }
            closeAll();
        }
    }

    /**
     * @param vehicleID
     * @return
     * @throws SQLException
     */
    public long forHowLongAVehicleIsUnlocked(String vehicleID) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (vehicleID == null || vehicleID.isEmpty()) {
                return 0;
            }

            callStmt = getConnection().prepareCall("{ ? = call forHowLongAVehicleIsUnlocked(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.DOUBLE);

            // Especifica o parâmetro de entrada da função "forHowLongAVehicleIsUnlocked".
            callStmt.setString(2, vehicleID);

            // Executa a invocação da função "forHowLongAVehicleIsUnlocked".
            callStmt.execute();

            // Guarda o cursor retornado num integer.
            return callStmt.getLong(1);

        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public long getRentMilisseconds(String idAux) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getRentMilisseconds(?) }");

            callStmt.registerOutParameter(1, OracleTypes.FLOAT); //standard para o output
            callStmt.setString(2, idAux);
            callStmt.execute();


            return callStmt.getLong(1);


        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean lockVehicle(String bikeDisc, String username, String id, double distance) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (bikeDisc == null || username == null || id == null || bikeDisc.isEmpty() || username.isEmpty() || id.isEmpty() || distance <= 0) {
                return false;
            }

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call updateRent(?,?,?,?) }");

            callStmt.setString(1, bikeDisc);
            callStmt.setString(2, username);
            callStmt.setString(3, id);
            callStmt.setDouble(4, distance);

            callStmt.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }
        public Place getParkByRent(String username) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (username == null || username.isEmpty()) {
                return null;
            }

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{  ? =  call getParkByRent(?) }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR); //standard para o output

            callStmt.setString(2, username);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            
            
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
        } }catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        throw new IllegalArgumentException("No Park found:");

    }

    public long getRentUpdateMilisseconds(String rentId) throws SQLException {
        CallableStatement callStmt = null;

        long r = 0;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getRentUpdateMilisseconds(?) }");

            callStmt.registerOutParameter(1, OracleTypes.FLOAT); //standard para o output
            callStmt.setString(2, rentId);
            callStmt.execute();

            r = callStmt.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
            return r;
        }
    }

    public ArrayList<String> getAllRentsByUsername(String username) throws SQLException {
        ArrayList<String> rents = new ArrayList<>();
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {

            callStmt = getConnection().prepareCall("{ ? = call getAllRentsByUsername(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);
            // Executa a invocação da função "getVehicle".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            rs = (ResultSet) callStmt.getObject(1);

            while (rs.next()) {
                String id_rent = rs.getString(1);
                String user_email = rs.getString(2);
                String id_vehicle = rs.getString(3);
                String id_parkStart = rs.getString(4);
                String id_parkEnd = rs.getString(5);
                Timestamp dateS = rs.getTimestamp(6);
                Timestamp dateF = rs.getTimestamp(7);
                int rent_cost = rs.getInt(8);
                int distance = rs.getInt(9);
                long unlockTime = (getTimestampInMiliseconds(dateF) - getTimestampInMiliseconds(dateS)) / 1000;
                rents.add(id_vehicle + ";" + dateS.toString() + ";" + dateF.toString() + ";" + id_parkStart + ";" + id_parkEnd + ";" + unlockTime + ";" + rent_cost);
            }
            return rents;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();

                if (rs != null) {
                    rs.close();
                }
            }
            closeAll();
        }
    }

    public boolean addRentB(String id, String s, String s1) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call addRentBicycle(?,?,?) }");

            callStmt.setString(1, id);
            callStmt.setString(2, s1);
            callStmt.setString(3, s);

            callStmt.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean addRentR(String id, String s, String s1) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call addRentEScooter(?,?,?) }");

            callStmt.setString(1, id);
            callStmt.setString(2, s1);
            callStmt.setString(3, s);

            callStmt.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean lockVehicleE(String bikeDisc, String username, String id, double distance) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call updateRentEScooter(?,?,?,?) }");

            callStmt.setString(1, bikeDisc);
            callStmt.setString(2, username);
            callStmt.setString(3, id);
            callStmt.setDouble(4, distance);

            callStmt.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean lockVehicleB(String bikeDisc, String username, String id, double distance) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call updateRentBicycle(?,?,?,?) }");

            callStmt.setString(1, bikeDisc);
            callStmt.setString(2, username);
            callStmt.setString(3, id);
            callStmt.setDouble(4, distance);

            callStmt.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public long getTimestampInMiliseconds(Timestamp endDate) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getTimestampInMiliseconds(?) }");

            callStmt.registerOutParameter(1, OracleTypes.FLOAT);
            callStmt.setTimestamp(2, endDate);

            callStmt.execute();

            return callStmt.getLong(1);

        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public boolean addRent(String idAux, String s, String s1) throws SQLException {//
        CallableStatement callStmt = null;
        boolean check = true;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call addRent(?,?,?) }");

            callStmt.setString(1, idAux);
            callStmt.setString(2, s1);
            callStmt.setString(3, s);

            callStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        } finally {
            if (super.getConnection() != null) {
                super.closeAll();
            }
            if (callStmt != null) {
                callStmt.close();
            }
            return check;
        }
    }

    public ArrayList<String> getAllRentsAndPointsByUsername(String username) throws SQLException {
        ArrayList<String> rents = new ArrayList<>();
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {

            callStmt = getConnection().prepareCall("{ ? = call getAllRentsByUsername(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);
            // Executa a invocação da função "getVehicle".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            rs = (ResultSet) callStmt.getObject(1);

            while (rs.next()) {
                String id_rent = rs.getString(1);
                String user_email = rs.getString(2);
                String id_vehicle = rs.getString(3);
                String id_parkStart = rs.getString(4);
                String id_parkEnd = rs.getString(5);
                Timestamp dateS = rs.getTimestamp(6);
                Timestamp dateF = rs.getTimestamp(7);
                int rent_cost = rs.getInt(8);
                int distance = rs.getInt(9);
                int rentPoints = rs.getInt(10);
                long unlockTime = (getTimestampInMiliseconds(dateF) - getTimestampInMiliseconds(dateS)) / 1000;
                rents.add(id_vehicle + ";" + dateS.toString() + ";" + dateF.toString() + ";" + id_parkStart + ";" + id_parkEnd + ";" + rentPoints);
            }
            return rents;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (callStmt != null) {
                callStmt.close();

                if (rs != null) {
                    rs.close();
                }
            }
            closeAll();
        }
    }

    public double getCost(String username) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getCostForMonth(?) }");

            callStmt.registerOutParameter(1, OracleTypes.FLOAT);
            callStmt.setString(2, username);

            callStmt.execute();

            return callStmt.getDouble(1);

        } catch (NullPointerException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
    }

    public int getTotalPoints(String username) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call totalPoints(?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setString(2, username);

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
}
