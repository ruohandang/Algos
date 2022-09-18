class packingUpSwags {
    public int minBoxes(int swags) {
        if (swags <= 0) return 0;
        // M[i] represents the minimum number of boxes to pack num swags up
        int[] M = new int[swags + 1];
        M[1] = 1;

        for (int i = 2; i <= swags; i++) {
            M[i] = i;
            // only loop the power of the value, optimization
            for (int j = 1; j * j <= i; j++) {
                // find the location which has a power value later
                M[i] = Math.min(M[i - j * j] + 1, M[i]);
            }
        }
        return M[M.length-1];
    }
}
class swags{
    public static void main(String[] args){
        packingUpSwags s = new packingUpSwags();
        int num = s.minBoxes(10);
        System.out.println(num);
    }
}