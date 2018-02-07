package helpers;

import fx.controllers.AddControllers;
import fx.controllers.EditControllers;
import fx.controllers.EditControllers.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class CRUD {


    public static PreparedStatement preparedStatement;

    static ConnectDB connectDB = new ConnectDB();
    public static EditControllers editControllers = new EditControllers();

    public static void saveToBase(String firstName, String lastName, String phone,
                           String country, String city, String address, String index, String email) {
        connectDB.openConnection();

        try {
            preparedStatement = ConnectDB.connection.prepareStatement(Constante.getAddQuery());

                if (!firstName.equals(null)) {
                    preparedStatement.setString(1, firstName);
                } else {

                }


            preparedStatement.setString(2,lastName);

            preparedStatement.setString(3,phone);

            preparedStatement.setString(4,country);
            preparedStatement.setString(5,city);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7,index);
            preparedStatement.setString(8,email);
            preparedStatement.setDate(9,new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println("Error :"+e);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public static void deleteFromBase(int id) {

        connectDB.openConnection();
        try {

            Statement statement = connectDB.connect().createStatement();
            statement.executeUpdate("DELETE FROM maintabla WHERE id = "+id);
        } catch (SQLException e) {
            System.err.println("no delete");
        }
    }


    public static void updateBase() {

    }


}
