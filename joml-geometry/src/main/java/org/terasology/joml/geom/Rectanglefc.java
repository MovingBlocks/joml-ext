// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Math;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

public interface Rectanglefc {

    float minX();

    float minY();

    float maxX();

    float maxY();

    /**
     * Return the length of the rectangle in the X dimension.
     *
     * @return length in the X dimension
     */
    float getSizeX();

    /**
     * Return the length of the rectangle in the Y dimension.
     *
     * @return length in the Y dimension
     */
    float getSizeY();

    /**
     * Return the size of this rectangle in the X and Y dimensions and store the result in <code>dest</code>.
     *
     * @param dest will hold the result
     * @return dest
     */
    Vector2f getSize(Vector2f dest);

    /**
     * Set the size of the rectangle minimum corner.
     *
     * @param dx the size along the x component
     * @param dy the size along the y component
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef setSize(float dx, float dy, Rectanglef dest);

    /**
     * Set the size of the rectangle from the minimum corner.
     *
     * @param size the size along x/y/z
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef setSize(Vector2fc size, Rectanglef dest);

    /**
     * Set the size of the rectangle from the minimum corner.
     *
     * @param size the size along x/y/z
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef setSize(Vector2dc size, Rectanglef dest);

    /**
     * Return the area of the rectangle
     *
     * @return area
     */
    float area();

    /**
     * Check whether <code>this</code> rectangle represents a valid rectangle.
     *
     * @return <code>true</code> iff this rectangle is valid; <code>false</code> otherwise
     */
    boolean isValid();

    /**
     * Compute the union of <code>this</code> and the given point <code>(x, y, z)</code> and store the result in
     * <code>dest</code>.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef union(float x, float y, Rectanglef dest);

    /**
     * Compute the union of <code>this</code> and the given point <code>p</code> and store the result in
     * <code>dest</code>.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef union(Vector2ic p, Rectanglef dest);

    /**
     * Compute the union of <code>this</code> and <code>other</code> and store the result in <code>dest</code>.
     *
     * @param other the other {@link Rectanglef}
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef union(Rectanglef other, Rectanglef dest);

    /**
     * Translate <code>this</code> by the given vector <code>xy</code> and store the result in <code>dest</code>.
     *
     * @param xy the vector to translate by
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef translate(Vector2fc xy, Rectanglef dest);

    /**
     * Translate <code>this</code> by the vector <code>(x, y)</code> and store the result in <code>dest</code>.
     *
     * @param x the x coordinate to translate by
     * @param y the y coordinate to translate by
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef translate(float x, float y, Rectanglef dest);

    /**
     * Scale <code>this</code> about the origin and store the result in <code>dest</code>.
     *
     * @param sf the scaling factor in the x and y axis
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sf, Rectanglef dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(-ax, -ay, dest).scale(sf).translate(ax, ay)</code>
     *
     * @param sf the scaling factor in the x and y axis
     * @param ax the x coordinate of the anchor
     * @param ay the y coordinate of the anchor
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sf, float ax, float ay, Rectanglef dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(anchor.negate(), dest).scale(sx, sy).translate(anchor.negate())</code>
     *
     * @param sx the scaling factor on the x axis
     * @param sy the scaling factor on the y axis
     * @param anchor the location of the anchor
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sx, float sy, Vector2fc anchor, Rectanglef dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(anchor.negate(), dest).scale(sf).translate(anchor.negate())</code>
     *
     * @param sf the scaling factor in the x and y axis
     * @param anchor the location of the anchor
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sf, Vector2fc anchor, Rectanglef dest);

    /**
     * Scale <code>this</code> about the origin and store the result in <code>dest</code>.
     *
     * @param sx the scaling factor on the x axis
     * @param sy the scaling factor on the y axis
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sx, float sy, Rectanglef dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(-ax, -ay, dest).scale(sx, sy).translate(ax, ay)</code>
     *
     * @param sx the scaling factor on the x axis
     * @param sy the scaling factor on the y axis
     * @param ax the x coordinate of the anchor
     * @param ay the y coordinate of the anchor
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef scale(float sx, float sy, float ax, float ay, Rectanglef dest);

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectangledc rectangle);

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectanglefc rectangle);

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectangleic rectangle);

    /**
     * Check if this rectangle contains the given <code>point</code>.
     *
     * @param point the point to test
     * @return <code>true</code> iff this rectangle contains the point; <code>false</code> otherwise
     */
    boolean containsPoint(Vector2ic point);

    /**
     * Check if this rectangle contains the given point <code>(x, y)</code>.
     *
     * @param x the x coordinate of the point to check
     * @param y the y coordinate of the point to check
     * @return <code>true</code> iff this rectangle contains the point; <code>false</code> otherwise
     */
    boolean containsPoint(int x, int y);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this rectangle.
     *
     * @param point the point to test
     * @return <code>true</code> iff the given point lies inside this rectangle; <code>false</code> otherwise
     */
    boolean containsPoint(Vector2fc point);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this rectangle.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return <code>true</code> iff the given point lies inside this rectangle; <code>false</code> otherwise
     */
    boolean containsPoint(float x, float y);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this rectangle.
     *
     * @param point the point to test
     * @return <code>true</code> iff the given point lies inside this rectangle; <code>false</code> otherwise
     */
    boolean containsPoint(Vector2dc point);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this rectangle.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return <code>true</code> iff the given point lies inside this rectangle; <code>false</code> otherwise
     */
    boolean containsPoint(double x, double y);

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectangled other);

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectanglef other);

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectanglei other);

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle and store the result in
     * <code>dest</code>.
     * <p>
     * If the two rectangles do not intersect, then {@link Float#NaN} is stored in each component of <code>dest</code>.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef intersection(Rectanglef other, Rectanglef dest);

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle and store the result in
     * <code>dest</code>.
     * <p>
     * If the two rectangles do not intersect, then {@link Double#NaN} is stored in each component of
     * <code>dest</code>.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    Rectanglef intersection(Rectanglei other, Rectanglef dest);

    /**
     * Computes the squared distance to a given point
     *
     * @param point the point
     * @return the squared distance between point and this rectangle
     */
    default float distanceSquared(Vector2fc point) {
        return distanceSquared(point.x(), point.y());
    }

    /**
     * Computes the squared distance to a given point
     *
     * @param px the point x coordinate
     * @param py the point y coordinate
     * @return the squared distance between point and this rectangle
     * @see
     * <a href="https://codereview.stackexchange.com/questions/175566/compute-shortest-distance-between-point-and-a-rectangle">
     *         Compute Shortest Distance Between Point and a Rectangle</a>
     */
    default float distanceSquared(float px, float py) {
        //     center = min + width / 2 = min + (max - min) / 2
        // 2 * center = 2 * min + max - min = min + max
        float cx2 = minX() + maxX();
        float cy2 = minY() + maxY();

        //     dx = p - center - width / 2
        // 2 * dx = 2 * px - 2 * center - width
        //     dx = (2 * px - 2 * center - width) / 2
        float dx = Math.max(Math.abs(2 * px - cx2) - getSizeX(), 0) / 2f;
        float dy = Math.max(Math.abs(2 * py - cy2) - getSizeY(), 0) / 2f;
        return dx * dx + dy * dy;
    }
}
