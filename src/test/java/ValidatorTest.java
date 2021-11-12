import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    static final int SEVEN = 7;
    @Test
    public void testInstantStringSchema() {
        Validator v = new Validator();

        assertTrue(v.string() instanceof StringSchema);
    }

    @Test
    public void testInstantNumberSchema() {
        Validator v = new Validator();

        assertTrue(v.number() instanceof NumberSchema);
    }

    @Test
    public void testInstantMapSchema() {
        Validator v = new Validator();

        assertTrue(v.map() instanceof MapSchema);
    }

    @Test
    public void testHehletTest() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(SEVEN);
        assertTrue(schema.isValid("what does the fox say"));

        NumberSchema schemaNum = v.number();
        schemaNum.positive().required();
        assertFalse(schemaNum.isValid(0));
    }
}
