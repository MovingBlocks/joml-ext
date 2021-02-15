// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleiTest {
    static final Vector2ic ZERO = new Vector2i(0, 0);
    static final Vector2ic MIN = new Vector2i(-1, -1);
    static final Vector2ic MAX = new Vector2i(1, 1);
    static final Rectangleic BASE_RECT = new Rectanglei(MIN, MAX);

    static Stream<Arguments> containedRectangles() {
        return Stream.of(
                Arguments.of(new Rectanglei(BASE_RECT)),
                Arguments.of(new Rectanglei(MIN, ZERO)),
                Arguments.of(new Rectanglei(ZERO, MAX))
        );
    }

    /**
     * Rectangles overlapping with BASE_RECT and the intersecting area.
     */
    static Stream<Arguments> overlappingRectangles() {
        return Stream.of(
                Arguments.of(
                        new Rectanglei(MIN.x() - 1, MIN.y() - 1, 0, 0),
                        new Rectanglei(MIN, ZERO)),
                Arguments.of(
                        new Rectanglei(0, 0, MAX.x() + 1, MAX.y() + 1),
                        new Rectanglei(ZERO, MAX))
        );
    }

    /**
     * Rectangles touching one side of BASE_RECT.
     */
    static Stream<Arguments> touchingRectangles() {
        Rectanglei right = new Rectanglei(MAX.x(), MIN.y(), MAX.x() + 1, MAX.y());
        Rectanglei left = new Rectanglei(MIN.x() - 1, MIN.y(), MIN.x(), MAX.y());
        Rectanglei top = new Rectanglei(MIN.x(), MAX.y(), MAX.x(), MAX.y() + 1);
        Rectanglei bottom = new Rectanglei(MIN.x(), MIN.y() - 1, MAX.x(), MIN.y());
        return Stream.of(
                Arguments.of(right),
                Arguments.of(left),
                Arguments.of(top),
                Arguments.of(bottom)
        );
    }

    static Stream<Arguments> invalidRectangles() {
        return Stream.of(
                Arguments.of(new Rectanglei()),                                     // invalid by default
                Arguments.of(new Rectanglei(ZERO)),                                 // a "point"
                Arguments.of(new Rectanglei(MIN.x(), MIN.y(), MAX.x(), MIN.y()))    // a "line"
        );
    }

    @Test
    void containsPoint() {
        Rectanglei rect = new Rectanglei(BASE_RECT);

        assertAll(
                () -> assertTrue(rect.containsPoint(MIN), "minimum corner is inclusive"),
                () -> assertTrue(rect.containsPoint(MAX), "maximum corner is inclusive"),
                () -> assertTrue(rect.containsPoint(0, 0)),
                () -> assertFalse(rect.containsPoint(-2, -2)),
                () -> assertFalse(rect.containsPoint(2, 2))
        );
    }

    @Nested
    class ContainsRectangle {
        @Test
        void containsRectangle() {
            Rectanglei rect = new Rectanglei(BASE_RECT);

            assertAll(
                    () -> assertTrue(rect.containsRectangle(rect),
                            "contains itself"),
                    () -> assertTrue(rect.containsRectangle(new Rectanglei(MIN.x(), MIN.y(), 0, 0)),
                            "minimum corner is inclusive"),
                    () -> assertTrue(rect.containsRectangle(new Rectanglei(0, 0, MAX.x(), MAX.y())),
                            "maximum corner is inclusive"),
                    () -> assertFalse(rect.containsRectangle(new Rectanglei(MIN.x() - 1, MIN.y() - 1, MAX.x() + 1,
                            MAX.x() + 1)))
            );
        }

        @ParameterizedTest
        @MethodSource("org.terasology.joml.geom.RectangleiTest#invalidRectangles")
        void containsRectangleWithInvalid(Rectanglei invalid) {
            Rectanglei rect = new Rectanglei(BASE_RECT);
            assertFalse(rect.containsRectangle(invalid));
        }
    }

    @Nested
    class Intersection {
        @Test
        void intersectionWithSelf() {
            Rectanglei rect = new Rectanglei(BASE_RECT);

            assertEquals(rect, rect.intersection(rect, new Rectanglei()),
                    "intersection with self is identity");
        }

        @Test
        void intersectionWhenContained() {
            Rectanglei rect = new Rectanglei(BASE_RECT);
            Rectanglei bigger = new Rectanglei(MIN.x() - 1, MIN.y() - 1, MAX.x() + 1, MAX.x() + 1);

            assertEquals(rect, rect.intersection(bigger, new Rectanglei()),
                    "intersection when contained in other yields self");
        }

        @Test
        void intersectionWithDisjoint() {
            Rectanglei rect = new Rectanglei(BASE_RECT);
            Rectanglei disjoint = new Rectanglei(7, 7, 42, 42);

            assertFalse(rect.intersection(disjoint, new Rectanglei()).isValid());
        }

        @ParameterizedTest
        @MethodSource("org.terasology.joml.geom.RectangleiTest#invalidRectangles")
        void intersectionWithInvalid(Rectanglei invalid) {
            Rectanglei rect = new Rectanglei(BASE_RECT);
            assertFalse(rect.intersection(invalid, new Rectanglei()).isValid());
        }

        @ParameterizedTest
        @MethodSource("org.terasology.joml.geom.RectangleiTest#containedRectangles")
        void intersectionWhenContaining(Rectanglei other) {
            Rectanglei rect = new Rectanglei(BASE_RECT);

            assertEquals(other, rect.intersection(other), "intersection with contained rectangle yields other");
        }

        @ParameterizedTest
        @MethodSource("org.terasology.joml.geom.RectangleiTest#overlappingRectangles")
        void intersectionWhenPartialOverlap(Rectanglei other, Rectanglei result) {
            Rectanglei rect = new Rectanglei(BASE_RECT);

            assertEquals(result, rect.intersection(other), "intersection with contained rectangle yields other");
        }

        @ParameterizedTest
        @MethodSource("org.terasology.joml.geom.RectangleiTest#touchingRectangles")
        public void intersectionWhenTouching(Rectanglei touching) {
            Rectanglei rect = new Rectanglei(BASE_RECT);
            assertFalse(rect.intersection(touching, new Rectanglei()).isValid());
        }
    }

    @Test
    public void testRectangleSetSize() {
        Rectanglei v1 = new Rectanglei(-1, -1, 1, 1);

        assertEquals(new Rectanglei(0, 0, 2, 2).setSize(3, 3), new Rectanglei(0, 0, 3, 3));
        assertEquals(v1.setSize(3, 3, new Rectanglei()), new Rectanglei(-1, -1, 2, 2));
        assertEquals(v1, new Rectanglei(-1, -1, 1, 1));
    }

    @Nested
    class RectangleFromPoint {

        @Test
        public void isInvalid() {
            Rectanglei rect = new Rectanglei(ZERO);
            assertFalse(rect.isValid());
        }

        @Test
        void containsPoint() {
            Vector2i point = new Vector2i(ZERO);
            Rectanglei rect = new Rectanglei(point);
            assertFalse(rect.containsPoint(point),
                    "rectangle from point is invalid and does not contain itself");
        }

        @Test
        void intersectionWithSelf() {
            Rectanglei rect = new Rectanglei(ZERO);
            assertFalse(rect.intersection(rect, new Rectanglei()).isValid(),
                    "rectangle from point is invalid and does not intersect with itself");
        }
    }
}
