import java.util.ArrayList;
import java.util.List;

class SprialMatrix122 {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        int rowSize = matrix.length;
        if(rowSize==0) return res;

        int colSize = matrix[0].length;

        helper(matrix, res, 0, rowSize, colSize);
        return res;
    }

    private void helper(int[][] mat, List<Integer> res, int offset, int rowSize, int colSize){
        if(rowSize <= 1 || colSize<=1){
            if(rowSize==1 && colSize==1){
                res.add(mat[offset][offset]);
            }
            else if(rowSize == 1 && colSize>1){
                for(int i=0; i<colSize;i++){
                    res.add(mat[offset][offset+i]);
                }
            }else if(colSize==1 && rowSize >1){
                for(int i=0; i<rowSize;i++){
                    res.add(mat[offset+i][offset]);
                }
            }
            return;
        }
        // offset is the upper-left corner of each box
        for(int i = 0; i<colSize-1; i++){
            res.add(mat[offset][i+offset]);
        }
        for(int i = 0; i<rowSize-1; i++){
            res.add(mat[i+offset][colSize-1+offset]);
        }
        for(int i = colSize-1; i>0; i--){
            res.add(mat[rowSize-1+offset][offset+i]);
        }
        for(int i = rowSize-1; i>0; i--){
            res.add(mat[offset+i][offset]);
        }
        helper(mat, res, offset+1, rowSize-2, colSize-2);
    }
}


class solution{
    public static void main(String[] args){
        SprialMatrix122 solution = new SprialMatrix122();
        int[][] mat = { {1,  2,  3,  4},

                {5,  6,  7,  8},

                {9, 10, 11, 12} };
        List<Integer> list= solution.spiral(mat);
        System.out.println(list);
    }
}