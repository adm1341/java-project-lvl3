import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int sizeof = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (this.isRequired()) {
            if (this.isNull(objIn)) {
                return false;
            }
            if (!(objIn instanceof Map)) {
                return false;
            }
            if (sizeof != -1) {
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

    public MapSchema sizeof(int intIn) {
        sizeof = intIn;
        return this;
    }
}
