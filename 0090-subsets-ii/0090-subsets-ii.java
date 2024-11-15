class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list2=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        Helper(nums,list2,list,0);
        return list2;
    }

    public void Helper(int[] nums,List<List<Integer>> list2,ArrayList<Integer> list,int index){
        if(index>nums.length){
            return ;
        }
        list2.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            Helper(nums,list2,list,i+1);
            list.remove(list.size()-1);
        }
    }
}