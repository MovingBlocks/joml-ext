package org.terasology.joml.test;

import org.apiguardian.api.API;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

import static org.apiguardian.api.API.Status.STABLE;
import static org.junit.jupiter.api.Assertions.assertAll;

@API(status = STABLE, since = "1.0")
public class VectorAssert {

    /**
     * Precision for methods that do many operations calculating with a magnitude around zero, giving less accuracy.
     */
    public static final float MANY_OPS_AROUND_ZERO_PRECISION_FLOAT = 0.001f;
    /**
     * Precision for methods that do basic operations calculating with a magnitude around zero.
     */
    public static final float STANDARD_AROUND_ZERO_PRECISION_FLOAT = 0.000000000000000001f;

    /**
     * Precision for methods that do many operations calculating with values with a magnitude around zero, giving less accuracy.
     */
    public static final double MANY_OPS_AROUND_ZERO_PRECISION_DOUBLE = 0.00001;
    /**
     * Precision for methods that do basic operations calculating with a magnitude around zero.
     */
    public static final double STANDARD_AROUND_ZERO_PRECISION_DOUBLE = 0.000000000000000000001;

    public static void assertEquals(Vector3fc expected, Vector3fc actual, float epsilon) {
        if (expected == null) {
            if (actual == null) {
                return;
            }
            failNotEqual(expected, actual);
            return;
        }

        if (!expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector3dc expected, Vector3dc actual, double epsilon) {
        if (expected == null) {
            if (actual == null) {
                return;
            }
            failNotEqual(expected, actual);
            return;
        }
        if (!expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector2fc expected, Vector2fc actual, float epsilon) {
        if (expected == null) {
            if (actual == null) {
                return;
            }
            failNotEqual(expected, actual);
            return;
        }
        if (!expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector2dc expected, Vector2dc actual, double epsilon) {
        if (expected == null) {
            if (actual == null) {
                return;
            }
            failNotEqual(expected, actual);
            return;
        }
        if (!expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    private static void failNotEqual(Object expected, Object actual) {
        String expectedString = StringUtils.nullSafeToString(expected);
        String actualString = StringUtils.nullSafeToString(actual);
        throw new AssertionFailedError(String.format("expected: %s but was: %s", expectedString, actualString), expected, actual);
    }
}
