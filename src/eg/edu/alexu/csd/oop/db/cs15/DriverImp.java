package eg.edu.alexu.csd.oop.db.cs15;

import java.io.File;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.io.Serializable;
public class DriverImp implements Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        File dir = (File) info.get("path");
        String path = dir.getAbsolutePath();
        
        return connectionManager.getConnection(path); // pool

    }

    @Override
    public boolean acceptsURL(String s) throws SQLException {
        // Todo
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
        // Todo

        return new DriverPropertyInfo[0];
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
