public class Ball {
    double rx;
    double ry; // position
    double vx;
    double vy; // velocity
    double radius;

    static {
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
    }

    public Ball(double rx, double ry, double vx, double vy, double radius) {
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
    }

    public void move() {
        if (Math.abs(rx + vx) > 1.0 - radius)
            vx = -vx;
        if (Math.abs(ry + vy) > 1.0 - radius)
            vy = -vy;

        rx = rx + vx;
        ry = ry + vy;
    }

    public void filledCircle(){
        StdDraw.filledCircle(rx, ry, radius);
    }

    public void coordinates(){

    }
}
