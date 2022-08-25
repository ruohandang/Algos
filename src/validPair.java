import java.util.List;

class validPair {
    public void validBlocks(int n){
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, 0, 0);
    }

    private void dfs(StringBuilder sb, int n, int left, int right){
        if(left==n && right == n){
            System.out.println(sb.toString());
            return;
        }

        if(left<n){
            int len = sb.length();
            if(left==right){
                sb.append("if{"+"\n");
            }else{
                int diff = left - right;
                sb.append("  " .repeat(diff) + "if{"+"\n");
            }
            dfs(sb, n, left+1, right);
            sb.setLength(len);
        }

        if(right<left){
            int len = sb.length();
            if(right == left - 1){
                sb.append("}"+"\n");
            }else{
                int diff = left - right -1;
                sb.append("  " .repeat(diff) + "}"+"\n");
            }
            dfs(sb, n, left, right+1);
            sb.setLength(len);
        }
    }
}

class s{
    public static void main(String[] args){
        validPair solution = new validPair();
        solution.validBlocks(3);
    }
}
