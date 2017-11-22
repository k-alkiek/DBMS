package data;

/**
 * Created by khaled on 11/22/17.
 */
public interface IField {
    void setDefault(ICell defaultCell);
    void setName(String name);
    String getName();
    Class getType();
}
