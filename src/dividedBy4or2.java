import java.util.Arrays;
import java.util.List;

class dividedBy4or2 {
    public int[] allWays(int[] wheels){
        if(wheels==null || wheels.length < 1) return wheels;
        int[] res = new int[wheels.length];
        int[] numsWheel = new int[]{4, 2};
        for(int i = 0 ; i < res.length; i++){
            if(wheels[i]%2!=0){
                res[i] = 0;
            }else{
                dfs(i, res, wheels[i], numsWheel, 0);
            }
        }
        return res;
    }

    private void dfs(int i, int[] res, int target, int[] nums, int index) {
        if(index==nums.length-1){
            if(target%nums[index]==0){
                res[i]++;
            }
            return;
        }
        int max = target/nums[index];
        for(int it = 0; it<= max; it++){
            dfs(i, res, target - it*nums[index], nums, index+1);
        }
    }
}

class devide{
    public static void main(String[] args){
        dividedBy4or2 s = new dividedBy4or2();
        int[] res = s.allWays(new int[]{4, 5, 6});
        for (int i :res){
            System.out.println(i);
        }
    }
}