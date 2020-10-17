Hermione is attending the Magic Potion's Class in Hogwarts . She has N potions in front of her lying in a row . Her task is to combine these potions into 1 . In order to do so she can pick any two adjacent potions of color A,B and mix them to form another potion of color C=(A+B)%100 which will then replace A and B in the row (Two potions combine to form one potion) . But when a new potion is formed it produces smoke of value A*B . Hermione needs your help to minimise the smoke produced in the above task .
Input Format :
Line 1 : Integer N 
Line 2 : A list of N integers, representing colors of each potion
Output Format :
Minimum Smoke that can be produced
Constraints :
1<= N <=100
0 <= color of a potion <= 99
Sample Input :
3
1 2 4
Sample Output :
14



public class solution {
    public static int[][] dp=new int[105][105];
    public static int[]v=new int[105];
    public int getsum(int a,int b)
    {
        int sum=0;
        for(int i=a;i<=b;i++)
        {
            sum+=v[i];
            sum%=100;
        }
        return sum;
    }
    public int min(int a,int b)
    {
        if(a<b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
    public int solver(int x,int y)
    {
        if(x==y)
        {
            return 0;
        }
        if(dp[x][y]!=0)
        {
            return dp[x][y];
        }
        int smoke=100000000;
        for(int i=x;i<y;i++)
        {
            smoke=min(solver(x,i)+solver(i+1,y)+getsum(x,i)*getsum(i+1,y),smoke);
        }
        return dp[x][y]=smoke;
    }
    public int solve(int n,int colors[]){
        //write your code here
        for(int i=0;i<n;i++)
        {
            v[i]=colors[i];
        }
        return solver(0,n-1);
    }
}
