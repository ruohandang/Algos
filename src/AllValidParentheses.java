import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class AllValidParentheses {
    public List<String> validParenthesesIII(int l, int m, int n) {
        // Write your solution here
        // different from the previous one is that the when we add the left one, we have priority
        List<String> res = new ArrayList<String>();
        if(l==0 && m==0 && n==0){
            return res;
        }
        char[] p = new char[]{'(',')', '<', '>', '{', '}'};
        int[] counter = new int[]{l,l,m,m,n,n};
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 2*(l+m+n);
        dfs(res, p, counter, sb, total, stack);
        return res;
    }

    private void dfs(List<String> res, char[] p, int[] count, StringBuilder sb, int total, Deque<Integer> stack){
        if(sb.length()==total){
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i<p.length; i++){
            if(i%2==0){
                if(count[i]>0 &&(stack.isEmpty() || stack.peekFirst() > i)){
                    sb.append(p[i]);
                    stack.offerFirst(i);
                    count[i]--;

                    dfs(res, p, count, sb, total,stack);

                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    count[i]++;
                }
            }else{
                if(!stack.isEmpty() && stack.peekFirst() == i-1){
                    sb.append(p[i]);
                    stack.pollFirst();
                    count[i]--;

                    dfs(res, p, count, sb, total,stack);

                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i-1);
                    count[i]++;
                }
            }
        }
    }
}

class parenthese{
    public static void main(String[] args){
        AllValidParentheses solution = new AllValidParentheses();
        List<String> res = solution.validParenthesesIII(1,1,1);
        System.out.println(res);
    }
}
