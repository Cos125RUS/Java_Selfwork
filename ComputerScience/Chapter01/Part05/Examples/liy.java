public class liy {
    public static void main(String[] args) {
        int SAMPLING_RATE = 44100;
        int hz = 440;
        double duration = 2.0;
        int n = (int) (SAMPLING_RATE * duration);
        double[] a = new double[n + 1];
        for (int i = 0; i < n + 1; i++) 
            a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
        StdAudio.play(a);
    }
}
