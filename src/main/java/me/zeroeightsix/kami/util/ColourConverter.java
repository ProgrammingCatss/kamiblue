package me.zeroeightsix.kami.util;

/**
 * @author S-B99
 */
public class ColourConverter {
    public static float toF(int i) {
        return i / 255f;
    }

    public static float toF(double d) {
        return (float) (d / 255f);
    }
}
