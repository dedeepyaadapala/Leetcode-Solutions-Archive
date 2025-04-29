class Solution {

    public long countSubarrays(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
        }

        ArrayList<Integer> indexesOfMaxElements = new ArrayList<>();
        long ans = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == maxElement) {
                indexesOfMaxElements.add(index);
            }

            int freq = indexesOfMaxElements.size();
            if (freq >= k) {
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }
        return ans;
    }
}