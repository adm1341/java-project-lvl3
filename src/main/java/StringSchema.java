public final class StringSchema {
    private boolean required;
    private String contains = "";
    private int minLength = -1;

    public boolean isValid(String strIn) {

        if (required) {
            if (strIn == null) {
                return false;
            } else {
                return !strIn.trim().isEmpty();
            }
        } else if (!contains.isEmpty()) {
            return strIn.contains(contains);
        } else if (minLength != -1) {
            return strIn.trim().length() == minLength || strIn.trim().length() < minLength;
        }
        return true;
    }

    public void required() {
        nullMode();
        required = true;
    }

    private void nullMode() {
        required = false;
        contains = "";
        minLength = -1;
    }

    public StringSchema contains(String strIn) {
        nullMode();
        contains = strIn;
        return this;
    }

    public StringSchema minLength(int intIn) {
        nullMode();
        minLength = intIn;
        return this;
    }
}
