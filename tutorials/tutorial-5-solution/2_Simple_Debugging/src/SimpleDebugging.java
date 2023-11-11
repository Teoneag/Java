public class SimpleDebugging {

    /**
     * Calculates and prints the primes between 0 and 100.
     */
    public static void main(String[] args) {
        boolean[] primes = calculatePrimes();
        printPrimes(primes);
    }

    /**
     * Calculates the primes between 0 and 100.
     *
     * @return The array of primes, if primes[n] is true, n is prime
     */
    private static boolean[] calculatePrimes() { // 2 Simple fixes
        boolean[] primes = new boolean[100];
        int number = 1; // starting from 1 instead of 0
        while (++number < 100) {
            int divisor = number - 1;
            primes[number] = true;
            while (--divisor >= 2) { // decrement is now prefix
                if (number % divisor == 0) {
                    primes[number] = false;
                    break;
                }
            }
        }
        return primes;
    }

    private static boolean[] calculatePrimesAlt() { // Slightly more clear alternative
        boolean[] primes = new boolean[100];
        for (int number = 2; number < 100; number++) {
            primes[number] = true;
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    primes[number] = false;
                    break;
                }
            }
        }
        return primes;
    }

    /**
     * Prints the given primes.
     *
     * @param primes The array of primes to be printed
     */
    private static void printPrimes(boolean[] primes) {
        System.out.println("The primes are:");
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }

}
