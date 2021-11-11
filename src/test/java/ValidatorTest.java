import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
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
}
