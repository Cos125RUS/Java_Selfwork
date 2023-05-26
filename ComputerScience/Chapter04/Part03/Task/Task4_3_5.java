//import java.util.Queue;

public class Task4_3_5 {
    public static void main(String[] args) {
        Queue<Double> nums = new Queue<Double>();
        int count = 0;
        for (String item : args) {
            Double n = Double.parseDouble(item);
            nums.enqueue(n);
            count++;
        }
        Double arr[] = new Double[count];
        for (int i = 0; i < count; i++) {
            arr[i] = nums.dequeue();
            StdOut.println(arr[i]);
        }
    }
}
