class packingUpSwags {
    public int minBoxes(int swags){
        if(swags <= 0) return 0;
        int[] M = new int[swags+1];
        M[1] = 1;

//        for (int i = 2; i <= swags; i++) {
//            M[i] = i;
//            for (int j = 1; j * j <= i; j++) {
//                M[i] = Math.min(M[i - j * j] + 1, M[i]);
//            }
//        }

        for(int i = 2; i< M.length; i++){
            if(isPower(i)){
                M[i] = 1;
            }else{
                for(int j = 1; j < i; j++){
                    if(M[j]!=0 && isPower(i - j)){
                        if(M[i]==0){
                            M[i] = M[j] + 1;
                        }else{
                            M[i] = Math.min(M[i], M[j]+1);
                        }
                    }
                }
            }
        }
        return M[M.length-1];
    }
    private boolean isPower(int n){
        if(n==1) return true;
        for(int i = 0; i<=n/2; i++){
            if(i * i == n){
                return true;
            }
        }
        return false;
    }
}

class swags{
    public static void main(String[] args){
        packingUpSwags s = new packingUpSwags();
        int num = s.minBoxes(10);
        System.out.println(num);
    }
}
