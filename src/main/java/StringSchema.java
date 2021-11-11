public final class StringSchema extends BaseSchema {

    private String contains = "";
    private int minLength = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (this.isRequired()) {
            if (this.isNull(objIn)) {
                return false;
            }
            if (!(objIn instanceof String)) {
                return false;
            }
            String strIn = (String) objIn;
            if (strIn.trim().isEmpty()) {
                return false;
            }
            if (!contains.isEmpty()) {
                if (!strIn.contains(contains)) {
                    return false;
                }
            }
            if (minLength != -1) {
                if (!(strIn.trim().length() == minLength || strIn.trim().length() < minLength)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public StringSchema required() {
        setRequired(true);
        return this;
    }

    public StringSchema contains(String strIn) {
        contains = strIn;
        return this;
    }

    public StringSchema minLength(int intIn) {
        minLength = intIn;
        return this;
    }
}
