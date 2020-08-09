import java.util.ArrayList;
import java.util.List;

public class Solution_06 {

    // use string array can save memory
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution_06 solution = new Solution_06();
        solution.letterCombinations("23").forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, "", 0);
        return res;
    }


    //递归函数
    void iterStr(String str, String letter, int index) {

        //terminator: when depth has reached the end
        if (index == str.length()) {
            res.add(letter);
            return;
        }

        // process
        // get char represented String
        char c = str.charAt(index);
        int pos = c - '0';
        String map_string = letter_map[pos]; // when char is '2' get "abc"

        for (int i = 0; i < map_string.length(); i++) {
            iterStr(str, letter + map_string.charAt(i), index + 1);
        }
    }


}
