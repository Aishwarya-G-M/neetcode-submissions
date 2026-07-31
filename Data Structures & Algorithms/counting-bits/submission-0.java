class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for(int i=1;i<=n;i++){
            result[i]= calcNumOf1(i);
        }
        return result;
    }

    private int calcNumOf1(int num){
        int count = 0;
        while(num!=0){
            count += num%2;
            num = num/2;
        }
        return count;
    }
}
