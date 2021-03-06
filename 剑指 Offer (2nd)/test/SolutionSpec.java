import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
    }
}


class Sol {
//abc bac cba acb -"bca","cab"
    public String[] permutation(String s) {
        if (s.length() == 1) return new String[]{s};
        char[] chs = s.toCharArray();
        Set<String> res = new HashSet<>();
        res.add(s);
        for (int i = 0; i < chs.length; i++) {
            for (int j = i + 1; j < chs.length; j++) {
                swap(i, j, chs);
                res.add(String.valueOf(chs));
                swap(i, j, chs);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    void swap(int a, int b, char[] c) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
//896
}
