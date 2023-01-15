package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class RecoveringSolutions {

    public static List<Integer> solve(int n, int[] nodes, int result, int[] mem) {
        LinkedList<Integer> ret = new LinkedList<>();
        for(int i = n; i >= 1;i--) {
            if(mem[i] == result) {
                ret.addFirst(i);
                result -= nodes[i];
            }
        }
        return ret;
    }

}
