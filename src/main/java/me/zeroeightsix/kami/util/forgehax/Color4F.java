/*
 * This code is licensed under the following license
 *
 * MIT License
 *
 * Copyright (c) 2017 Matthew Crawford
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package me.zeroeightsix.kami.util.forgehax;

import java.util.Arrays;

/**
 * Created on 2/6/2018 by fr1kin
 */
public class Color4F extends Color {

    private static final Color FACTORY = new Color4F();

    public static Color getFactory() {
        return FACTORY;
    }

    //
    //
    //

    private final float[] color = new float[4];

    private Color4F() {
    }

    private Color4F(float red, float green, float blue, float alpha) {
        color[0] = red;
        color[1] = green;
        color[2] = blue;
        color[3] = alpha;
    }

    @Override
    public Color set(int buffer) {
        return set(
                (float) (buffer >> 16 & 255) / 255.f,
                (float) (buffer >> 8 & 255) / 255.f,
                (float) (buffer & 255) / 255.f,
                (float) (buffer >> 24 & 255) / 255.f);
    }

    @Override
    public Color set(float red, float green, float blue, float alpha) {
        return new Color4F(red, green, blue, alpha);
    }

    @Override
    public int getRed() {
        return (int) (getRedAsFloat() * 255);
    }

    @Override
    public int getGreen() {
        return (int) (getRedAsFloat() * 255);
    }

    @Override
    public int getBlue() {
        return (int) (getRedAsFloat() * 255);
    }

    @Override
    public int getAlpha() {
        return (int) (getRedAsFloat() * 255);
    }

    @Override
    public float getRedAsFloat() {
        return color[0];
    }

    @Override
    public float getGreenAsFloat() {
        return color[1];
    }

    @Override
    public float getBlueAsFloat() {
        return color[2];
    }

    @Override
    public float getAlphaAsFloat() {
        return color[3];
    }

    @Override
    public float[] toFloatArray() {
        return Arrays.copyOf(color, color.length);
    }

    @Override
    public String toString() {
        return String.format(
                "r=%.2f,g=%.2f,b=%.2f,a=%.2f",
                getRedAsFloat(), getGreenAsFloat(), getBlueAsFloat(), getAlphaAsFloat());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(color);
    }
}
