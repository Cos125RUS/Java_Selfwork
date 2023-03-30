/******************************************************************************
 *  Compilation:  javac Glass.java
 *  Execution:    java Glass filename
 *
 *  Reads in an image from a file, and apply an image filter that
 *  makes it look like it's being seen through glass. This effect is
 *  accomplished by plotting pixel (x, y) in the color of a random
 *  neighboring pixel (xx, yy).
 *
 *  % java Glass baboon.jpg
 *
 ******************************************************************************/

import java.awt.Color;

public class Glass {

    // return random integer between a and b
    public static int random(int a, int b) {
        return a + StdRandom.uniformInt(b - a + 1);
    }

    public static void main(String[] args) {
        Picture picture1 = new Picture(args[0]);
        picture1.show();
        int width  = picture1.width();
        int height = picture1.height();
        Picture picture2 = new Picture(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int xx = (width  + x + random(-5, 5)) % width;
                int yy = (height + y + random(-5, 5)) % height;
                Color color = picture1.get(xx, yy);
                picture2.set(x, y, color);
            }
        }

        picture2.show();
    }

}
