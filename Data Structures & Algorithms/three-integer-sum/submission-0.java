class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i=0;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        while(i < nums.length){
            if(i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }    

            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
 
            if(nums[left] + nums[right] == target){
                List<Integer> validTriplet = Arrays.asList(nums[i], nums[left], nums[right]);
                result.add(validTriplet);
                left++;
                right--; 

                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                while(left < right && nums[right] ==  nums[right+1]){
                    right--; 
                } 

            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
            }
            i++;  
        }

        return result;
    }
}
