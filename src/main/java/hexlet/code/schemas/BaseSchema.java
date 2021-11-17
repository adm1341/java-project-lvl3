package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> predicateList = new ArrayList<>();

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
    public abstract BaseSchema required();


    /**
     * @param predicate
     */
    protected void addPredicateList(Predicate<Object> predicate) {
        this.predicateList.add(predicate);
    }
}
