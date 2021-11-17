package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean required;
    private final List<Predicate<Object>>  predicateList = new ArrayList<>();

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

        for (Predicate<Object> predicate : this.predicateList) {
            if (predicate.test(objIn)) {
                return false;
            }
        }
        return true;
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

    /**
     * @param predicate
     */
    protected void addPredicateList(Predicate<Object> predicate) {
        this.predicateList.add(predicate);
    }
}
