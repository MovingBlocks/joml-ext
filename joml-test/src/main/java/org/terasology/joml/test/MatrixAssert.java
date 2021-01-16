package org.terasology.joml.test;

import org.joml.Matrix3fc;
import org.joml.Matrix4fc;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

public class MatrixAssert {
    public static void assertEquals(Matrix4fc expected, Matrix4fc actual, float epsilon) {
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

    public static void assertEquals(Matrix3fc expected, Matrix3fc actual, float epsilon) {
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
        throw new AssertionFailedError("expected: %s but was: %s", expectedString, actualString);
    }
}
