package helpers;

public class Constante {
    private static final String URL = "jdbc:mysql://localhost:3306/adrressbook?autoReconnect=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "psw1234";

    private static final String ADD_QUERY = "INSERT INTO maintabla (firstname, lastname, phone, country, city, address, indx, email, created) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE INTO maintabla (";

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getAddQuery() {
        return ADD_QUERY;
    }
}
