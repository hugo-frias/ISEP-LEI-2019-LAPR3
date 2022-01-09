package lapr.project.data;

import lapr.project.model.Path;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lapr.project.model.Bicycle;

public class PathDB extends DataHandler {

    public Path getPath(double latitudeA, double longitudeA, double latitudeB, double longitudeB) throws SQLException {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPath(?,?,?,?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setDouble(2, latitudeA);
            callStmt.setDouble(3, longitudeA);
            callStmt.setDouble(4, latitudeB);
            callStmt.setDouble(5, longitudeB);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                rSet.getInt(1);
                double pathLatitudeA = rSet.getDouble(2);
                double pathLongitudeA = rSet.getDouble(3);
                double pathLatitudeB = rSet.getDouble(4);
                double pathLongitudeB = rSet.getDouble(5);
                double pathKineticCoefficient = rSet.getDouble(6);
                int pathWindDirection = rSet.getInt(7);
                double pathWindSpeed = rSet.getDouble(8);

                return new Path(pathLatitudeA, pathLongitudeA, pathLatitudeB, pathLongitudeB, pathKineticCoefficient, pathWindDirection, pathWindSpeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        throw new IllegalArgumentException("No Path with coordenates:" + latitudeA + " " + longitudeA + " " + latitudeB + " " + longitudeB);
    }

    public boolean addPath(List<Path> list) throws SQLException {
        boolean check = true;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (Path path : list) {
                if (!addPath(path.getLatitudeA(), path.getLongitudeA(), path.getLatitudeB(), path.getLongitudeB(), path.getKineticCoefficient(), path.getWindDirection(), path.getWindSpeed())) {
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
            return check;
        }
    }

    public boolean addPath(Path path) throws SQLException {
        openConnection();
        try {
            return addPath(path.getLatitudeA(), path.getLongitudeA(), path.getLatitudeB(), path.getLongitudeB(), path.getKineticCoefficient(), path.getWindDirection(), path.getWindSpeed());
        } catch (SQLException e) {
            closeAll();
        }
        return false;
    }

    private boolean addPath(double slatitudeA, double slongitudeA, double slatitudeB, double slongitudeB, double skineticCoefficient, double swindDirection, double swindSpeed) throws SQLException {
        CallableStatement callStmt = null;
        boolean check = true;
        try {
            callStmt = getConnection().prepareCall("{ call addPathByCoords(?,?,?,?,?,?,?) }");

            callStmt.setDouble(1, slatitudeA);
            callStmt.setDouble(2, slongitudeA);
            callStmt.setDouble(3, slatitudeB);
            callStmt.setDouble(4, slongitudeB);
            callStmt.setDouble(5, skineticCoefficient);
            callStmt.setDouble(6, swindDirection);
            callStmt.setDouble(7, swindSpeed);

            callStmt.execute();

        } catch (SQLException e) {
            check = false;
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return check;
        }
    }

    public void updatePath(Path path) throws SQLException {
        updatePath(path.getLatitudeA(), path.getLongitudeA(), path.getLatitudeB(), path.getLongitudeB(), path.getKineticCoefficient(), path.getWindDirection(), path.getWindSpeed());
    }

    private void updatePath(double slatitudeA, double slongitudeA, double slatitudeB, double slongitudeB, double skineticCoefficient, int swindDirection, double swindSpeed) throws SQLException {
        CallableStatement callStmt = null;
        try {
            openConnection();
            callStmt = getConnection().prepareCall("{ call updatePath(?,?,?,?) }");

            callStmt.setDouble(1, slatitudeA);
            callStmt.setDouble(2, slongitudeA);
            callStmt.setDouble(3, slatitudeB);
            callStmt.setDouble(4, slongitudeB);
            callStmt.setDouble(5, skineticCoefficient);
            callStmt.setInt(6, swindDirection);
            callStmt.setDouble(7, swindSpeed);

            callStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
        }
    }

    public boolean removePath(Path path) throws SQLException {
        CallableStatement callStmt = null;
        boolean check = true;
        try {
            openConnection();
            callStmt = getConnection().prepareCall("{ call removePath(?,?,?,?) }");

            callStmt.setDouble(1, path.getLatitudeA());
            callStmt.setDouble(2, path.getLongitudeA());
            callStmt.setDouble(3, path.getLatitudeB());
            callStmt.setDouble(4, path.getLongitudeB());

            callStmt.execute();
            check = true;
        } catch (SQLException e) {
            check = false;
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
            return check;
        }
    }

    public List<Path> getAllPaths() {
        ArrayList<Path> paths = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            openConnection();

            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM Travel_Path");

            while (rs.next()) {
                paths.add(getPath(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return paths;
    }

}
