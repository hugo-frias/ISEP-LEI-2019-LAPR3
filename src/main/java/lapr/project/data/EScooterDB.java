package lapr.project.data;

import lapr.project.model.EScooter;
import lapr.project.utils.Utils;
import oracle.jdbc.OracleTypes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EScooterDB extends DataHandler {

    public EScooter getEScooter(String esDescription) throws SQLException {
        CallableStatement callStmt = null;
        EScooter es = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getEScooter(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, esDescription);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String description = rSet.getString(1);
                int weight = rSet.getInt(2);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                double aerodynamicCoefficient = rSet.getDouble(5);
                double frontalArea = rSet.getDouble(6);
                String esType = rSet.getString(8);
                int maxBatteryCapacity = rSet.getInt(9);
                int actualBatteryCapacity = rSet.getInt(10);
                int motor = rSet.getInt(11);

                es = new EScooter(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Eletric Scooter with that Description:" + esDescription);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return es;
        }
    }

    public boolean addEScooter(List<EScooter> list) throws SQLException {
        boolean check = true;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (EScooter es : list) {
                if (!addEScooter(es.getDescription(), es.getWeight(), es.getParkLatitude(), es.getParkLongitude(), es.getAerodynamicCoefficient(), es.getFrontalArea(), es.getEsType(), es.getMaxBatteryCapacity(), es.getActualBatteryCapacity(), es.getMotor())) {
                    check = false;
                    throw new SQLException();
                }

            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.rollback();
                con.setAutoCommit(true);
            }
            closeAll();
        }
        return check;
    }

    public boolean addEScooter(EScooter es) throws SQLException {
        openConnection();
        try {
            return addEScooter(es.getDescription(), es.getWeight(), es.getParkLatitude(), es.getParkLongitude(), es.getAerodynamicCoefficient(), es.getFrontalArea(), es.getEsType(), es.getMaxBatteryCapacity(), es.getActualBatteryCapacity(), es.getMotor());
        } catch (SQLException e) {
            closeAll();
        }
        return false;
    }

    private boolean addEScooter(String description, int weight, double parkLatitude, double parkLongitude, double aerodynamicCoefficient, double frontalArea, String esType, int maxBatteryCapacity, int actualBatteryCapacity, int motor) throws SQLException {
        CallableStatement callStmt = null;
        try {
            openConnection();

            callStmt = getConnection().prepareCall("{ call addEScooter(?,?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, description);
            callStmt.setInt(2, weight);
            callStmt.setString(7, esType);
            callStmt.setDouble(3, parkLatitude);
            callStmt.setDouble(4, parkLongitude);
            callStmt.setDouble(5, aerodynamicCoefficient);
            callStmt.setDouble(6, frontalArea);
            callStmt.setInt(8, maxBatteryCapacity);
            callStmt.setInt(9, actualBatteryCapacity);
            callStmt.setInt(10, motor);

            callStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
        }
        return true;
    }

    public boolean removeEScooter(EScooter es) throws SQLException {
        CallableStatement callStmt = null;
        try {
            if (super.getConnection() == null) {
                openConnection();
            }

            callStmt = getConnection().prepareCall("{ call removeESCooter(?) }");

            callStmt.setString(1, es.getDescription());

            callStmt.execute();

            callStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            if (super.getConnection() != null) {
                super.closeAll();
            }
        }
        return true;
    }

    public int getEscooterWithEnergy(double energy, String outputFile) throws SQLException, IOException {
        CallableStatement callStmt = null;
        EScooter es = null;
        int esc = 0;
        StringBuilder output = new StringBuilder();
        try {
            callStmt = getConnection().prepareCall("{ ? = call getEScooterForEnergy(?) }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR); //standard para o output

            callStmt.setDouble(2, energy); //1º parametro
            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String esdescription = rSet.getString(1);
                double parkLatitude = rSet.getDouble(3);
                double parkLongitude = rSet.getDouble(4);
                int weight = rSet.getInt(2);
                double aerodynamicCoefficient = rSet.getDouble(5);
                double frontalArea = rSet.getDouble(6);
                String esType = rSet.getString(7);
                int maxBatteryCapacity = rSet.getInt(8);
                int actualBatteryCapacity = rSet.getInt(9);
                int motor = rSet.getInt(10);
                es = new EScooter(esdescription, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor);
                esc++;
                output.append(es.toString()).append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            if (super.getConnection() != null) {
                super.closeAll();
            }
            Utils.writeFile(output.toString(), outputFile);
            return esc;
        }
    }

    public List<EScooter> getEScooterForEnergy(String id, double energyCost) throws SQLException {
        ArrayList<EScooter> escooters = new ArrayList<>();
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {

            callStmt = getConnection().prepareCall("{ ? = call getEScootersForEnergy(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, id);
            callStmt.setDouble(3, energyCost);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rc = (ResultSet) callStmt.getObject(1);

            while (rc.next()) {
                String description = rc.getString(1);
                int weight = rc.getInt(2);
                double parkLatitude = rc.getDouble(3);
                double parkLongitude = rc.getDouble(4);
                double aerodynamicCoefficient = rc.getDouble(5);
                double frontalArea = rc.getDouble(6);
                String esType = rc.getString(7);
                int maxBatteryCapacity = rc.getInt(8);
                int actualBatteryCapacity = rc.getInt(9);
                int motor = rc.getInt(10);
                EScooter es = new EScooter(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor);
                escooters.add(es);
            }
            return escooters;
        } catch (StackOverflowError | NullPointerException | SQLException ex) {
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

    public EScooter getHighestBatteryScooter(String parkId) throws SQLException {
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getEScooterHighestBattery(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR); //standard para o output

            callStmt.setString(2, parkId);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            EScooter auxE = null;

            if (rSet.next()) {

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
                auxE = new EScooter(description, weight, parkLatitude, parkLongitude, aerodynamicCoefficient, frontalArea, esType, maxBatteryCapacity, actualBatteryCapacity, motor);
            }
            return auxE;
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(EScooterDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {
            if (callStmt != null) {
                callStmt.close();
            }

        }
    }

    public List<EScooter> getAllEScooters() {
        ArrayList<EScooter> escooters = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            openConnection();

            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT id_escooter FROM Electric_Scooter");

            while (rs.next()) {
                escooters.add(getEScooter(rs.getString(1)));
            }

            return escooters;
        } catch (SQLException ex) {
            Logger.getLogger(EScooterDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PathDB.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PathDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            closeAll();
        }
    }

    public double getMinEnergyWithEScooters(List<EScooter> escooters, double distance) {
        CallableStatement callStmt = null;
        double min = Double.MAX_VALUE;
        double energy = 0;
        try {
            for (EScooter es : escooters) {
                callStmt = getConnection().prepareCall("{ ? = call getEnergyWithEScooter(?,?) }");

                callStmt.registerOutParameter(1, OracleTypes.CURSOR);

                callStmt.setInt(2, es.getMotor());
                callStmt.setDouble(3, distance);

                callStmt.execute();

                // Guarda o cursor retornado num objeto "ResultSet".
                ResultSet rSet = (ResultSet) callStmt.getObject(1);
                energy = rSet.getDouble(1);
                if (energy < min) {
                    min = energy;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                try {
                    callStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return min;
    }
}
