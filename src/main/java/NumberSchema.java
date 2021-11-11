public final class NumberSchema extends BaseSchema {

    private boolean positive;
    private int one = -1;
    private int two = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (this.isRequired()) {
            if (this.isNull(objIn)) {
                return false;
            }
            if (!(objIn instanceof Integer)) {
                return false;
            }
            if (this.positive) {
                if (((Integer) objIn) < 0) {
                    return false;
                }
            }
            if (one != -1 || two != -1) {
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
