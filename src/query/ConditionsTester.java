package query;

import data.IRecord;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConditionsTester {
    @Test
    public void trueConditionTest(){
        ICondition condition = new TrueCondition();
        IRecord record1 = new TestingRecord();
        assertTrue(condition.validate(record1));

        record1.setAttribute("name","ss");
        assertTrue(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        assertTrue(condition.validate(record2));
        record2.setAttribute("Number",11);
        assertTrue(condition.validate(record2));
    }
    @Test
    public void falseConditionTest(){
        ICondition condition = new FalseCondition();
        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        record1.setAttribute("name","ss");
        assertFalse(condition.validate(record1));
        IRecord record2 = new TestingRecord();
        assertFalse(condition.validate(record2));
        record2.setAttribute("Number",11);
        assertFalse(condition.validate(record2));
    }
    @Test
    public void equalConditionTest(){
        ICondition condition = new EqualCondition("name","ss");

        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        record2.setAttribute("name","ss");
        assertTrue(condition.validate(record2));

        IRecord record3 = new TestingRecord();
        record3.setAttribute("secondName","ss");
        assertFalse(condition.validate(record3));

        ICondition condition2 = new EqualCondition("age",11);

        IRecord record4 = new TestingRecord();
        assertFalse(condition2.validate(record4));

        IRecord record5 = new TestingRecord();
        record5.setAttribute("age",11);
        assertTrue(condition2.validate(record5));

        IRecord record6 = new TestingRecord();
        record6.setAttribute("secondName",11);
        assertFalse(condition2.validate(record6));

        IRecord record7 = new TestingRecord();
        record7.setAttribute("age",11);
        assertTrue(condition2.validate(record7));
    }
    @Test
    public void biggerThanConditionTest(){
        ICondition condition = new BiggerThanCondition("name","ss");

        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        record2.setAttribute("name","ss");
        assertFalse(condition.validate(record2));

        IRecord record3 = new TestingRecord();
        record3.setAttribute("secondName","ss");
        assertFalse(condition.validate(record3));

        ICondition condition2 = new BiggerThanCondition("age",11);

        IRecord record4 = new TestingRecord();
        assertFalse(condition2.validate(record4));

        IRecord record5 = new TestingRecord();
        record5.setAttribute("age",12);
        assertTrue(condition2.validate(record5));

        IRecord record6 = new TestingRecord();
        record6.setAttribute("age",11);
        assertFalse(condition2.validate(record6));

        IRecord record7 = new TestingRecord();
        record7.setAttribute("age",10);
        assertFalse(condition2.validate(record7));

        IRecord record8 = new TestingRecord();
        record8.setAttribute("Age",12);
        assertFalse(condition2.validate(record8));
    }
    @Test
    public void smallerThanConditionTest(){
        ICondition condition = new SamllerThanCondition("name","ss");

        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        record2.setAttribute("name","ss");
        assertFalse(condition.validate(record2));

        IRecord record3 = new TestingRecord();
        record3.setAttribute("secondName","ss");
        assertFalse(condition.validate(record3));

        ICondition condition2 = new SamllerThanCondition("age",11);

        IRecord record4 = new TestingRecord();
        assertFalse(condition2.validate(record4));

        IRecord record5 = new TestingRecord();
        record5.setAttribute("age",12);
        assertFalse(condition2.validate(record5));

        IRecord record6 = new TestingRecord();
        record6.setAttribute("age",11);
        assertFalse(condition2.validate(record6));

        IRecord record7 = new TestingRecord();
        record7.setAttribute("age",10);
        assertTrue(condition2.validate(record7));

        IRecord record8 = new TestingRecord();
        record8.setAttribute("Age",10);
        assertFalse(condition2.validate(record8));
    }
    @Test
    public void biggerThanOrEqualConditionTest(){
        ICondition condition = new BiggerThanOrEqualCondition("name","ss");

        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        record2.setAttribute("name","ss");
        assertTrue(condition.validate(record2));

        IRecord record3 = new TestingRecord();
        record3.setAttribute("secondName","ss");
        assertFalse(condition.validate(record3));

        ICondition condition2 = new BiggerThanOrEqualCondition("age",11);

        IRecord record4 = new TestingRecord();
        assertFalse(condition2.validate(record4));

        IRecord record5 = new TestingRecord();
        record5.setAttribute("age",12);
        assertTrue(condition2.validate(record5));

        IRecord record6 = new TestingRecord();
        record6.setAttribute("age",11);
        assertTrue(condition2.validate(record6));

        IRecord record7 = new TestingRecord();
        record7.setAttribute("age",10);
        assertFalse(condition2.validate(record7));

        IRecord record8 = new TestingRecord();
        record8.setAttribute("Age",12);
        assertFalse(condition2.validate(record8));
    }
    @Test
    public void smallerThanOrEqualConditionTest(){
        ICondition condition = new SamllerThanOrEqualCondition("name","ss");

        IRecord record1 = new TestingRecord();
        assertFalse(condition.validate(record1));

        IRecord record2 = new TestingRecord();
        record2.setAttribute("name","ss");
        assertTrue(condition.validate(record2));

        IRecord record3 = new TestingRecord();
        record3.setAttribute("secondName","ss");
        assertFalse(condition.validate(record3));

        ICondition condition2 = new SamllerThanOrEqualCondition("age",11);

        IRecord record4 = new TestingRecord();
        assertFalse(condition2.validate(record4));

        IRecord record5 = new TestingRecord();
        record5.setAttribute("age",12);
        assertFalse(condition2.validate(record5));

        IRecord record6 = new TestingRecord();
        record6.setAttribute("age",11);
        assertTrue(condition2.validate(record6));

        IRecord record7 = new TestingRecord();
        record7.setAttribute("age",10);
        assertTrue(condition2.validate(record7));

        IRecord record8 = new TestingRecord();
        record8.setAttribute("Age",10);
        assertFalse(condition2.validate(record8));
    }
    private class TestingRecord implements IRecord {
        HashMap<String,Object> map = new HashMap<>();
        @Override
        public Object getAttribute(String fieldName) {
            return map.get(fieldName);
        }

        @Override
        public void setAttribute(String fieldName, Object data) {
            map.put(fieldName,data);
        }
    }
}
