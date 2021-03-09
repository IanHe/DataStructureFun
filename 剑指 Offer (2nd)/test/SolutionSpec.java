import org.testng.annotations.Test;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
        System.out.println(2 & 3);
    }
}


class Sol {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

//896
}
