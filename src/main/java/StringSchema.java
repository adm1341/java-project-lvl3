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
        if (!checkContains(objIn) || !checkMinLength(objIn)) {
            return false;
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
            return checkNullAndType(objIn);
        }
        return true;
    }

    private boolean checkNullAndType(Object objIn) {
        return !this.isNull(objIn) && objIn instanceof String;
    }

    private boolean checkContains(Object objIn) {
        if (!contains.isEmpty()) {
            if (checkNullAndType(objIn)) {
                String strIn = (String) objIn;
                if (!strIn.contains(contains)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkMinLength(Object objIn) {
        if (minLength != -1) {
            if (checkNullAndType(objIn)) {
                String strIn = (String) objIn;
                if (!(strIn.trim().length() == minLength || strIn.trim().length() < minLength)) {
                    return false;
                }
            }
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
