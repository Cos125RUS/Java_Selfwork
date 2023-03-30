public class TenPerLine {
    public static void main(String[] args) {
        int i = 0;
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            if (n < 100){
                System.out.print(n);
                if (n < 10)
                    System.out.print("  ");
                else 
                    System.out.print(" ");
                i++;
                if (i%10 == 0)
                    System.out.println();
            }
        }
    }
}
