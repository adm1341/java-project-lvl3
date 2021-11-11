public final class StringSchema extends BaseSchema {

    private String contains = "";
    private int minLength = -1;

    @Override
    public boolean isValid(Object objIn) {

        if (!checkRequired(objIn)) {
            return false;
        } else if (this.isRequired()) {
            String strIn = (String) objIn;
            if (strIn.trim().isEmpty()) {
                return false;
            }
        }
        if (!contains.isEmpty()) {
            if (checkRequired(objIn)) {
                String strIn = (String) objIn;
                if (!strIn.contains(contains)) {
                    return false;
                }
            }
        }
        if (minLength != -1) {
            if (checkRequired(objIn)) {
                String strIn = (String) objIn;
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

    private boolean checkRequired(Object objIn) {
        if (this.isRequired()) {
            if (this.isNull(objIn)) {
                return false;
            }
            return objIn instanceof String;
        }
        return true;
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
