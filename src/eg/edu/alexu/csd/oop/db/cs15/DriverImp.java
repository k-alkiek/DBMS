package eg.edu.alexu.csd.oop.db.cs15;

import java.io.File;
import java.sql.*;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
public class DriverImp implements Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        Log.getLogger().info("Driver: Start Connecting to "+url);
        if(!acceptsURL(url)) {
            Log.getLogger().error("Driver: Can't Connecting to "+url);
            return null;
        }
        File dir = (File) info.get("path");
        String path = dir.getPath();
        Connection connection = new ConnectionImp(path);
        Log.getLogger().info("Driver: Successfully Connected to "+url);
        return connection;
    }

    @Override
    public boolean acceptsURL(String s) throws SQLException {
        if (s.startsWith("jdbc:xmldb:"))
            return true;
        else
            return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
        Set<String> propertiesNames = properties.stringPropertyNames();
        DriverPropertyInfo[] driverPropertyInfos = new DriverPropertyInfo[propertiesNames.size()];
        int i = 0;
        for (String propName: propertiesNames) {
            driverPropertyInfos[i] = new DriverPropertyInfo(propName,properties.getProperty(propName));
        }
        return driverPropertyInfos;
    }

    @Override
    public int getMajorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMinorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean jdbcCompliant() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException();
    }
}
