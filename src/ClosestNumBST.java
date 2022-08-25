 class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
        this.key = key;
   }
}
public class ClosestNumBST {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        int[] globalMin = {Integer.MAX_VALUE};
        TreeNode[] sol = null;

        if(root.key == target){
            sol[0] = root;
            return root.key;
        }else if(root.key>target){
            closestNum(root.left, globalMin, sol, target);
        }else{
            closestNum(root.right, globalMin, sol, target);
        }
        return sol[0].key;
    }

    private void closestNum(TreeNode root, int[] globalMin, TreeNode []sol, int target){
        if(root==null) return;
        if(root.key == target){
            sol[0] = root;
        }else{
            if(Math.abs(root.key-target)<globalMin[0]){
                globalMin[0] = Math.abs(root.key-target);
                sol[0] = root;
            }
        }
    }
}


 class solutionBst{
     public static void main(String[] args){
         ClosestNumBST solution = new ClosestNumBST();
         //TreeNode root = [10,5,15,2,9,11,23,1,null,6,null,null,12,21,25];
         int target = 17;
     }

}