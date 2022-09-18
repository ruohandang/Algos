import java.util.List;

class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int res = 0;
        for(int i = q.size()-1; i>=0; i--){
            int chPos = q.get(i) - (i+1);
            if(chPos>2) {
                System.out.println("Too chaotic");
                return;
            }else{
                // find the starting index
                // range[num-2, arr.length] or 0 to length;
                int start = Math.max(0, q.get(i) - 2);
                for(int j = start; j<i; j++){
                    if(q.get(j) > q.get(i)) res++;
                }
            }
        }
        System.out.println(res);
    }
}
