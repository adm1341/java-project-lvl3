public final class NumberSchema extends BaseSchema {

    private boolean positive;
    private int one = -1;
    private int two = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (!checkRequired(objIn)) {
            return false;
        }
        if (this.positive) {
            if (checkRequired(objIn)) {
                if (((Integer) objIn) < 0) {
                    return false;
                }
            }
        }
        if (one != -1 || two != -1) {
            if (checkRequired(objIn)) {
                int integer = ((Integer) objIn);
                if (!(integer >= one && integer <= two)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    private boolean checkRequired(Object objIn) {
        if (this.isRequired()) {
            if (this.isNull(objIn)) {
                return false;
            }
            return objIn instanceof Integer;
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
