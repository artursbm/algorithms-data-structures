package problems;

/**
 *
 * Write a method named getGreatestCommonDivisor with two parameters of type int named first and second.
 * The method should return the greatest common divisor of the two numbers (int).
 * The greatest common divisor is the largest positive integer that can fully divide each of the integers (i.e. without leaving a remainder).
 *
 * For example 12 and 30:
 * 12 can be divided by 1, 2, 3, 4, 6, 12
 * 30 can be divided by 1, 2, 3, 5, 6, 10, 15, 30
 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6, and there is no resulting remainder.
 *
 * EXAMPLE INPUT/OUTPUT:
 * * getGreatestCommonDivisor(25, 15); should return 5 since both can be divided by 5 without a remainder
 * * getGreatestCommonDivisor(12, 30); should return 6 since both can be divided by 6 without a remainder
 * * getGreatestCommonDivisor(81, 153); should return 9 since both can be divided by 9 without a remainder
 *
 * @author Artur Mello
 * @since 2020
 */
public class MDC {
    public static void main(String[] args) {
        int a = 4;
        int b = 28;
        int gcd;
        if(a < b) {
            gcd = getGreatestCommonDivisor(a,b);
        } else {
            gcd = getGreatestCommonDivisor(b,a);
        }
        System.out.println(gcd);
    }

    private static int getGreatestCommonDivisor(int smaller, int bigger) {
        if(bigger % smaller == 0) {
            return smaller;
        } else {
            return getGreatestCommonDivisor((bigger%smaller), smaller);
        }
    }
}

