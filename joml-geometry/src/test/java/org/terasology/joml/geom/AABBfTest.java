package org.terasology.joml.geom;

import org.joml.Vector3f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AABBfTest {
    @Test
    public void testAABBfForPoint() {
        assertFalse(new AABBf(new Vector3f(0,0,0)).containsPoint(0,0,0));
        assertFalse(new AABBf(new Vector3f(.5f,.5f,.5f)).containsPoint(.5f,.5f,.5f));
    }
}
