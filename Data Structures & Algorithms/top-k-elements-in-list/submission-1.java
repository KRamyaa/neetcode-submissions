class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            if(buckets[entry.getValue()] == null){
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index=0;
        for(int i= nums.length; i >=0 && index <k; i--){
            if(buckets[i] != null){
                for(int j=0; j < buckets[i].size() && index < k; j++){
                result[index] = buckets[i].get(j);    
                index++;
                }
            }
        }
        return result;
    }
}
