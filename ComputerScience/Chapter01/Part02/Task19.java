public class Task19 {
    public static void main(String[] args) {
        System.out.println(((int)(Math.random()*10))%
        (Integer.parseInt(args[1])-Integer.parseInt(args[0]))+Integer.parseInt(args[0]));
    }
}
