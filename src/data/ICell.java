package data;

/**
 * Created by khaled on 11/22/17.
 */
public interface ICell {
    Object getData() throws TypeNotPresentException;
    void setData(Object data);
}
