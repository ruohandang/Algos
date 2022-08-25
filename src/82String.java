import java.util.HashMap;
import java.util.Map;
class Solution {
    public String deDup(String input) {
        if(input==null || input.length()<=1) return input;
        // Write your solution here
        char[] arr = input.toCharArray();
        int slow = 1;
        int fast = 1;
        while(fast<arr.length){
            // if the fast is equal to the slow previous one, then need to take slow backward
            if(slow>0 && arr[fast]==arr[slow-1]){
                // need to check the length first or it will be crash
                while(fast<arr.length && arr[fast]==arr[slow-1]){
                    fast++;
                }
                // the minimum slow will be zero
                slow--;
                // if not equal, keep it.
            }else{
                arr[slow] = arr[fast];
                slow++;
                fast++;
            }
        }
        return new String(arr, 0, slow);
    }
}

class main{
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "afa";
        String str = solution.deDup(s);
        System.out.println(str);

    }
}