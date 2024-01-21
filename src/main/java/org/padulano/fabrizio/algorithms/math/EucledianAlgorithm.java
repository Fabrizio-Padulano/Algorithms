package org.padulano.fabrizio.algorithms.math;

public class EucledianAlgorithm {
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return b == 0 ? a : gcd(b, a % b);
    }
}
