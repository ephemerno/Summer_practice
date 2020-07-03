package gui;

import java.awt.*;

public class DrawUtils {
    private Graphics2D g;

    public DrawUtils(Graphics2D graphics2D){
        g = graphics2D;
    }

    public static Color parseColor(String colorStr) { // convert hex color to RGB code
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
}
