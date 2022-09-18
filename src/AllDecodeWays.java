import java.util.ArrayList;
import java.util.List;

class AllDecodeWays {
    public List<String> decode(String input){
        List<String> res = new ArrayList<>();
        if(input==null || input.length()==0) return res;
        if(input.isEmpty()){
            res.add(input);
            return res;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        dfs(res, input, sb, index);
        return res;
    }

    private void dfs(List<String> res, String input, StringBuilder sb, int index) {
        if(index==input.length()){
            res.add(sb.toString());
            return;
        }
        int number = input.charAt(index) - '0';
        // number 1-9
        if(number >=1 && number <= 9){
            char curr = (char)(number - 1 + 'A');
            sb.append(curr);
            dfs(res, input,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }

        // two digits cases
        if(index+1<input.length()){
            // check the number
            number = (input.charAt(index) - '0') * 10 + (input.charAt(index+1) - '0');
            if(number >= 10 && number <= 26){
                char curr = (char)(number - 1 + 'A');
                sb.append(curr);
                dfs(res, input,sb,index+2);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}


class decodeWays{
    public static void main(String[] args){
        AllDecodeWays s = new AllDecodeWays();
        List<String> res = s.decode("2621");
        System.out.println(res);
    }
}