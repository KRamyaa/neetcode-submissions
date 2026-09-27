class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

    //at each step, you could have got there by taking either one step or two steps
    // and you need the distinct ways to have reached n-1 so that in another one step from those you get here
    // and you need the distinct ways to have readched n-2 so that in another 2 steps from those you get here
    // add those distinct ways as they have no overlap for the total unique ways
}
