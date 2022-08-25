import java.util.ArrayDeque;
import java.util.Deque;

class Solution649 {
    public String replace(String input, String source, String target) {
        // Write your solution here
        if(input == null || input.isEmpty()) return input;
        // step 1: find all the substrings of source
        Deque<Integer> stack = substrings(input, source);
        int size = stack.size();
        char[] targetArr = target.toCharArray();
        char[] sourceArr = source.toCharArray();

        int extraSpace = (targetArr.length - sourceArr.length) * size;
        char[] newArr = new char[input.length() + extraSpace];

        char[] arr = input.toCharArray();


        // new Array index
        int slow = newArr.length - 1;
        int fast = arr.length - 1;

        while( fast>=0){
            int targetIdx = target.length() -1;
            if(!stack.isEmpty() && fast==stack.peekFirst()){
                while(targetIdx>=0){
                    newArr[slow]=targetArr[targetIdx];
                    slow--;
                    targetIdx--;
                }
                fast -= sourceArr.length;
                stack.pollFirst();
            }else{
                newArr[slow] = arr[fast];
                slow--;
                fast--;
            }
        }

        return new String(newArr);

    }

    private Deque<Integer> substrings(String str, String sub){
        Deque<Integer> stack = new ArrayDeque<>();
        if(sub.length() > str.length()) return stack;

        int i = 0;
        while(i<= (str.length() - sub.length())){
            int j = 0;
            while(j<sub.length() && str.charAt(i+j) == sub.charAt(j)){
                j++;
            }
            if(j==sub.length()){
                stack.offerFirst(i+j-1);
                i = i + j -1;
            }
            i++;
        }
        return stack;
    }
}

class replace{
    public static void main(String[] args){
        Solution649 solution = new Solution649();
        String s = "laicode";
        String str = solution.replace(s, "code", "offer");
        System.out.println(str);

    }
}