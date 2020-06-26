package prep;

public class NumberofPrimeNumbers {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
        }
        return true;

    }


    public static int numPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i) == true) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int a = 3;
        if (isPrime(4) == true) System.out.println(1);
        else System.out.println(0);
    }
}
