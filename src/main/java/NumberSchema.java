public final class NumberSchema extends BaseSchema {

    private boolean positive;
    private int one = -1;
    private int two = -1;

    @Override
    public boolean isValid(Object objIn) {

        return checkRequired(objIn) && checkPositive(objIn) && checkRange(objIn);
    }

    @Override
    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    private boolean checkRequired(Object objIn) {
        if (this.isRequired()) {
            return checkNullAndType(objIn);
        }
        return true;
    }

    private boolean checkNullAndType(Object objIn) {
        return !this.isNull(objIn) && objIn instanceof Integer;
    }

    private boolean checkPositive(Object objIn) {
        if (this.positive) {
            if (checkNullAndType(objIn)) {
                return ((Integer) objIn) >= 0;
            }
        }
        return true;
    }

    private boolean checkRange(Object objIn) {
        if (one != -1 || two != -1) {
            if (checkNullAndType(objIn)) {
                int integer = ((Integer) objIn);
                return integer >= one && integer <= two;
            }
        }
        return true;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(int oneIn, int twoIn) {
        one = oneIn;
        two = twoIn;
        return this;
    }


}
