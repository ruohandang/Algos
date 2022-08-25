class minCuts {
    public int minCuts(String input){
        if(input==null || input.length()<=1) return 0;

        /*create an integer array to store the minCuts for from the begining end at and including each index.*/
        int[] M =new int[input.length()+1];

        // base cases
        M[0] = 0;
        M[1] = 0;

        for(int i = 2; i< M.length;i++){
            M[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
                if(isPalindrome(input.substring(j,i))){
                    if(j==0){
                        M[i] = 0;
                        break;
                    } else {
                        M[i] = Math.min(M[i], M[j] + 1);
                    }
                }
            }
        }
        return M[M.length-1];
    }

    private boolean isPalindrome(String s){
        if(s==null|| s.length()<=1) return true;
        for(int i=0; i<s.length()/2;i++){
            if(s.charAt(i)!= s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

class sol{
    public static void main(String[] args){
        minCuts solution = new minCuts();
        int i = solution.minCuts("aaaa");
        System.out.println(i);
    }
}

