package org.terasology.joml.test;

import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

public class VectorAssert {

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
