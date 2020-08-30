public class Solution_16 {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1 is between 1 ~ 1000, which is quite limited, so we can use bucket sort
        int[] bucket = new int[1001];
        //traverse arr1, and put into bucket
        for(int num: arr1){
            bucket[num]++;
        }
        //arr1 has been traversed, so we can utilize arr1 to store the final result to save space
        int i = 0;
        //traverse arr2, when num of arr2 exists in arr1, put into new arr1
        for(int num: arr2){
            while(bucket[num]-- > 0){
                arr1[i++] = num;
            }
        }
        //the rest of numbers in bucket does not exist in arr2, traverse bucket and put into arr1
        for(int j=0;j<1001;j++){
            while(bucket[j]-- > 0){
                arr1[i++] =j;
            }
        }
        return arr1;
    }
}


