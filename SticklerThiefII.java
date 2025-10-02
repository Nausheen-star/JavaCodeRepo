class Solution {
    int maxValue(int[] arr) {
     
        int n = arr.length;
        if(n==1) return arr[0];
        
        int max1 = rob(arr, 0, n-2);
        int max2 = rob(arr, 1, n-1);
        
        return Math.max(max1, max2);
    }
    
    private int rob(int[] arr, int start, int end){
         int prev1 =0, prev2=0;
         
         for(int i=start; i<=end; i++){
             int pick = arr[i] + prev2;
             int notPick = prev1;
             int curr = Math.max(pick, notPick);
             
             prev2 = prev1;
             prev1 = curr;
         }
         return prev1;
    }
}
