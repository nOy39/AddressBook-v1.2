package helpers;

import java.sql.*;

public class ConnectDB {

    public static Connection connection;



    //TODO переделать метод чтобы он возвращал коннект.
    public static void openConnection() {
        try {
            connection = DriverManager.getConnection(Constante.getURL(),
                    Constante.getUSER(),
                    Constante.getPASS());



            if (!connection.isClosed()) {
                System.out.println("Connection is OK!");
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.err.println("!!!!!NO CONNECT!!!!!");
        }
    }

    public Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(Constante.getURL(),Constante.getUSER(),Constante.getPASS());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
