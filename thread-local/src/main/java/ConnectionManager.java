import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            Connection conn = null;
            try {
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection("jdbc:mysql://192.168.104.221:3306/scheduler", "usercenter", "1332");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    public static void setConnection(Connection conn) {
        connectionHolder.set(conn);
    }

    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println("Thread: " + Thread.currentThread() + ",connection: " + connectionHolder.get());
        for (int i = 0; i < 5; i++)
            new Thread(() -> System.out.println("Thread: " + Thread.currentThread() + ",connection: " + connectionHolder.get())).start();
    }
}
