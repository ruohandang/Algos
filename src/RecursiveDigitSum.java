class RecursiveDigitSum {
    public static int superDigit(String n, int k) {
        // Write your code here
        // high level: repeat the string k times until sum become single digit

        int sum = k * digSum(n);
        return digSum(Integer.toString(sum));
    }

    private static int digSum(String s){
        int sum = 0;
        for(int i = 0; i < s.length();i++){
            int c = s.charAt(i) - '0';
            sum += c;
        }
        if(sum==0) return 0;
        if(sum%9==0){
            return 9;
        }else{
            return sum%9;
        }
    }
}

