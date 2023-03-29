/******************************************************************************
 *  Compilation:  javac Student.java StdIn.java
 *  Execution:    java Student n < students.txt
 *
 *  Read in an integer command-line argument n. Then, read in a list
 *  of n student records from standard input into a Student data type.
 *  Each record consists of four fields, separated by whitespace:
 *      - first name
 *      - last name
 *      - email address
 *      - which section they're in
 *
 *  Then, print out the list of the first N students in sorted order,
 *  according to their section number.
 *
 ******************************************************************************/


public class Student {
    private String first;     // first name
    private String last;      // last name
    private String email;     // email address
    private int section;      // section number

    // construct a new student with given fields
    public Student(String first, String last, String email, int section) {
        this.first   = first;
        this.last    = last;
        this.email   = email;
        this.section = section;
    }

    // return true if the invoking object's section is less than that of b
    public boolean less(Student b) {
        Student a = this;
        return a.section < b.section;
    }

    // return a string representation of the invoking object
    public String toString() {
        return section + " " + first + " " + last + " " + email;
    }



    // sample client
    public static void main(String[] args) {

        // number of students
        int n = Integer.parseInt(args[0]);

        // initialize an arary that holds n objects of type Student
        Student[] students = new Student[n];

        // read in the data
        for (int i = 0; i < n; i++) {
            String first   = StdIn.readString();
            String last    = StdIn.readString();
            String email   = StdIn.readString();
            int section    = StdIn.readInt();
            students[i] = new Student(first, last, email, section);
        }

        // insertion sort students in ascending order of section
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (students[j].less(students[j-1])) {
                    Student swap  = students[j];
                    students[j]   = students[j-1];
                    students[j-1] = swap;
                }
            }
        }

        // print results
        for (int i = 0; i < n; i++) {
            StdOut.println(students[i]);
        }
    }

}
