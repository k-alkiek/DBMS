package eg.edu.alexu.csd.oop.db.cs15;

import data.TableXML;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class ResultSetMetaDataImp implements ResultSetMetaData {
    TableXML table ;
    public ResultSetMetaDataImp (TableXML table) {
        this.table = table;
    }
    @Override
    public int getColumnCount() throws SQLException {

        try {
            return table.getFields().size();

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
            return table.getFields().get(i).getName();

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
            return table.getName();

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
            if (table.getFields().get(i).getType().equals("VarcharField")) {
                return Types.VARCHAR;
            }
            else if (table.getFields().get(i).getType().equals( "IntField" )) {
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
