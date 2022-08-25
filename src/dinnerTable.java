class dinnerTable {
    public boolean canLoop(String[] names){
        // we start from 1, cuz its a loop, does not matter which one put first
        int index = 1;
        return canLoop(names, index);
    }

    private boolean canLoop(String[] names, int index){
        // base case
        // if the index reach the length of names then we will check the last one can connect with the first one
        if(index == names.length){
            return connect(names[index -1], names[0]);
        }

        // use swap to locked one location each time, if one qualified then dfs
        for(int i = index; i < names.length; i++){
            if(connect(names[index - 1], names[i])){
                swap(names, index, i);
                if(canLoop(names, index+1)){
                    return true;
                }
                swap(names, index, i);
            }
        }
        return false;
    }

    private boolean connect(String s1, String s2){
        return s1.charAt(s1.length()-1) == s2.charAt(0);
    }

    private void swap(String[] arr, int i, int j){
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class dinner{
    public static void main(String[] args){
        dinnerTable s = new dinnerTable();
        String[] names = new String[]{"ALICE", "CHARLES", "ERIC", "SOPHIA"};
        boolean res = s.canLoop(names);
        System.out.println(res);
    }
}


