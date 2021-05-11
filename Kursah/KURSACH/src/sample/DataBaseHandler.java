package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Const.ConstUser;
import sample.model.Car;
import sample.model.User;

import java.sql.*;

public class DataBaseHandler  extends Configs {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + ConstUser.USER_TABLE + "(" +
                ConstUser.USER_FIRSTNAME + "," + ConstUser.USER_LASTNAME + ","
                + ConstUser.USER_USERNAME + "," + ConstUser.USER_PASSWORD + ","
                + ConstUser.USER_ADDRESS + "," + ConstUser.USER_EMAIL + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, user.getPassword());
            prST.setString(2, user.getUsername());
            prST.setString(3, user.getAddress());
            prST.setString(4, user.getEmail());
            prST.setString(5, user.getFirstname());
            prST.setString(6, user.getLastname());
            prST.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getUser(User user) {
        ResultSet rsSet = null;

        String select = "SELECT * FROM " + ConstUser.USER_TABLE + " WHERE " +
                ConstUser.USER_USERNAME + "=? AND " + ConstUser.USER_PASSWORD + "=?";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getUsername());
            prST.setString(2, user.getPassword());

            rsSet = prST.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rsSet;
    }

    public ObservableList<Car> getCar(String selectRequest) throws SQLException {
        ObservableList<Car> res = FXCollections.observableArrayList();
        Statement statement = dbConnection.createStatement();
        ResultSet set = statement.executeQuery(selectRequest);

        String mark, model;
        int price, tonnage;
        while (set.next()) {
            mark = set.getString("mark");
            model = set.getString("model");
            price = set.getInt("price");
            tonnage = set.getInt("tonnage");
            res.add(new Car(mark, model, price, tonnage));

        }
        return res;

    }
}


