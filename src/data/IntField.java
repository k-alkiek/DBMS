package data;

/**
 * Created by khaled on 11/26/17.
 */
public class IntField implements IField {
    String name;
    ICell defaultCell;


    public IntField(String name) {
        this.name = name;
        setDefault(new Cell(this, 0));
    }

    public IntField(String name, ICell defaultCell) {
        this.name = name;
        setDefault(defaultCell);
    }

    @Override
    public void setDefault(ICell defaultCell) {
        this.defaultCell = defaultCell;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getType() {
        return this.getClass();
    }
}
