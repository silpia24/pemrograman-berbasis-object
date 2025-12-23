package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/UAS_2412510030?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root",
                    "Mysqlsilpi1!"
            );
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL tidak ditemukan!");
        } catch (SQLException e) {
            throw new SQLException("Detail error: " + e.getMessage());
        }
    }
}
