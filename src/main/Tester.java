package main;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class Tester {
    @Test
    public void test1() throws SQLException {
        assertTrue(QueryCommiter.executeStructureQuery("CrEatE DataBase Database1"));
        assertTrue(QueryCommiter.executeStructureQuery("CREATE TABLE Table1(\n" +
                "   ID   INT              ,\n" +
                "   NAME VARCHAR ,\n" +
                "   AGE  INT     ,\n" +
                ");"));
        assertEquals(1,QueryCommiter.executeUpdateQuery("INsERt InTO Table1 VALUES (1,\"Ayman\",13);"));
    }
}
