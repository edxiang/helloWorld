package TestTrip;

/**
 * Created by Kevin.Z on 2017/8/10.
 */
public class ConfigDomain {
    public static String hostName = "192.168.88.55";
    public static int hostPort = 23457;
    public static String username = "system";
    public static String password = "z";
    public static String dbName = "test_by_z";

    public static String getHostName() {
        return hostName;
    }

    public static int getHostPort() {
        return hostPort;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setHostName(String hostName) {
        ConfigDomain.hostName = hostName;
    }

    public static void setHostPort(int hostPort) {
        ConfigDomain.hostPort = hostPort;
    }

    public static void setUsername(String username) {
        ConfigDomain.username = username;
    }

    public static void setPassword(String password) {
        ConfigDomain.password = password;
    }

    public static void setDbName(String dbName) {
        ConfigDomain.dbName = dbName;
    }
}
