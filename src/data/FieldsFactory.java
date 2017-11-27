package data;

import java.util.List;

/**
 * Created by khaled on 11/27/17.
 */
public class FieldsFactory {
    public static IField create(String className, String fieldName) throws IllegalAccessException, InstantiationException {
        if (className.equals("VarcharField") || className.equals("varchar")) {
            return new VarcharField(fieldName);
        }
        else if (className.equals("IntField") || className.equals("int")) {
            return new IntField(fieldName);
        }
        else {
            return null;
        }
    }
}
