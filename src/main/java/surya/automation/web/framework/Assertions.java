package surya.automation.web.framework;

import org.testng.asserts.SoftAssert;

/**
 * This class implements Soft Assertions.
 * SOFT ASSERTIONS :
 * A soft assertion continues with the next step of the test execution even if the assertion condition is not met.
 */
public class Assertions {
    SoftAssert softassert = new SoftAssert();

    protected Assertions assertEquals(Object actualValue, Object expectedValue) {
        softassert.assertEquals(actualValue, expectedValue);
        softassert.assertAll();
        return new Assertions();
    }

    protected Assertions assertTrue(Boolean condition) {
        softassert.assertTrue(condition);
        return new Assertions();
    }

    protected Assertions assertTrue(Boolean condition, String message) {
        softassert.assertTrue(condition, message);
        return new Assertions();
    }

    protected Assertions assertFalse(Boolean condition) {
        softassert.assertFalse(condition);
        return new Assertions();
    }

    protected Assertions assertFalse(Boolean condition, String message) {
        softassert.assertFalse(condition, message);
        return new Assertions();
    }
}
