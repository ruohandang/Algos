import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class BoxVersions {
    public List<String> boxVersion(List<String> input){
        if(input==null || input.size() <=1) return input;
        List<String> res = new ArrayList<>();
        List<String[]> tmp = new ArrayList<>();
        List<Integer> indice = new ArrayList<>();
        for(int i = 0; i<input.size(); i++){
            String s = input.get(i);
            if(Character.isDigit(s.charAt(s.length() - 1))){
                indice.add(i);
            }else{
                String[] strings = s.split(" ", 2);
                tmp.add(strings);
                // TODO!!!need to sort the tmp list by the version information first and then identifier

            }
        }

        // if we get the list then
        for(String[] s : tmp){
            String combine = s[0] + " " + s[1];
            res.add(combine);
        }
        for(Integer i : indice){
            res.add(input.get(i));
        }
        return res;
    }
}
