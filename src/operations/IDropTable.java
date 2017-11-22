package operations;

/**
 * Created by khaled on 11/20/17.
 */
public interface IDropTable extends IBooleanOperation{
    void setName(String name);
    void setDatabase(IDatabase database);
}
