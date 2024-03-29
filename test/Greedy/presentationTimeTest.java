package Greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class presentationTimeTest {

    @Test
    public void example() {
        int n = 4;
        String[] presenters = { "", "Mia", "Phoenix", "Maya", "Miles" };
        int[] startTimes = { 0, 12, 1, 17, 13 };
        int[] endTimes = { 0, 18, 11, 20, 15 };
        Set<String> result = new HashSet<>();
        result.add("Phoenix");
        result.add("Maya");
        result.add("Miles");
        Assertions.assertEquals(result, presentationTime.whatPresentations(n, presenters, startTimes, endTimes));
    }

}