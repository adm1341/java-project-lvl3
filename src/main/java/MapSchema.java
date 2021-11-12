import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int sizeof = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (!checkRequired(objIn) || !checkSizeof(objIn)) {
            return false;
        }
        return true;
    }

    @Override
    public MapSchema required() {
        setRequired(true);
        return this;
    }

    private boolean checkRequired(Object objIn) {
        if (this.isRequired()) {
            return checkNullAndType(objIn);
        }
        return true;
    }

    private boolean checkSizeof(Object objIn) {
        if (sizeof != -1) {
            if (checkNullAndType(objIn)) {
                Map<Object, Object> mapIn = (Map) objIn;
                if (mapIn.size() < sizeof) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkNullAndType(Object objIn) {
        return !this.isNull(objIn) && objIn instanceof Map;
    }

    public MapSchema sizeof(int intIn) {
        sizeof = intIn;
        return this;
    }
}
