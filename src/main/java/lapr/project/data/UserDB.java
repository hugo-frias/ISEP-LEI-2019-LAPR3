package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lapr.project.model.Park;
import lapr.project.model.Rent;

import lapr.project.model.User;
import oracle.jdbc.OracleTypes;

public class UserDB extends DataHandler {

    public UserDB() {
    }

    public User getUser(String anything) throws SQLException {
        User u = null;
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUser(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, anything);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                //User(String username, String email,int age, int height, int weight, double cyclingAvgSpeed, double visaCardNumber)
                String userUsername = rSet.getString(1);
                String userEmail = rSet.getString(2);
                int userHeight = rSet.getInt(3);
                int userWeight = rSet.getInt(4);
                double userCyclingAvgSpeed = rSet.getDouble(5);
                double userVisaCardNumber = rSet.getDouble(6);
                char userGender = rSet.getString(7).charAt(0);
                String userPassword = rSet.getString(8);
                int points = rSet.getInt(8);

                u = new User(userUsername, userEmail, userPassword, userHeight, userWeight, userGender, userCyclingAvgSpeed, userVisaCardNumber, points);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No User with username:" + anything);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return u;
        }
    }

    private boolean addOneUser(User u) throws SQLException {
        CallableStatement callStmt = null;
        boolean check = true;

        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call addUser(?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, u.getUsername());
            callStmt.setString(2, u.getEmail());
            callStmt.setString(3, u.getPassword());
            callStmt.setInt(4, u.getHeight());
            callStmt.setInt(5, u.getWeight());
            callStmt.setString(6, String.valueOf(u.getGender()));
            callStmt.setDouble(7, u.getCyclingAvgSpeed());
            callStmt.setDouble(8, u.getVisaCardNumber());
            callStmt.setInt(9, u.getPoints());

            callStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return check;
        }
    }

    public boolean addUser(List<User> uList) throws SQLException {
        boolean check = false;
        Connection con = null;
        try {
            openConnection();
            con = getConnection();
            con.setAutoCommit(false);
            for (User u : uList) {
                if (!addOneUser(new User(u.getUsername(), u.getEmail(), u.getPassword(), u.getHeight(), u.getWeight(), u.getGender(), u.getCyclingAvgSpeed(), u.getVisaCardNumber(), u.getPoints()))) {
                    check = true;
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

    public boolean addUser(User u) throws SQLException {
        boolean check = true;
        openConnection();
        try {
            check = addOneUser(u);
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ParkDB.class.getName()).log(Level.SEVERE, null, ex);
            closeAll();
        }
        return check;
    }

    public boolean removeUser(String email) throws SQLException {
        CallableStatement callStmt = null;
        boolean check = true;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = getConnection().prepareCall("{ call removeUser(?) }");

            callStmt.setString(1, email);

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

    public boolean updateUser(String email, User u) {
        User a;

        try {
            a = getUser(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try {
            a.setUsername(u.getUsername());
            a.setEmail(u.getEmail());
            a.setPassword(u.getPassword());
            a.setHeight(u.getHeight());
            a.setWeight(u.getWeight());
            a.setVisaCardNumber(u.getVisaCardNumber());
            a.setPoints(u.getPoints());
            a.setGender(u.getGender());
            a.setCyclingAvgSpeed(u.getCyclingAvgSpeed());
            //a.save();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean handleBatch(List<User> l, String action) {

        boolean add = action.equalsIgnoreCase("add");
        boolean remove = action.equalsIgnoreCase("remove");

        if (l.isEmpty()) {
            return false;
        }
        int hc = 0; //counter for correct adds

        for (User u : l) {
            try {
                if (add && getUser(u.getEmail()) != null) {
                    return false;
                }
                if (remove && getUser(u.getEmail()) == null) {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (User u : l) {
            try {
                if (add) {
                    if (addUser(u)) {
                        ++hc;
                    }
                }
                if (remove) {
                    if (removeUser(u.getEmail())) {
                        ++hc;
                    }
                }
            } catch (SQLException e) {
                for (User u2 : l) {
                    try {
                        if (add) {
                            removeUser(u2.getEmail());
                        }
                        if (remove) {
                            addUser(u2);
                        }
                    } catch (SQLException ex) {
                        break;
                    }
                }
                break;
            }
        }

        return hc == l.size(); //all users were added
    }

    public int getInvoiceCount() throws SQLException {
        CallableStatement callStmt = null;
        int c = 0;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ call getInvoiceCount() }");

            callStmt.execute();

            c = callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Invoices found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return c;
        }
    }

    public long getCurrentDebt(String nome) throws SQLException {
        CallableStatement callStmt = null;
        long d = 0;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getCurrentDebt(?) }");

            callStmt.registerOutParameter(1, OracleTypes.FLOAT);

            callStmt.setString(2, nome);

            callStmt.execute();

            d = callStmt.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Rents found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return d;
        }

    }

    public User getUserByName(String s1) throws SQLException {
        User u = null;
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUserByName(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, s1);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String userUsername = rSet.getString(1);
                String userEmail = rSet.getString(2);
                int userHeight = rSet.getInt(3);
                int userWeight = rSet.getInt(4);
                double userCyclingAvgSpeed = rSet.getDouble(5);
                double userVisaCardNumber = rSet.getDouble(6);
                char userGender = rSet.getString(7).charAt(0);
                String userPassword = rSet.getString(8);
                int points = rSet.getInt(8);

                u = new User(userUsername, userEmail, userPassword, userHeight, userWeight, userGender, userCyclingAvgSpeed, userVisaCardNumber, points);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No User with username:" + s1);
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return u;
        }
    }

    public int getPointsForMonth(int monthAux, String username) throws SQLException {
        CallableStatement callStmt = null;
        int p = 0;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call getPointsForMonth(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            callStmt.setInt(2, monthAux);
            callStmt.setString(3, username);

            callStmt.execute();

            p = callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Rents found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return p;
        }

    }

    public int getCurrentPoints(String username) throws SQLException {
        int p = 0;
        CallableStatement callStmt = null;
        try {

            if (super.getConnection() == null) {
                super.openConnection();
            }

            callStmt = super.getConnection().prepareCall("{ ? = call totalPoints(?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            callStmt.setString(2, username);

            callStmt.execute();

            p = callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No Rents found:");
        } finally {
            if (callStmt != null) {
                callStmt.close();
            }
            return p;
        }

    }

    public double getEnergyWithBicycle(String username, double distance) {
        CallableStatement callStmt = null;
        double energy = 0;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getEnergyWithBicycle(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.setString(2, username);
            callStmt.setDouble(3, distance);

            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            energy = rSet.getDouble(1);

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
        return energy;
    }

}
