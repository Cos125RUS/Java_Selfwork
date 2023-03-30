public class testClass {
    int a;
    int b;
    int c;

    public testClass(int a, int b){
        this.a = a;
        this.b = b;
    }

    public testClass(int a, int b, int c){
        this(a, b);
        this.c = c;
    }
}
