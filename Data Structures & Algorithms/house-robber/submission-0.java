class Solution {
    public int rob(int[] nums) {

        int amountRobbedSoFar = 0;
        int amountRobbedTillIncludingPrevious = 0;
        int amountRobbedSkippingThePrevious = 0;

        for(int i=0; i < nums.length; i++){
            amountRobbedSoFar = Math.max(nums[i] + amountRobbedSkippingThePrevious, amountRobbedTillIncludingPrevious);
            amountRobbedSkippingThePrevious = amountRobbedTillIncludingPrevious;
            amountRobbedTillIncludingPrevious = amountRobbedSoFar;
        }
        
        return amountRobbedSoFar;
    }

    //at each house I have two choices, either can rob this house or skip it
    //to rob this, I must have not robbed the previous house
    //I skip this had I robbed the previous house
    //whichever path gives me max amount I rob those houses
}
