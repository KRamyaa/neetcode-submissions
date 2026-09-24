class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        int merge_interval_start =  intervals[0][0];
        int merge_interval_end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int i=0; i< intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(merge_interval_end >= start){
                merge_interval_end = Math.max(merge_interval_end, end);
            }
            else{
                result.add(new int[]{merge_interval_start, merge_interval_end});
                merge_interval_start = start;
                merge_interval_end = end;
            }
        }
        result.add(new int[]{merge_interval_start, merge_interval_end});
        return result.toArray(new int[result.size()][]);
        
    }

    // sort the intervals by start if not already sorted
    // that would give an ordering so u can check overlap
    // check element by element and check if the end time of previous is greater than or equal to that of the next start time 
    // if so take the max of the end times as the interval end
    // if not just add it as it coz its not an overlapping interval
    // add the overlapping interval to the result at the point where it can't grow any further
}
