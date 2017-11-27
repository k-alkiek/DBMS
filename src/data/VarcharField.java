package data;

/**
 * Created by khaled on 11/26/17.
 */
public class VarcharField implements IField {
    private String name;
    private Object defaultValue;


    public VarcharField(String name) {
        this.name = name;
        setDefault(new Object());
    }

    public VarcharField(String name, Object defaultValue) {
        this.name = name;
        setDefault(defaultValue);
    }

    @Override
    public void setDefault(Object defaultValue) {
        this.defaultValue = defaultValue;
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