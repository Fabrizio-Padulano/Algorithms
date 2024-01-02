package org.padulano.fabrizio.algorithms.math;

public class EucledianAlgorithm {
    public static long gcd(long a, long b) {
        /**
         * Since GCD(a,b) in Z = {GCD(a,b) in N, -GCD(a,b) in N} then we can use just the
         * natural numbers of a and b.
         */
        a = Math.abs(a);
        b = Math.abs(b);
        return b == 0 ? a : gcd(b, a % b);
    }
}
