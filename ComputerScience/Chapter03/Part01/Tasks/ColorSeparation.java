/******************************************************************************
 *  Compilation:  javac ColorSeparation.java
 *  Execution:    java ColorSeparation filename
 *  Dependencies: Picture.java
 *  Data files:   https://introcs.cs.princeton.edu/java/31datatype/baboon.jpg
 *                https://introcs.cs.princeton.edu/java/31datatype/peppers.jpg
 *
 *  Reads in an image from a file, and displays the red, green, and
 *  blue portions in three separate windows.
 *
 *  % java ColorSeparation baboon.jpg
 *
 ******************************************************************************/

import java.awt.Color;

public class ColorSeparation {

    public static void main(String[] args) {

        // read in the picture specified by command-line argument
        Picture picture = new Picture(args[0]);
        int width  = picture.width();
        int height = picture.height();

        // create three blank pictures of the same dimension
        Picture pictureR = new Picture(width, height);
        Picture pictureG = new Picture(width, height);
        Picture pictureB = new Picture(width, height);

        // separate colors
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                pictureR.set(col, row, new Color(r, 0, 0));
                pictureG.set(col, row, new Color(0, g, 0));
                pictureB.set(col, row, new Color(0, 0, b));
            }
        }

        // display each picture in its own window
        pictureR.show();
        pictureG.show();
        pictureB.show();
    }


}
