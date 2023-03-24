public class Task19 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double r = 0.3;
        double x0 = 0.5;
        double y0 = 0.5;
        Point[] points = new Point[n];
        // StdDraw.circle(x0, y0, r);
        // StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.015);
        double angleOffset  = 360 / n;
        double angle = angleOffset;
        for (int i = 0; i < n; i++) {
            double rad = Math.toRadians(angle);
            points[i] = new Point(x0 + r * Math.cos(rad), y0 + r * Math.sin(rad));
            angle += angleOffset;
            points[i].drow();
        }

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (Math.random() < p)
                    points[i].line(points[j]);
            }
        }
    }
}

public class Point {
    double x;
    double y;
    // double r;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        // this.r = r;
    }

    public void drow() {
        StdDraw.point(x, y);
    }

    public void line (Point last){
        StdDraw.line(x, y, last.x, last.y);
    }
}