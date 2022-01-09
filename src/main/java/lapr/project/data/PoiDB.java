package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lapr.project.model.Path;
import lapr.project.model.Poi;
import oracle.jdbc.OracleTypes;

public class PoiDB extends DataHandler {

    /**
     * Check the value of Double (3)
     *
     * @param latitude
     * @param longitude
     * @return
     */
    public Poi getPoi(double latitude, double longitude) throws SQLException {
        CallableStatement callStmt = null;
        Poi p = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPoi(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getPoi".
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String id = rSet.getString(1);
                double poiLatitude = rSet.getDouble(2);
                double poiLongitude = rSet.getDouble(3);
                int poiElevation = rSet.getInt(4);
                String poiDescription = rSet.getString(5);

                p = new Poi(id, poiLatitude, poiLongitude, poiElevation, poiDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Poi with these coordinates.");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return p;
        }
    }

    public Poi getPoi(String id) throws SQLException {
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPoiByID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getPoi".
            callStmt.setString(2, id);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                double poiLatitude = rSet.getDouble(2);
                double poiLongitude = rSet.getDouble(3);
                int poiElevation = rSet.getInt(4);
                String poiDescription = rSet.getString(5);

                return new Poi(id, poiLatitude, poiLongitude, poiElevation, poiDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        throw new IllegalArgumentException("No Poi with these coordinates.");
    }

    public boolean addPoi(List<Poi> list) throws SQLException {
        boolean check = true;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (Poi poi : list) {
                if (!addOrUpdatePoi(poi.getId(), poi.getLatitude(), poi.getLongitude(), poi.getElevation(), poi.getDescription(), "{ call addPoi(?,?,?,?,?) }")) {
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

    public void addPoi(Poi poi) throws SQLException {
        addOrUpdatePoi(poi.getId(), poi.getLatitude(), poi.getLongitude(), poi.getElevation(), poi.getDescription(), "{ call addPoi(?,?,?,?) }");
    }

    /**
     * Adiciona o ponto de interesse especificado à tabela "Pois".
     *
     * @param latitude
     * @param longitude
     * @param elevation
     * @param description
     */
    private boolean addOrUpdatePoi(String id, double latitude, double longitude, int elevation, String description, String call) throws SQLException {
        CallableStatement callStmt = null;
        try {
            /*
             *  Objeto "callStmt" para invocar o procedimento "addSailor" armazenado
             *  na BD.
             *
             *  PROCEDURE addSailor(sid NUMBER, sname VARCHAR, rating NUMBER, age NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            callStmt = getConnection().prepareCall(call);

            callStmt.setString(1, id);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);
            callStmt.setInt(4, elevation);
            callStmt.setString(5, description);

            callStmt.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
        }
        return false;
    }

    /**
     * @param poi
     */
    public void updatePoi(Poi poi) throws SQLException {
        addOrUpdatePoi(poi.getId(), poi.getLatitude(), poi.getLongitude(), poi.getElevation(), poi.getDescription(), "{ call updatePoi(?,?,?,?) }");
    }

    /**
     * @param latitude
     * @param longitude
     */
    public void removePoi(double latitude, double longitude) throws SQLException {
        CallableStatement callStmt = null;
        try {
            openConnection();

            /*
             *  Objeto "callStmt" para invocar o procedimento "removePoi" armazenado na BD.
             *
             *  PROCEDURE removeSailor(sid NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            callStmt = getConnection().prepareCall("{ call removePoi (?,?) }");

            callStmt.setDouble(1, latitude);
            callStmt.setDouble(2, longitude);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
        }

    }

    public ArrayList<Poi> getPoisFromPaths(ArrayList<Path> paths) throws SQLException {
        ArrayList<Poi> pois = new ArrayList<>();
        CallableStatement callStmt = null;
        try {
            openConnection();

            callStmt = getConnection().prepareCall("{ call getPoisFromPath(?,?,?,?,?) }");
            for (Path path : paths) {
                double latitudeA = path.getLatitudeA();
                double longitudeA = path.getLongitudeA();
                double latitudeB = path.getLatitudeB();
                double longitudeB = path.getLongitudeB();

                callStmt.setDouble(1, latitudeA);
                callStmt.setDouble(2, longitudeA);
                callStmt.setDouble(3, latitudeB);
                callStmt.setDouble(4, longitudeB);
                callStmt.registerOutParameter(5, OracleTypes.CURSOR);

                callStmt.execute();

                ResultSet rSet = (ResultSet) callStmt.getObject(1);

                while (rSet.next()) {
                    pois.add(getPoi(rSet.getDouble(1), rSet.getDouble(2)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            closeAll();
        }
        return pois;
    }

    public int getNumberOfPois() throws SQLException {
        CallableStatement callStmt = null;
        int np = 0;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call getNumberOfPois() }");

            callStmt.execute();

            np = callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Poi found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return np;
        }
    }

    public List<Poi> getAllPois() {
        ArrayList<Poi> pois = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            openConnection();

            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT id_poi FROM Point_Of_Interest");

            while (rs.next()) {
                pois.add(getPoi(rs.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PoiDB.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PoiDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            closeAll();
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PoiDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pois;
    }

}
