package lapr.project.data;

import lapr.project.model.Bicycle;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BicycleDB extends DataHandler {

    public Bicycle getBicycle(String bDescription) throws SQLException {
        Bicycle b = null;

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getBicycle(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, bDescription);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String bicycleDescription = rSet.getString(1);
                int weight = rSet.getInt(2);
                double pLatitude = rSet.getDouble(3);
                double pLongitude = rSet.getDouble(4);
                double aerodynamicCoefficient = rSet.getDouble(5);
                double frontalArea = rSet.getDouble(6);
                int wheel_size = rSet.getInt(7);

                b = new Bicycle(bicycleDescription, weight, pLatitude, pLongitude, aerodynamicCoefficient, frontalArea, wheel_size);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Bicycle with that description:" + bDescription);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return b;
        }
    }

    public boolean addBicycle(List<Bicycle> list) throws SQLException {
        boolean check = true;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (Bicycle b : list) {
                if (!addBicycle(b.getDescription(), b.getWeight(), b.getParkLatitude(), b.getParkLongitude(), b.getAerodynamicCoefficient(), b.getFrontalArea(), b.getWheelSize())) {
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

    public boolean addBicycle(Bicycle b) throws SQLException {
        openConnection();
        try {
            return addBicycle(b.getDescription(), b.getWeight(), b.getParkLatitude(), b.getParkLongitude(), b.getAerodynamicCoefficient(), b.getFrontalArea(), b.getWheelSize());
        } catch (SQLException e) {
            closeAll();
        }
        return false;
    }

    private boolean addBicycle(String bicycleDescription, int weight, double parkLatitude, double parkLongitude, double aerodynamicCoefficient, double frontalArea, int wheelSize) throws SQLException {
        CallableStatement callStmt = null;
        try {
            /*
             *  Objeto "callStmt" para invocar o procedimento "addSailor" armazenado
             *  na BD.
             *
             *  PROCEDURE addSailor(sid NUMBER, sname VARCHAR, rating NUMBER, age NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            callStmt = getConnection().prepareCall("{ call addBicycle(?,?,?,?,?,?,?) }");

            callStmt.setString(1, bicycleDescription);
            callStmt.setInt(2, weight);
            callStmt.setDouble(3, parkLatitude);
            callStmt.setDouble(4, parkLongitude);
            callStmt.setDouble(5, aerodynamicCoefficient);
            callStmt.setDouble(6, frontalArea);
            callStmt.setInt(7, wheelSize);

            callStmt.execute();

            callStmt.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        return false;
    }

//    public boolean removeBicycle(Bicycle b) throws SQLException {
//        CallableStatement callStmt = null;
//        try {
//            if (super.getConnection() == null) {
//                openConnection();
//            }
//
//            callStmt = getConnection().prepareCall("{ call removeBicycle(?) }");
//
//            callStmt.setString(1, b.getDescription());
//
//            callStmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            if (callStmt != null) {
//                callStmt.close();
//            }
//            if (super.getConnection() != null) {
//                super.closeAll();
//            }
//        }
//        return true;
//
//    }

    public boolean removeBicycle(Bicycle b) throws SQLException {
        boolean check = true;
        CallableStatement callStmt = null;
        try {
            openConnection();

            callStmt = getConnection().prepareCall("{ call removeBicycle(?) }");

            callStmt.setString(1, b.getDescription());

            callStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
            return check;
        }
    }
}
