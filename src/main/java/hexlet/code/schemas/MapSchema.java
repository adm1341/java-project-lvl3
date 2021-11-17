package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    @Override
    public MapSchema required() {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotMap = x -> !(x instanceof Map);
        addPredicateList(isNull);
        addPredicateList(isNotMap);
        return this;
    }

    public MapSchema sizeof(int intIn) {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotMap = x -> !(x instanceof Map);

        Predicate<Object> isNotSizeof = x -> !(((Map<Object, Object>) x).size() >= intIn);
        addPredicateList(isNull);
        addPredicateList(isNotMap);
        addPredicateList(isNotSizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> shapeSchemIn) {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotMap = x -> !(x instanceof Map);

        Predicate<Object> predicate = x ->
                ((Map<Object, Object>) x).entrySet()
                        .stream()
                        .filter(z -> !shapeSchemIn.get(z.getKey()).isValid(z.getValue())).count() > 0;

        addPredicateList(isNull);
        addPredicateList(isNotMap);
        addPredicateList(predicate);

        return this;
    }
}
