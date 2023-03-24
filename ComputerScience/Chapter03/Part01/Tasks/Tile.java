/******************************************************************************
 *  Compilation:  javac Tile.java
 *  Execution:    java Tile filename m n
 *
 *  Reads in an image from a file, and create an m-by-n tile of the image.
 *
 *  % java Tile image.jpg 3 3
 *
 ******************************************************************************/

import java.awt.Color;

public class Tile {

    public static void main(String[] args) {
        Picture input = new Picture(args[0]);
        int height = input.height();
        int width  = input.width();
        int m = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        Picture output = new Picture(n*input.width(), m*input.height());

        // convert to black and white
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = input.get(col, row);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        output.set(width*j + col, height*i + row, color);
                    }
                }
            }
        }
        output.show();
        output.save("temp.png");
    }



}
