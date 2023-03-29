/******************************************************************************
 *  Compilation:  javac CircuitRLC.java
 *  Execution:    java CircuitRLC < input.txt
 *
 *  RLC circuit data type.
 *
 ******************************************************************************/


/*
Rohan Kapadia

Alternating current (AC), unlike direct current (DC), supplies
a voltage which varies with time. The voltage depends on a
sine function. In circuits with resistors only, the current
is directly proportional to the voltage. However, with capacitors
and inductors, there is a "phase shift" between the current
and voltage. With a capacitor, there is a 90 degree phase shift.
This means that when the voltage wave is at its maximum, the
current is 0, and when the current is at its maximum the voltage
is 0. The phase shift of inductors is in the other direction.
Complex numbers are used to add up the total impedance of a
circuit (impedance is a general form of resistance including
capacitors and inductors). With complex numbers, we can add up
the impedances of each element as if it were a simple resistor
circuit and don't need to calculate the phases of each element.
To do this, the impedance of a capacitor is equal to 1/iwC and
the impedance of an inductor is iwL. These values depend on the
frequency of the power supply, w.

input = # of resistors, capacitors, inductors then their resistances,
        capacitances, inductances


 common possible values
                resistance = 4;
                inductance = 0.01;
                capacitance = 0.000005;
*/

public class CircuitRLC {
    public static void main(String[] args) {
        int resistorCount = StdIn.readInt();        // number of resistors
        int inductorCount = StdIn.readInt();        // number of inductors
        int capacitorCount = StdIn.readInt();       // number of capacitors
        double[] resistors = new double[resistorCount];     // resistors
        double[] inductors = new double[inductorCount];     // inductors
        double[] capacitors = new double[capacitorCount];   // capacitors

        // read in values from stdin
        for (int i = 0; i < resistorCount; i++)
            resistors[i] = StdIn.readDouble();
        for (int i = 0; i < inductorCount; i++)
            inductors[i] = StdIn.readDouble();
        for (int i = 0; i < capacitorCount; i++)
            capacitors[i] = StdIn.readDouble();

        double frequency = 50;           // angular frequency of voltage (w)

        Complex impedance = new Complex(0, 0);

        for (int i = 0; i < resistorCount; i++) {
            Complex resistance = new Complex(resistors[i], 0);
            impedance = impedance.plus(resistance);
        }

        // complex impedance of an inductor is iwL
        for (int i = 0; i < inductorCount; i++) {
            Complex reactance = new Complex(0, frequency * inductors[i]);
            impedance = impedance.plus(reactance);
        }

        // complex impedance of a capacitor is 1/(iwC)
        for (int i = 0; i < capacitorCount; i++) {
            Complex reactance = new Complex(0, -1.0/(frequency * capacitors[i]));
            impedance = impedance.plus(reactance);
        }


        double realImpedance = impedance.abs();
        StdOut.println("real impedance = " + realImpedance);

        // relative phase = angle at which voltage leads current
        double phase = impedance.phase();
        StdOut.println("phase = " + phase);
    }
}
