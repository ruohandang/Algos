class passwords {
    boolean isSimilar(String newStr, String oldStr){
        if(newStr.length() < oldStr.length()){
            return false;
        }
        int oldIdx = 0;
        int newIdx = 0;
        while(newIdx < newStr.length() && oldIdx < oldStr.length()){
            if(newStr.charAt(newIdx) == oldStr.charAt(oldIdx) || change(newStr.charAt(newIdx)) == oldStr.charAt(oldIdx)){
                oldIdx++;
            }
            newIdx++;
        }
        return oldIdx == oldStr.length();
    }

    char change(char c){
        if(c =='z'){
            return 'a';
        }
        int i=  c;
        i = i + 1;
        return (char) i;
    } 
}
