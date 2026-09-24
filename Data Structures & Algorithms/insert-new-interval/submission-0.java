class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int new_start = newInterval[0];
        int new_end = newInterval[1];
        List<int[]> result = new ArrayList();
        boolean inserted = false;
        for(int i=0; i< intervals.length; i++){
            int end = intervals[i][1];
            int start = intervals[i][0];
            if(end < new_start){
                result.add(new int[]{start, end});
            }else if(end >= new_start && start <= new_end){
                new_end = Math.max(new_end, end);
                new_start = Math.min(new_start, start);
            }else if(start > new_end)
            {
                if(!inserted){
                result.add(new int[]{new_start, new_end});
                inserted = true;
                }
                result.add(new int[]{start, end});
            }
        }
        if(!inserted){
        result.add(new int[]{new_start, new_end});
        }
        return result.toArray(new int[result.size()][]);
    }

    //go element by element
    //if the new interval is clearly after the interval, add the interval as it is
    //if there is an overlap, then end becomes whichever end is greater
    //if the new interval is clearly before the interval, the new interval wont grow further
    //so add new interval here 
    //also add the interval as its clearly after the new interval
}
