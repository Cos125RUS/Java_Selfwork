/******************************************************************************
 *  Compilation:  javac Zoom.java
 *  Execution:    java Zoom filename scale x y
 *  Data files:   https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg
 *
 *  Zooms in on the image with given scale factor, where (x, y) are the
 *  relative coordinates of the point that is to be the center.
 *
 *  % java Zoom mandrill.jpg 2.0 .5 .5
 *
 *
 ******************************************************************************/

import java.awt.Color;

public class Zoom {
    public static void main(String[] args) {
        String filename = args[0];
        double scale = Double.parseDouble(args[1]);
        double x = Double.parseDouble(args[2]);
        double y = Double.parseDouble(args[3]);
        GrayscalePicture source = new GrayscalePicture(filename);
        int width = source.width();
        int height = source.height();
        GrayscalePicture target = new GrayscalePicture(width, height);

        for (int colT = 0; colT < width; colT++) {
            for (int rowT = 0; rowT < height; rowT++) {
                int colS = (int) (x*width  - width/(2*scale)  + colT/scale);
                int rowS = (int) (y*height - height/(2*scale) + rowT/scale);
                if (colS < 0 || colS >= width || rowS < 0 || rowS >= height)
                    target.set(colT, rowT, Color.BLACK);
                else
                    target.set(colT, rowT, source.get(colS, rowS));
            }
        }

        source.show();
        target.show();
    }
}
