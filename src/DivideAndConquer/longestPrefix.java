package DivideAndConquer;

import java.util.Arrays;

public class longestPrefix {

    /**
     * You should implement this method.
     *
     * @param n the number of encodings
     * @param encodings the encodings to analyse. Note that you should use entries encodings[1] to
     *     encodings[n]!
     * @return the longest common prefix amongst all encodings.
     */
    public static String longestPrefix(int n, String[] encodings) {
        // return solveSlow(skills);
        return solveProper(n, encodings);
    }

    public static String solveProper(int n, String[] encodings) {
        return solveProper(encodings, 1, n);
    }

    private static String solveProper(String[] encodings, int lower, int upper) {
        if (upper - lower < 3) {
            return solveSlow(encodings, lower, upper);
        }
        int mid = lower + (upper - lower) / 2;
        String leftSide = solveProper(encodings, lower, mid);
        String rightSide = solveProper(encodings, mid + 1, upper);
        return prefix(leftSide, rightSide);
    }

    private static String solveSlow(String[] encodings, int lower, int upper) {
        String longest = encodings[lower];
        for (int i = lower; i <= upper; i++) {
            longest = prefix(encodings[i], longest);
        }
        return longest;
    }

    public static String solveSlow(int n, String[] encodings) {
        return solveSlow(encodings, 1, n);
    }

    private static String prefix(String encoding, String encoding1) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < encoding.length(); i++) {
            if (i < encoding1.length() && encoding1.charAt(i) == encoding.charAt(i)) {
                ans.append(encoding.charAt(i));
            } else {
                break;
            }
        }
        return ans.toString();
    }
}
