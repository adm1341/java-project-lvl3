package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    @Override
    public NumberSchema required() {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotInteger = x -> !(x instanceof Integer);
        addPredicateList(isNull);
        addPredicateList(isNotInteger);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotInteger = x -> !(x instanceof Integer);

        Predicate<Object> isNotPositive = x -> !(((Integer) x) > 0);

        Predicate<Object> predicate = x -> {
            if (isNull.test(x) || isNotInteger.test(x)) {
                return false;
            } else {
                return isNotPositive.test(x);
            }
        };
        addPredicateList(predicate);
        return this;
    }

    public NumberSchema range(int oneIn, int twoIn) {
        Predicate<Object> isNull = Objects::isNull;
        Predicate<Object> isNotInteger = x -> !(x instanceof Integer);

        Predicate<Object> isMoreOne = x -> ((Integer) x) >= oneIn;
        Predicate<Object> isLessTwo = x -> ((Integer) x) <= twoIn;
        Predicate<Object> isNotRange = isMoreOne.and(isLessTwo).negate();
        addPredicateList(isNull);
        addPredicateList(isNotInteger);
        addPredicateList(isNotRange);
        return this;
    }


}
