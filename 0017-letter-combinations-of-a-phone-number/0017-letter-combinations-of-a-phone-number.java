import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, String> phoneMap = new HashMap<>();
    private List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return combinations; // Return empty list for empty input
        // Initialize the mapping of digits to letters
        initializePhoneMap();
        backtrack("", digits, 0);
        return combinations;
    }

    private void initializePhoneMap() {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    private void backtrack(String combination, String digits, int index) {
        // Base case: if the combination is complete, add it to the result
        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }
        
        // Get the current digit and its corresponding letters
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        // Iterate through the letters and proceed to the next digit
        for (char letter : letters.toCharArray()) {
            backtrack(combination + letter, digits, index + 1); // Append current letter and move to next digit
        }
    }

    // Example usage
   
}
