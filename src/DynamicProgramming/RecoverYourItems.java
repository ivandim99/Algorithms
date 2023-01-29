package DynamicProgramming;


import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RecoverYourItems {

    /**
     * You should implement this method.
     *
     * @param n the length of the first sequence
     * @param m the length of the second sequence
     * @param x the array containing the first sequence. NB: Stored in indexes 1 <= i <= n (so
     *     ignore x[0])
     * @param y the array containing the second sequence. NB: Stored in indexes 1 <= j <= m (so
     *     ignore y[0])
     * @param delta the delta from the recurrence
     * @param alphaDiff the value for alpha from the recurrence if x[i] != y[j], otherwise alpha in
     *     the recurrence is zero.
     * @param mem the memory filled by the dynamic programming algorithm using the provided
     *     recursive formulation.
     * @return the matchings of characters from the first sequence to characters in the second
     *     sequence.
     */
    public static Set<Match> solve(
            int n, int m, char[] x, char[] y, int delta, int alphaDiff, int[][] mem) {

        int i = n;
        int j = m;
        Set<Match> ret = new HashSet<>();
        while (i > 0 && j > 0) {
            if(mem[i][j] == mem[i][j-1] + delta) {
                j--;
            }
            else if(mem[i][j] == mem[i-1][j] + delta) {
                i--;
            }
            else {
                ret.add(new Match(i,j));
                i--;
                j--;
            }
        }
        return ret;
    }

}

class Match {

    // The index in the first sequence
    int firstIndex;

    // The index in the second sequence
    int secondIndex;

    public Match(int firstIndex, int secondIndex) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return firstIndex == match.firstIndex && secondIndex == match.secondIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstIndex, secondIndex);
    }
}