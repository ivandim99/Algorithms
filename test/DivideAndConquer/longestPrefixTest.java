package DivideAndConquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class longestPrefixTest {


    @Test
    public void example() {
        int n = 2;
        String[] encodings = new String[n + 1];
        encodings[1] = "Hello World";
        encodings[2] = "Hello Weasley";
        // Note the "2" as input on the next line!
        Assertions.assertEquals("Hello W", longestPrefix.longestPrefix(n, encodings));
    }

    @Test
    public void secondExample() {
        int n = 3;
        String[] encodings = new String[n + 1];
        encodings[1] = "Hello World";
        encodings[2] = "Hello Weasley";
        encodings[3] = "Hiya mate!";
        Assertions.assertEquals("H", longestPrefix.longestPrefix(n, encodings));
    }

    @Test
    public void exampleBinary() {
        int n = 7;
        String[] encodings = new String[n + 1];
        encodings[1] = "010101";
        encodings[2] = "00101010";
        encodings[3] = "00010101";
        encodings[4] = "10101";
        encodings[5] = "00001";
        encodings[6] = "00000";
        encodings[7] = "10111";
        Assertions.assertEquals("", longestPrefix.longestPrefix(n, encodings));
    }

}