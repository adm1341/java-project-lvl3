package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotString = x -> !(x instanceof String);
        Predicate<Object> isEmpty = x -> ((String) x).trim().isEmpty();
        addPredicateList(isNull);
        addPredicateList(isNotString);
        addPredicateList(isEmpty);
        return this;
    }

    public StringSchema contains(String strIn) {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotString = x -> !(x instanceof String);
        Predicate<Object> isNoContains = x -> !((String) x).contains(strIn);
        addPredicateList(isNull);
        addPredicateList(isNotString);
        addPredicateList(isNoContains);
        return this;
    }

    public StringSchema minLength(int intIn) {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotString = x -> !(x instanceof String);

        Predicate<Object> isLengthEqMinLenLength = x -> ((String) x).trim().length() == intIn;
        Predicate<Object> isLengthMoreMinLenLength = x -> ((String) x).trim().length() > intIn;
        Predicate<Object> isNotCorrectLength = isLengthEqMinLenLength.or(isLengthMoreMinLenLength).negate();

        addPredicateList(isNull);
        addPredicateList(isNotString);
        addPredicateList(isNotCorrectLength);
        return this;
    }
}
