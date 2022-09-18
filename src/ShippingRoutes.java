import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time complexity: 0(n^2)
// space complexity: O(1)
class ShippingRoutes {
    public List<int[]> optimal(int max, List<int[]> forwardList,List<int[]> returnList){
        List<int[]> res = new ArrayList<>();
        if(forwardList==null && returnList==null)  return res;
        int maxSum = 0;

        for(int[] f : forwardList){
            for(int[] r : returnList){
                if(f[1] + r[1] <= max){
                    maxSum = Math.max(maxSum, f[1] + r[1]);
                }
            }
        }

        // we can build up a hashmap to store each sum as a key, a list of index pair as value, then second step as O(1)
        for(int[] f : forwardList){
            for(int[] r : returnList){
                if(f[1] + r[1] == maxSum){
                    res.add(new int[]{f[0], r[0]});
                }
            }
        }
        return res;
    }
}

class routes{
    public static void main(String[] args){
        ShippingRoutes s = new ShippingRoutes();
        List<int[]> forward =new ArrayList<>();
        forward.add(new int[]{1, 3000});
        forward.add(new int[]{2, 5000});
        forward.add(new int[]{3, 7000});
        forward.add(new int[]{4, 10000});

        List<int[]> backward =new ArrayList<>();
        backward.add(new int[]{1, 2000});
        backward.add(new int[]{2, 3000});
        backward.add(new int[]{3, 4000});
        backward.add(new int[]{4, 5000});


        List<int[]> res = s.optimal(10000, forward, backward);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }
}
