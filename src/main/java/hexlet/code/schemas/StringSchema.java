package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private String contains = "";
    private int minLength = -1;

    @Override
    public boolean isValid(Object objIn) {
        return checkRequired(objIn) && checkContains(objIn) && checkMinLength(objIn);
    }

    @Override
    public StringSchema required() {
        setRequired(true);
        return this;
    }

    private boolean checkRequired(Object objIn) {
        if (this.isRequired()) {
            if (!checkNullAndType(objIn)) {
                return false;
            }
            String strIn = (String) objIn;
            return !strIn.trim().isEmpty();
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
                return strIn.contains(contains);
            }
        }
        return true;
    }

    private boolean checkMinLength(Object objIn) {
        if (minLength != -1) {
            if (checkNullAndType(objIn)) {
                String strIn = (String) objIn;
                return strIn.trim().length() == minLength || strIn.trim().length() > minLength;
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
