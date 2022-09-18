class maxConsectiveOnes {
    public int longestOnes(int[] nums, int k){
        // high level: use sliding window to keep at most k zeros in the window
        // n^2

        // first we will acquire zeroes till number of zeroes does not exceed k

        int count = 0;
        int max = 0;
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
            // whenever count becomes greater than k then we start the second pointer j and check for zeroes and
            // reduce the count indicating this zero is not considered as flipped now
            while(count>k){
                if(nums[j] == 0){
                    count--;
                }
                j++;
            }
            int length = i - j + 1;
            max = Math.max(length, max);
        }
        return max;
    }
}
