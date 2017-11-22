package data;

/**
 * Created by khaled on 11/22/17.
 */
public interface IRecord {
    Object getAttribute(String fieldName);
    void setAttribute(String fieldName, Object data);
}
