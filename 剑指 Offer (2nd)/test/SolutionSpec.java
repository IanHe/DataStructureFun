import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();
        System.out.println(sol.mySqrt(8));
    }
}


class Sol {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int num = x/2;
        while(num * num > x)
            num /= 2;
        while((num+1) * (num+1) <= x)
            num += 1;
        return num;
    }
//896
}
