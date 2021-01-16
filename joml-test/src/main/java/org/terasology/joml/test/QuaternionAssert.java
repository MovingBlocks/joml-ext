package org.terasology.joml.test;

import org.joml.Quaterniondc;
import org.joml.Quaternionfc;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

public class QuaternionAssert {
    public static void assertEquals(Quaternionfc expected, Quaternionfc actual, float epsilon) {
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

    public static void assertEquals(Quaterniondc expected, Quaterniondc actual, float epsilon) {
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
