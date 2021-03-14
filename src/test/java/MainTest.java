import org.testng.annotations.Test;
import org.testng.Assert;

public class MainTest {
    @Test
    public void test(){
        Solution sol = new Solution();
        Assert.assertEquals(sol.func(), 1);
    }
}

class Solution{
    public int func() {
        return 1;
    }
}