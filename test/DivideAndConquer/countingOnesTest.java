package DivideAndConquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class countingOnesTest {

    @Test
    public void example() {
        int solution = 2;
        int n = 3;
        Skill[] skills = new Skill[4];
        skills[1] = new Skill("Binary counting", false);
        skills[2] = new Skill("Huffman encoding", true);
        skills[3] = new Skill("Exchange arguments", true);
        Assertions.assertEquals(solution, countingOnes.numberOfCompletedSkills(n, skills));
    }

}