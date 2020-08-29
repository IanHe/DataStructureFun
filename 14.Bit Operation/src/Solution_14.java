public class Solution_14 {


    public static void main(String[] args) {
        Solution_14 solution = new Solution_14();

    }

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 0;i<=num;i++){
            result[i] = numOfBit(i);
        }
        return result;
    }

    private int numOfBit(int x) {
        int count = 0;
        for (; x != 0; count++) x &= x - 1;
        return count;
    }


}
