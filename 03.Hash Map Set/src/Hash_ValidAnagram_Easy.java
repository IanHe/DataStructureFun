import java.util.Arrays;

/**
 * Difficulty: Easy
 * Name: Valid Anagram
 * Link: https://leetcode-cn.com/problems/valid-anagram/ or https://leetcode.com/problems/valid-anagram/
 */
public class Hash_ValidAnagram_Easy {
    public static void main(String[] args) {
        System.out.println(isAnagram_1("anagram", "nagaram"));
        System.out.println(isAnagram_1("rat", "car"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    /**
     * 1. Approach: Simple Hash table - a counter for different chars
     * 2. Time Complexity: O(N), Space Complexity: O(1)
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int num: counter){
           if(num!=0){
               return false;
           }
        }
        return true;
    }

    /**
     * 1. Approach: Brute Force - sort then compare
     * 2. Time Complexity: O(NlogN), Space Complexity: O(1)
     */
    public static boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] array_1 = s.toCharArray();
        char[] array_2 = t.toCharArray();
        Arrays.sort(array_1);
        Arrays.sort(array_2);
        return Arrays.compare(array_1, array_2) == 0;
    }
}
