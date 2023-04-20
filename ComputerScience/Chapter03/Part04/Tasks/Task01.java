public class Task01 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Ball[] balls = new Ball[n];
		for (int i = 0; i < n; i++)
			balls[i] = new Ball();

		init();

		while(true){

            StdDraw.clear(StdDraw.LIGHT_GRAY);

			for (int i = 0; i < n; i++){
				balls[i].move();
				balls[i].drow();
			}
				
            StdDraw.show();
            StdDraw.pause(20);
		}
	}

	public static void init(){
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
	}
}


public class Ball{
	double rx; 
	double ry;
    double vx;
    double vy;
    double radius; 

	Ball (){
		this.rx = Math.random();
		this.ry = Math.random();
		this.vx = 0.015;
		this.vy = 0.023;
		this.radius = 0.05;
	}

	public void move(){

		if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
        if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

        rx = rx + vx;
        ry = ry + vy;

	}
	
	public void drow(){

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

	}
}