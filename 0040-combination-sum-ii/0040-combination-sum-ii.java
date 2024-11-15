import java.util.*;
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list2 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        // Sort candidates to handle duplicates and simplify the combination process.
        Arrays.sort(candidates);
        
        Helper(candidates, target, list2, list, 0, 0);
        
        return list2;
    }

    public void Helper(int[] nums, int target, List<List<Integer>> list2, ArrayList<Integer> list, int sum, int index) {
        // Base case: If the current sum equals the target, add the combination to the result.
        if (sum == target) {
            list2.add(new ArrayList<>(list));  // Add the current combination to the result
            return;
        }

        // If sum exceeds target, no point in continuing.
        if (sum > target) {
            return;
        }

        // Loop through candidates starting from the current index.
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates at the same recursive level.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);  // Add the candidate to the current list
            
            // Recur with the updated sum and next index (i + 1 to avoid reuse)
            Helper(nums, target, list2, list, sum + nums[i], i + 1);
            
            // Backtrack by removing the last added element
            list.remove(list.size() - 1);
        }
    }
}
