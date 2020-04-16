class Knapsack2 { 
	
    static int max(int a, int b)  
{ 
    	return (a > b) ? a : b;

} 
  
    public static int knapSackProblem(int cw, int gwt[], int pro[], int n)
  
    { 
        int i, w; 
        int M[][] = new int[n + 1][cw + 1];//Build a memoization matrix in bottom up manner.
   
        for (i = 0; i<= n; i++) { 
            for (w = 0; w<= cw; w++) { 
                if (i == 0 || w == 0) 
                    M[i][w] = 0; 
                else if (gwt[i - 1]<= w) 
                    M[i][w] = max(pro[i - 1] + M[i - 1][w - gwt[i - 1]], M[i - 1][w]); 
                else
                    M[i][w] = M[i - 1][w]; 
            } 
        } 
  
        return M[n][cw]; 
    } 

    public static void main(String args[]) 
    { 
        int pro[] = new int[] { 2, 3,1,4 };//Given profits associated with each weight
        int gwt[] = new int[] { 3,4,6,5 };//Given Weights
        int cw =8;//Capacity it can hold
        int n = pro.length;//Number of items.
        System.out.println("Maximum Profit is "+knapSackProblem(cw, gwt, pro, n)); 
    } 
} 