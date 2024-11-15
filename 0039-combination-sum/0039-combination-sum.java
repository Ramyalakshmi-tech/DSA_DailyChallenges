class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        Helper(candidates, target, list2, list, 0, 0);
        return list2;
    }

    public void Helper(int[] nums, int target, List<List<Integer>> list2, ArrayList<Integer> list, int sum, int index) {
        // Base case: If the current sum equals the target, add the combination to the result.
        if (sum == target) {
            list2.add(new ArrayList<>(list));
            return;
        }
        
        // If sum exceeds target, no point in continuing.
        if (sum > target) {
            return;
        }

        // Loop through candidates starting from the current index.
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);  // Add the candidate
            // Recur with the updated sum and the same index (because we can reuse elements).
            Helper(nums, target, list2, list, sum + nums[i], i);
            list.remove(list.size() - 1);  // Backtrack by removing the last added element
        }
    }
}
