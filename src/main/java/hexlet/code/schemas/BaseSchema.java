package hexlet.code.schemas;

public class BaseSchema {
    private boolean required;

    /**
     * @param objIn
     * @return boolean
     */
    public final boolean isNull(Object objIn) {
        return objIn == null;
    }

    /**
     * @param objIn
     * @return boolean
     */
    public boolean isValid(Object objIn) {
        return !isNull(objIn);
    }

    /**
     * @return Schem
     */
    public BaseSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * @return required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param requiredIn
     */
    public void setRequired(boolean requiredIn) {
        this.required = requiredIn;
    }
}
