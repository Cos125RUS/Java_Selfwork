public class RandomPoint {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.parseInt(args[0]); i++) 
            StdDraw.point(StdRandom.gaussian(.5, .2), StdRandom.gaussian(.5, .2));
            System.out.println("Finish");
    }
}
