public class Task27 {
    public static void main(String[] args) {
        int SAMPLING_RATE = 44100;

        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            Double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (SAMPLING_RATE * duration);
            double max = 0.0;
            double min = 0.0;
            double[] x = new double[n + 1];
            double[] y = new double[n + 1];
            for (int i = 0; i < n + 1; i++) {
                x[i] = 2 * Math.PI * i * hz / SAMPLING_RATE;
                y[i] = Math.sin(x[i]);
                if (x[i] > max)
                    max = x[i];
                if (x[i] < min)
                    min = x[i];
            }

            StdDraw.setXscale(-20.0, x[n] + 20.0);
            StdDraw.setYscale(-2.0, 2.0);
            for (int i = 1, j = 0; i < n + 1; i++) {
                if (x[i] == max)
                StdDraw.line(x[i - 1], y[i - 1], x[i], y[i]);
                // StdAudio.play(y[i]);
            }
            StdAudio.play(b);
        }
    }
}
