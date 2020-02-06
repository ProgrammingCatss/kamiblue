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

/**
 * Created on 2/5/2018 by fr1kin
 */
public class ColorBuffer extends Color {

    private static final Color FACTORY = new ColorBuffer();

    public static Color getFactory() {
        return FACTORY;
    }

    //
    //
    //

    private final int buffer;

    private ColorBuffer() {
        this(0);
    }

    private ColorBuffer(int buffer) {
        this.buffer = buffer;
    }

    @Override
    public Color set(int buffer) {
        return new ColorBuffer(buffer);
    }

    @Override
    public Color set(float red, float green, float blue, float alpha) {
        return set(
                (int) (red * 255.f), (int) (green * 255.f), (int) (blue * 255.f), (int) (alpha * 255.f));
    }

    @Override
    public int getRed() {
        return toBuffer() >> 16 & 255;
    }

    @Override
    public int getGreen() {
        return toBuffer() >> 8 & 255;
    }

    @Override
    public int getBlue() {
        return toBuffer() & 255;
    }

    @Override
    public int getAlpha() {
        return toBuffer() >> 24 & 255;
    }

    @Override
    public float getRedAsFloat() {
        return (float) getRed() / 255.f;
    }

    @Override
    public float getGreenAsFloat() {
        return (float) getGreen() / 255.f;
    }

    @Override
    public float getBlueAsFloat() {
        return (float) getBlue() / 255.f;
    }

    @Override
    public float getAlphaAsFloat() {
        return (float) getAlpha() / 255.f;
    }

    @Override
    public int toBuffer() {
        return buffer;
    }

    @Override
    public float[] toFloatArray() {
        return new float[]{getRedAsFloat(), getGreenAsFloat(), getBlueAsFloat(), getAlphaAsFloat()};
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(buffer);
    }

    @Override
    public String toString() {
        return String.format("r=%d,g=%d,b=%d,a=%d", getRed(), getGreen(), getBlue(), getAlpha());
    }
}
