import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int sizeof = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (!checkRequired(objIn)) {
            return false;
        }
        if (sizeof != -1) {
            if (checkRequired(objIn)) {
                Map<Object, Object> mapIn = (Map) objIn;
                if (mapIn.size() < sizeof) {
                    return false;
                }
            }
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
            if (this.isNull(objIn)) {
                return false;
            }
            return objIn instanceof Map;
        }
        return true;
    }

    public MapSchema sizeof(int intIn) {
        sizeof = intIn;
        return this;
    }
}
