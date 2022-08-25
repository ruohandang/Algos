import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


class closestNumberInBST {

    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

     public int[] closestKValues(TreeNode root, double target, int k) {
         // Write your solution here

         Deque<Integer> deq = new ArrayDeque<>();
         dfs(root, target, k, deq);
         int[] res = new int[deq.size()];
         for(int i = 0; i<res.length; i++){
             res[i] = deq.pollFirst();
         }
         return res;
     }

     private void dfs(TreeNode root, double target, int k, Deque<Integer> deq){
         if(root==null) return;

         dfs(root.left, target, k, deq);
         if(deq.size() < k){
             deq.offerLast(root.key);
         }else{
             if(Math.abs(root.key - target) < Math.abs(deq.peekFirst() - target)){
                 deq.pollFirst();
                 deq.offerLast(root.key);
             }
         }
         dfs(root.right, target, k, deq);
     }
}



class closest{
    public static void main(String[] args){
        closestNumberInBST solution = new closestNumberInBST();

        System.out.println();
    }
}