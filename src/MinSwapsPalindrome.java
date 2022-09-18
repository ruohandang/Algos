class MinSwapsPalindrome {
    public int minSwap(String b){
        if(b==null || b.length()<=1) return 0;
        int length = b.length();
        // we count the numbers of differences, if its a even number we can solve it one time, if this a odd number we could not solve it.
        int count = 0;
        for(int i = 1; i < length/2; i++){
            if(b.charAt(i) != b.charAt(length-i-1)){
                count++;
            }
        }
        if(count%2 == 1 && length%2 == 0){
            return -1;
        }
        return (count+1)/2;
    }
}
/*
    My Thoughts:
        I thought it over and tried to find out some properties.
        But, like we need to swap either 1,0 or 0,1, swapping the indexes with the same values doesn’t make sense.
        If the string is of even length, then the number of 0’s and 1’s must be equal, and if it
        is of odd length, then one of the numbers of 1’s and o’s is odd, and the other is even.
        If this condition is not satisfied, then it is not possible to make the string a palindrome
        But whether this is a sufficient condition or not, I am not sure.

 */