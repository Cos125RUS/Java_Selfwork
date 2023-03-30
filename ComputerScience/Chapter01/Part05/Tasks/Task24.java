public class Task24 {
    public static void main(String[] args) {
        double r = Double.parseDouble(args[1]);
        double[] a = StdAudio.read(args[0]);

        if (r == 1) {
            StdAudio.play(a);
        } else {
            double[] b = new double[(int)(r * a.length)];
            if (r < 1) {
                for (int i = 0; i < b.length; i++) {
                    b[i] = a[i];
                }
            } else {
                for (int i = 0, j = 0; i < b.length; i++, j++) {
                    b[i] = a[j];
                    if (j + 1 == a.length)
                        j = 0;
                }
            }
            StdAudio.play(b);
        }
    }
}
