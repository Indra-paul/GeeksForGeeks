import java.util.*;

public class P20230712PowerOfNumbers{
	public static void main(String args[]){
		int num, revNum;
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		revNum=revNumFunc(num);
		
		Solution s = new Solution();
		System.out.println(s.power(num,revNum));
	}
	
	static int revNumFunc(int num){
		int revNum=0;
		while(num>0){
			revNum*=10;
			revNum+=num%10;
			num/=10;
		}
		return revNum;
	}
}
class Solution
{
        
    long power(int n,int r)
    {
        //Your code here
       
       //APPROACH 1: time limit exceeds for test case 12.        
       /*
       double mul=1;
       int limit = 0;
       
       while(limit++<R){
           mul*=N;
           if(mul>1000000007){
               mul%=1000000007;
           }
       }
       return (long)mul;
       */
       
       long ans = 1;
        int m = (int) Math.pow(10, 9) + 7;
        
        while (r > 0) {
            if ((r & 1) != 0) {
                ans = (1L * ans * (n % m)) % m;
            }
            n = (int) (((1L * n % m) * (n % m)) % m);
            r = r >> 1;
        }
        
        return ans;
    }

}