/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int start[] = new int[intervals.size()];
        int end[] = new int[intervals.size()];
        int i=0;
        for(Interval interval : intervals){
            start[i] = interval.start;
            end[i] = interval.end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int start_meeting = 0;
        int end_meeting = 0;
        int max_rooms = 0;
        int currentRooms = 0;
        while(start_meeting < start.length){
            if(start[start_meeting] < end[end_meeting]){
                currentRooms++;
                max_rooms = Math.max(max_rooms, currentRooms);
                start_meeting++;
            }else{
                currentRooms--;
                end_meeting++;
            }
        }
        return max_rooms;
    }
}
