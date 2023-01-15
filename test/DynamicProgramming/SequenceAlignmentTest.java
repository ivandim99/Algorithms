package DynamicProgramming;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SequenceAlignmentTest {

    @Test
    public void example() {
        String a = "kitten";
        String b = "sitting";
        Assertions.assertEquals(3, SequenceAlignment.solve(a, b));
    }

}