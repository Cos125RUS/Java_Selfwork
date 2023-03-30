/******************************************************************************
 *  Compilation:  javac Bug2.java
 *  Execution:    java Bug2
 *
 *  Mistake with constructor since it has extra set of curly braces.
 *  As a result, code below it is actually executed (using an obscure
 *  feature of Java known as static initialization), but its effect
 *  is to overwrite the data member s with itself, which is null.
 *
 *  This is particularly hard to debug since the println statement
 *  will get executed once for each newly created object.
 *
 *  % java Bug2
 *  here
 *  Exception in thread "main" java.lang.NullPointerException
 *        at Bug2.main(Bug2.java:30)
 *
 ******************************************************************************/

public class Bug2 {
    private String s;

    public Bug2(String s) { }
    {
        StdOut.println("here");
        this.s = s;                         // line 30
    }

    public String toString()
    {
        return s.toUpperCase();
    }


    public static void main(String[] args)
    {
        Bug2 x = new Bug2("hello");
        StdOut.println(x);
    }
}
