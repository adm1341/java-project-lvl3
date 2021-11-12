package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int sizeof = -1;
    private Map<String, BaseSchema> shapeSchem = new HashMap<>();

    @Override
    public boolean isValid(Object objIn) {

        return checkRequired(objIn) && checkSizeof(objIn) && checkShape(objIn);
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

    private boolean checkShape(Object objIn) {
        return shapeSchem.size() <= 0 || !checkNullAndType(objIn) || checkMapNested(objIn);
    }

    private boolean checkMapNested(Object objIn) {
        Map<String, Object> mapIn = (Map<String, Object>) objIn;
        for (Map.Entry<String, Object> entry : mapIn.entrySet()) {
            if (shapeSchem.containsKey(entry.getKey())) {
                BaseSchema schemaCheck = shapeSchem.get(entry.getKey());
                if (!schemaCheck.isValid(entry.getValue())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkSizeof(Object objIn) {
        if (sizeof != -1) {
            if (checkNullAndType(objIn)) {
                Map<Object, Object> mapIn = (Map<Object, Object>) objIn;
                return mapIn.size() >= sizeof;
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

    public MapSchema shape(Map<String, BaseSchema> shapeSchemIn) {
        shapeSchem = shapeSchemIn;
        return this;
    }
}
