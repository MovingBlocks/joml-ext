// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector3dc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents a ray with a given origin and direction using double-precision floating-point numbers.
 */
public class Rayd implements Externalizable {

    /**
     * The x coordinate of the ray's origin.
     */
    public double oX;
    /**
     * The y coordinate of the ray's origin.
     */
    public double oY;
    /**
     * The z coordinate of the ray's origin.
     */
    public double oZ;
    /**
     * The x coordinate of the ray's direction.
     */
    public double dX;
    /**
     * The y coordinate of the ray's direction.
     */
    public double dY;
    /**
     * The z coordinate of the ray's direction.
     */
    public double dZ;

    /**
     * Create a new {@link Rayd} with origin <code>(0, 0, 0)</code> and no direction.
     */
    public Rayd() {
    }

    /**
     * Create a new {@link Rayd} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Rayd} to copy from
     */
    public Rayd(Rayd source) {
        this.oX = source.oX;
        this.oY = source.oY;
        this.oZ = source.oZ;
        this.dX = source.dX;
        this.dY = source.dY;
        this.dZ = source.dZ;
    }

    /**
     * Create a new {@link Rayd} with the given <code>origin</code> and <code>direction</code>.
     *
     * @param origin
     *          the origin of the ray
     * @param direction
     *          the direction of the ray
     */
    public Rayd(Vector3dc origin, Vector3dc direction) {
        this.oX = origin.x();
        this.oY = origin.y();
        this.oZ = origin.z();
        this.dX = direction.x();
        this.dY = direction.y();
        this.dZ = direction.z();
    }

    /**
     * Create a new {@link Rayd} with the given origin and direction.
     *
     * @param oX
     *          the x coordinate of the ray's origin
     * @param oY
     *          the y coordinate of the ray's origin
     * @param oZ
     *          the z coordinate of the ray's origin
     * @param dX
     *          the x coordinate of the ray's direction
     * @param dY
     *          the y coordinate of the ray's direction
     * @param dZ
     *          the z coordinate of the ray's direction
     */
    public Rayd(double oX, double oY, double oZ, double dX, double dY, double dZ) {
        this.oX = oX;
        this.oY = oY;
        this.oZ = oZ;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(dX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dZ);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(oX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(oY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(oZ);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rayd other = (Rayd) obj;
        if (Double.doubleToLongBits(dX) != Double.doubleToLongBits(other.dX))
            return false;
        if (Double.doubleToLongBits(dY) != Double.doubleToLongBits(other.dY))
            return false;
        if (Double.doubleToLongBits(dZ) != Double.doubleToLongBits(other.dZ))
            return false;
        if (Double.doubleToLongBits(oX) != Double.doubleToLongBits(other.oX))
            return false;
        if (Double.doubleToLongBits(oY) != Double.doubleToLongBits(other.oY))
            return false;
        if (Double.doubleToLongBits(oZ) != Double.doubleToLongBits(other.oZ))
            return false;
        return true;
    }

    /**
     * Return a string representation of this ray.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this ray by formatting the vector components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the vector components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(oX, formatter) + " " + Runtime.format(oY, formatter) + " " + Runtime.format(oZ, formatter) + ") -> "
             + "(" + Runtime.format(dX, formatter) + " " + Runtime.format(dY, formatter) + " " + Runtime.format(dZ, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(oX);
        out.writeDouble(oY);
        out.writeDouble(oZ);
        out.writeDouble(dX);
        out.writeDouble(dY);
        out.writeDouble(dZ);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        oX = in.readDouble();
        oY = in.readDouble();
        oZ = in.readDouble();
        dX = in.readDouble();
        dY = in.readDouble();
        dZ = in.readDouble();
    }

}
