import java.util.List;

class longestCross104 {
     public int largest(int[][] matrix) {
         // Write your solution here
         if(matrix.length == 0 || matrix[0].length == 0){
             return 0;
         }
         int row = matrix.length;
         int col = matrix[0].length;

         int[][] left = new int[row][col];
         int[][] right = new int[row][col];
         int[][] top = new int[row][col];
         int[][] bottom = new int[row][col];

         // M[i][j] represent for the current index,
         int[][] M = new int[row][col];
         int longestArm = 0;

         for(int i = 0; i < row; i++){
             for(int j = 0; j < col; j++){
                 if(i==0 && j==0){
                     left[i][j] = matrix[i][j];
                     right[i][col-1-j] = matrix[i][col-1-j];
                     top[i][j] = matrix[i][j];
                     bottom[row-1-i][j] = matrix[row-1-i][j];
                 }
                 if(matrix[i][j]==0){
                     top[i][j]=0;
                     bottom[i][j]=0;
                     left[i][j]=0;
                     right[i][j]=0;
                 }
                  if(i==0 && j!=0){
                     left[i][j] = left[i][j-1]+1;
                     right[i][col-1-j] = right[i][col-j] + 1;
                     top[i][j] = matrix[i][j];
                     bottom[row-1-i][j] = matrix[row-1-i][j];
                 }
                 else if(i!=0 && j==0){
                     left[i][j] = matrix[i][j];
                     right[i][col-1-j] = matrix[i][col-1-j];
                     top[i][j] = top[i-1][j]+1;
                     bottom[row-1-i][j] = bottom[row-i][j] + 1;
                 }
                 else{
                     left[i][j] = left[i][j-1] + 1;
                     right[i][col-1-j] = right[i][col-j] + 1;
                     top[i][j] = top[i-1][j] + 1;
                     bottom[row-1-i][j] = bottom[row-i][j] + 1;
                 }
             }
         }

         for(int i = 0; i<row; i++){
             for(int j = 0; j<col; j++){
                 M[i][j] = Math.min(Math.min(left[i][j], right[i][j]),
                         Math.min(top[i][j], bottom[i][j]));
                 longestArm = Math.max(longestArm, M[i][j]);
             }
         }
         return longestArm;
     }
}

class cross{
    public static void main(String[] args){
        longestCross104 solution = new longestCross104();
        int[][] mat = new int[][]{ {0, 0, 0, 0},

                {1, 1, 1, 1},

                {0, 1, 1, 1},

                {1, 0, 1, 1} };
        int res = solution.largest(mat);
        System.out.println(res);
    }
}
