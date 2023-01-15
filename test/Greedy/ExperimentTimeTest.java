package Greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExperimentTimeTest {
    @Test
    public void example() {
        int n = 2;
        int[] t = { 0, 8, 7 };
        int[] f = { 0, 2, 6 };
        assertEquals(72, ExperimentTime.prioritisingExperiments(n, t, f));
    }
}