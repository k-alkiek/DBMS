package data;

/**
 * Created by khaled on 11/26/17.
 */
public class VarcharField implements IField {
    String name;
    ICell defaultCell;


    public VarcharField(String name) {
        this.name = name;
        setDefault(new Cell(this, ""));
    }

    public VarcharField(String name, ICell defaultCell) {
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