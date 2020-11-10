package controller;

import java.awt.Color;
import java.util.EnumMap;

import model.ShapeColor;

//Used EnumMap to convert from ShapeColor Enum from the base code to Color that is included in java.awt
//Made final so that it cannot be changed
public final class ColorConvertor {
	private static final EnumMap<ShapeColor, Color> color = new EnumMap<>(ShapeColor.class);

    static {
    	color.put(ShapeColor.BLACK, Color.BLACK);
    	color.put(ShapeColor.BLUE, Color.BLUE);
    	color.put(ShapeColor.CYAN, Color.CYAN);
    	color.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
    	color.put(ShapeColor.GRAY, Color.GRAY);
    	color.put(ShapeColor.GREEN, Color.GREEN);
    	color.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
    	color.put(ShapeColor.MAGENTA, Color.MAGENTA);
    	color.put(ShapeColor.ORANGE, Color.ORANGE);
    	color.put(ShapeColor.PINK, Color.PINK);
    	color.put(ShapeColor.RED, Color.RED);
    	color.put(ShapeColor.WHITE, Color.WHITE);
    	color.put(ShapeColor.YELLOW, Color.YELLOW);
    }

    //Get function that returns the color associated with ShapeColor
	public static Color getColor(ShapeColor enumColor) {
		return color.get(enumColor);
	}
}
