package eg.edu.alexu.csd.oop.db.cs15;

import data.IRecord;
import data.Record;
import data.TableXML;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ResultSetImp implements ResultSet {
    int crusor = -1;
    StatementImp statment;
    Object[][] values;
    List<String> fieldsName = new ArrayList<>();
    Boolean close = false;
    String tableName;
    public ResultSetImp(Object[][] values, List<String> fieldsName, String tableName) {
        this.values = values;
        this.fieldsName = fieldsName;
        this.tableName = tableName;
    }

    private int getsize() {
        return values.length;
    }
    @Override
    public boolean next() throws SQLException {
        try {
            if(crusor + 1 >= getsize()) {
                crusor ++;
                return false;
            }
            else {
                crusor ++;
                return  true;
            }
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public void close() throws SQLException {
        try {
            close = true;
        }
        catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean wasNull() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getString(int i) throws SQLException {
        try {
            if( values.length == 0 || i - 1 < 0 || i - 1 >= values[0].length ||  crusor < 0 || crusor >= values[0].length) {
                throw new SQLException();
            }
            return values[crusor][i - 1].toString();
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public boolean getBoolean(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getByte(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public short getShort(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getInt(int i) throws SQLException {
        try {
            if( values.length == 0 || i - 1 < 0 || i - 1 >= values[0].length ||  crusor < 0 || crusor >= values[0].length) {
                throw new SQLException();
            }
            return Integer.parseInt(values[crusor][i - 1].toString());
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public long getLong(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getFloat(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getDouble(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal getBigDecimal(int i, int i1) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getBytes(int i) throws SQLException {
        return new byte[0];
    }

    @Override
    public Date getDate(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Time getTime(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Timestamp getTimestamp(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getAsciiStream(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getUnicodeStream(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getBinaryStream(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getString(String s) throws SQLException {
        try {
            if( values.length == 0 || crusor < 0 || crusor >= values[0].length) {
                throw new SQLException();
            }
            for (int i = 0; i < fieldsName.size(); i++) {
                if (fieldsName.get(i).equals("s")) {
                    return values[crusor][i].toString();
                }
            }
            throw new SQLException();
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public boolean getBoolean(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getByte(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public short getShort(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getInt(String s) throws SQLException {
        try {
            if( values.length == 0 || crusor < 0 || crusor >= values[0].length) {
                throw new SQLException();
            }
            for (int i = 0; i < fieldsName.size(); i++) {
                if (fieldsName.get(i).equals("s")) {
                    return Integer.parseInt(values[crusor][i].toString());
                }
            }
            throw new SQLException();
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public long getLong(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getFloat(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getDouble(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal getBigDecimal(String s, int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getBytes(String s) throws SQLException {
        return new byte[0];
    }

    @Override
    public Date getDate(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Time getTime(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Timestamp getTimestamp(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getAsciiStream(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getUnicodeStream(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getBinaryStream(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public String getCursorName() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        try {
            ResultSetMetaDataImp result = new ResultSetMetaDataImp(values, fieldsName, tableName);
            return  result;

        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public Object getObject(int i) throws SQLException {
        try {
            if( values.length == 0 || i - 1 < 0 || i - 1 >= values[0].length ||  crusor < 0 || crusor >= values[0].length) {
                throw new SQLException();
            }
            return values[crusor][i - 1];
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public Object getObject(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int findColumn(String s) throws SQLException {
        try {
            for(int i = 0; i < fieldsName.size(); i++) {
                if(fieldsName.get(i).equals(s)) {
                    return i;
                }
            }
            throw new SQLException();
        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public Reader getCharacterStream(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Reader getCharacterStream(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal getBigDecimal(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal getBigDecimal(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        try {
            if (crusor == -1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        try {
            if(crusor >= getsize()) {
                return true;
            }
            else {
                return false;
            }

        } catch (Exception e) {
            throw new SQLException();
        }
    }


    @Override
    public boolean isFirst() throws SQLException {
        try {
            if(crusor == 0 ) {
                return true;
            }
            else {
                return false;
            }

        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isLast() throws SQLException {
        try {
            if(crusor == getsize() - 1) {
                return true;
            }
            else {
                return false;
            }

        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public void beforeFirst() throws SQLException {
        try {
            crusor = -1;
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public void afterLast() throws SQLException {
        try {
            crusor = getsize();
        } catch (Exception e) {
            throw new SQLException();
        }
    }


    @Override
    public boolean first() throws SQLException {
        try {
            crusor = 0;

            if(getsize()  == 0) {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            throw new SQLException();
        }

    }

    @Override
    public boolean last() throws SQLException {
        try {
            crusor = getsize() - 1;
            if(getsize()  == 0) {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public int getRow() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean absolute(int i) throws SQLException {
        try {

            if(i == 0) {
                crusor  = -1;
            }
            else if(i > 0) {
                crusor = i;
            }
            else {
                crusor = getsize() + i;
            }
            if(crusor >= getsize() || crusor < 0) {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean relative(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean previous() throws SQLException {
        try {
            crusor --;
            if(crusor >= getsize() || crusor < 0) {
                return false;
            }
            else {
                return true;
            }
        } catch (Exception e) {
            throw new SQLException();
        }
    }



    @Override
    public void setFetchDirection(int i) throws SQLException {

    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFetchSize(int i) throws SQLException {

    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getType() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getConcurrency() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean rowInserted() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateNull(int i) throws SQLException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateBoolean(int i, boolean b) throws SQLException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateByte(int i, byte b) throws SQLException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateShort(int i, short i1) throws SQLException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateInt(int i, int i1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateLong(int i, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateFloat(int i, float v) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateDouble(int i, double v) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateString(int i, String s) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBytes(int i, byte[] bytes) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateDate(int i, Date date) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateTime(int i, Time time) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(int i, InputStream inputStream, int i1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(int i, InputStream inputStream, int i1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(int i, Reader reader, int i1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateObject(int i, Object o, int i1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateObject(int i, Object o) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNull(String s) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBoolean(String s, boolean b) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateByte(String s, byte b) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateShort(String s, short i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateInt(String s, int i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateLong(String s, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateFloat(String s, float v) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateDouble(String s, double v) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBigDecimal(String s, BigDecimal bigDecimal) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateString(String s, String s1) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBytes(String s, byte[] bytes) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateDate(String s, Date date) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateTime(String s, Time time) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateTimestamp(String s, Timestamp timestamp) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(String s, InputStream inputStream, int i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(String s, InputStream inputStream, int i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(String s, Reader reader, int i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateObject(String s, Object o, int i) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateObject(String s, Object o) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void insertRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void deleteRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void refreshRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new SQLException();

    }

    @Override
    public Statement getStatement() throws SQLException {
        try {
            if(statment == null) {
                return null;
            }
            return statment;
        }
        catch (Exception ex) {
            throw new SQLException();
        }
    }

    @Override
    public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Ref getRef(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Blob getBlob(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Clob getClob(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Array getArray(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getObject(String s, Map<String, Class<?>> map) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Ref getRef(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Blob getBlob(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Clob getClob(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Array getArray(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date getDate(int i, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date getDate(String s, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Time getTime(int i, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Time getTime(String s, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Timestamp getTimestamp(String s, Calendar calendar) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public URL getURL(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public URL getURL(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateRef(int i, Ref ref) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateRef(String s, Ref ref) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(int i, Blob blob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(String s, Blob blob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(int i, Clob clob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(String s, Clob clob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateArray(int i, Array array) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateArray(String s, Array array) throws SQLException {
        throw new SQLException();

    }

    @Override
    public RowId getRowId(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public RowId getRowId(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateRowId(int i, RowId rowId) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateRowId(String s, RowId rowId) throws SQLException {
        throw new SQLException();

    }

    @Override
    public int getHoldability() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isClosed() throws SQLException {
        try {
            return close;
        }
        catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public void updateNString(int i, String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateNString(String s, String s1) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateNClob(int i, NClob nClob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNClob(String s, NClob nClob) throws SQLException {
        throw new SQLException();

    }

    @Override
    public NClob getNClob(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public NClob getNClob(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLXML getSQLXML(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLXML getSQLXML(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSQLXML(int i, SQLXML sqlxml) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateSQLXML(String s, SQLXML sqlxml) throws SQLException {
        throw new SQLException();

    }

    @Override
    public String getNString(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getNString(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Reader getNCharacterStream(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Reader getNCharacterStream(String s) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateNCharacterStream(int i, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNCharacterStream(String s, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(int i, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(int i, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(int i, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(String s, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(String s, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(String s, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(int i, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(String s, InputStream inputStream, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(int i, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(String s, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNClob(int i, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNClob(String s, Reader reader, long l) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNCharacterStream(int i, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNCharacterStream(String s, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(int i, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(int i, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(int i, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateAsciiStream(String s, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBinaryStream(String s, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateCharacterStream(String s, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(int i, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateBlob(String s, InputStream inputStream) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(int i, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateClob(String s, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNClob(int i, Reader reader) throws SQLException {
        throw new SQLException();

    }

    @Override
    public void updateNClob(String s, Reader reader) throws SQLException {
        throw new SQLException();
    }

    @Override
    public <T> T getObject(int i, Class<T> aClass) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T getObject(String s, Class<T> aClass) throws SQLException {
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
