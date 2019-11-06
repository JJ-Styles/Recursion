/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author t7047098
 */
public class Recursion
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] arr = {1,4,2,7,3,9,0};
        
        System.out.println(sum(1,10));
        System.out.println(sumSquares(3,5));
        System.out.println(sumSquaresGoingDown(3,5));
        System.out.println(factorial(10));
        System.out.println(product(1,5));
        System.out.println(reverseString("hello"));
        System.out.println(maxArray(arr,0,0));
        System.out.println(contains(arr,7,0));
        System.out.println(contains(arr,8,0));
        System.out.println(changeXY("hxexllox"));
        System.out.println(changeXY("hello"));
        
        LinkedList list = new LinkedList(arr);
        System.out.println(list.toEndOfList(list.getHead()));
        System.out.println(list.getSize(list.getHead()));
        System.out.println(list.toNodeWithVal(7, list.getHead()));
        System.out.println(list.toNodeWithVal(8, list.getHead()));
        
        System.out.println(rabbit(10));
        System.out.println(itRabbit(10));
        System.out.println(itRabbit(100));
        System.out.println(rabbit(100));    
    }
    
    static int sum(int m, int n)
    {
        if (m == n)
            return n;
        else
            return sum(m+1,n) + m;
    }
    
    static int sumSquares(int m, int n)
    {
        if (m == n)
            return n*n;
        else
            return sumSquares(m+1,n) + (m*m);
    }
    
    static int sumSquaresGoingDown(int m, int n)
    {
        if (m == n)
            return n*n;
        else
            return sumSquares(m,n-1) + (n*n);        
    }
    
    static int factorial(int n)
    {
        if (n == 2)
            return 2;
        else
            return factorial(n-1) * n;
    }
    
    static int product(int m, int n)
    {
        if (n == m)
            return n;
        else
            return product(m + 1,n) * m;
    }
    
    static String reverseString(String n)
    {
        if (n.length() == 1)
            return n;
        else
            return reverseString(n.substring(1,n.length())) + n.substring(0,1);
    }
    
    static int maxArray(int[] arr, int temp, int i)
    {
        if (i == arr.length)
            return temp;
        else if (arr[i] > temp)
            temp = arr[i];
        return maxArray(arr,temp,i+1);
    }
    
    static boolean contains(int[] arr, int search, int i)
    {
        if (i == arr.length)
            return false;
        else if (arr[i] == search)
            return true;
        return contains(arr, search,i+1);
    }
    
    static String changeXY(String str)
    {
        if (str.length() == 1 && str.toLowerCase().charAt(str.length()-1) == 'x')
            return "y";
        else if (str.length() == 1 && !(str.toLowerCase().charAt(str.length()-1) == 'x'))
            return str;
        else if (str.toLowerCase().charAt(str.length()-1) == 'x') 
            return changeXY(str.substring(0, str.length()-1)) + "y";
        return changeXY(str.substring(0, str.length()-1)) + str.substring(str.length()-1);
    }
    
    static int rabbit(int n)
    {
        if (n == 2)
            return 1;
        else if (n== 1)
            return 1;
        else if (n == 0)
            return 1;
        else
           return rabbit(n-1) + rabbit(n-3);
    }
    
    static int itRabbit(int n)
    {
        int[] rSeq = new int[n +1];
        
        rSeq[0] = 1;
        rSeq[1] = 1;
        rSeq[2] = 1;
        
        for (int i = 3; i <= n; i++)
        {
            rSeq[i] = rSeq[i-1] + rSeq[i-3];
        }
        
        return rSeq[n];
    }
    
    static double power(int x, int n)
    {
        if (n== 1)
            return x;
        return x * power(x,n-1);
    }
    
    static double halfPower(int x, int n)
    {
        if (n ==1)
            return x;
        else if (n % 2 == 1)
            return halfPower(x,n/2) * halfPower(x,n/2) * x;
        return halfPower(x,n/2) * halfPower(x,n/2);
    }
}
