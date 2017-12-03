package eg.edu.alexu.csd.oop.db.cs15;


import eg.edu.alexu.csd.oop.db.Database;
import operations.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatementImp implements Statement {
    Database database;
    int queryTimeout = 0;
    Connection connection;
    List<String> batchs;
    Boolean close = false;
    public StatementImp(Database database, Connection connection){
        this.database = database;
        this.connection = connection;
        batchs = new ArrayList<>();
    }
    @Override
    public ResultSet executeQuery(String s) throws SQLException {
        Log.getLogger().info("Statement: Started executing Query : "+ s);
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        try {
            Object[][] values = database.executeQuery(s);
            ResultSetImp resultSet = new ResultSetImp(values, (ArrayList<String>) Select.getSelectedFields(), Select.getTableName());
            Log.getLogger().info("Statement: Finished executing Query : "+ s);
            return resultSet;
        } catch (Exception e) {
            Log.getLogger().error("Statement: Failed executing Query : "+ s);
            throw new SQLException();
        }

    }

    @Override
    public int executeUpdate(String s) throws SQLException {
        Log.getLogger().info("Statement: Started executing Update : "+s);
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        try {
            int result = database.executeUpdateQuery(s);
            Log.getLogger().info("Statement: Finished executing Update : "+ s +" result is "+result);
            return result;
        } catch (Exception ex) {
            Log.getLogger().error("Statement: Failed executing Update : "+ s);
            throw new SQLException();
        }
    }

    @Override
    public void close() throws SQLException {
        Log.getLogger().info("Statement: closing");
        close = true;
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxFieldSize(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxRows(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEscapeProcessing(boolean b) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        Log.getLogger().info("Statement: Getting Timeout");
        if(close)
            throw new SQLException();
        return queryTimeout;
    }

    @Override
    public void setQueryTimeout(int i) throws SQLException {
        Log.getLogger().info("Statement: Setting Timeout : "+i);
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        this.queryTimeout = i;
    }


    @Override
    public void cancel() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCursorName(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String s) throws SQLException {
        Log.getLogger().info("Statement: Started executing : "+s);
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        boolean result = database.executeStructureQuery(s);
        Log.getLogger().info("Statement: Finished executing : "+ s +" result is "+result);
        return result;
    }


    @Override
    public ResultSet getResultSet() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchDirection(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchSize(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetType() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addBatch(String s) throws SQLException {
        Log.getLogger().info("Statement: adding batch : "+s);
        if(!close) {
            batchs.add(s);
        }
        else {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
    }

    @Override
    public void clearBatch() throws SQLException {
        if(close)
            throw new SQLException();
        batchs.clear();
    }

    @Override
    public int[] executeBatch() throws SQLException {
        Log.getLogger().info("Statement: Started executing batch ");
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        int[] results = new int[batchs.size()];
        for(int i = 0;i < batchs.size();i++)
            results[i] = executeUpdate(batchs.get(i));
        return results;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Log.getLogger().info("Statement: getting connection");
        if(close) {
            Log.getLogger().error("Statement: Closed Statement");
            throw new SQLException();
        }
        return connection;
    }

    @Override
    public boolean getMoreResults(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String s, int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String s, int[] ints) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate(String s, String[] strings) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String s, int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String s, int[] ints) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean execute(String s, String[] strings) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPoolable(boolean b) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPoolable() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T unwrap(Class<T> aClass) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWrapperFor(Class<?> aClass) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
