package eg.edu.alexu.csd.oop.db.cs15;

import data.TableXML;
import data.VarcharField;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMetaDataImp implements ResultSetMetaData {
    TableXML table ;
    Object[][] values;
    List<String> fieldsName = new ArrayList<>();
    String tableName;
    public ResultSetMetaDataImp (Object[][] values, List<String> fieldsName, String tableName) {
        this.values = values;
        this.fieldsName = fieldsName;
        this.tableName = tableName;
    }
    private int getsize() {
        return values.length;
    }
    @Override
    public int getColumnCount() throws SQLException {

        try {
            return getsize();

        } catch (Exception e) {

            throw new SQLException();
        }
    }
    @Override
    public boolean isAutoIncrement(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCaseSensitive(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSearchable(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCurrency(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int isNullable(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSigned(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getColumnDisplaySize(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getColumnLabel(int i) throws SQLException {

        throw new UnsupportedOperationException();
    }

    @Override
    public String getColumnName(int i) throws SQLException {
        try {
            if(i - 1 >= fieldsName.size()){
                throw new SQLException();
            }
            return fieldsName.get(i - 1);

        } catch (Exception e) {

            throw new SQLException();
        }    }

    @Override
    public String getSchemaName(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPrecision(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getScale(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTableName(int i) throws SQLException {
        try {
            return tableName;

        } catch (Exception e) {

            throw new SQLException();
        }    }

    @Override
    public String getCatalogName(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getColumnType(int i) throws SQLException {

        try {
            if (values[0][ i - 1] instanceof String) {
                return Types.VARCHAR;
            }
            else if (values[0][i - 1] instanceof Integer) {
                return Types.INTEGER;
            }
            throw new SQLException();

        } catch (Exception e) {

            throw new SQLException();
        }
    }

    @Override
    public String getColumnTypeName(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isReadOnly(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWritable(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefinitelyWritable(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getColumnClassName(int i) throws SQLException {
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
