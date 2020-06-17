package Q1.Stack_and_Q;

import java.util.Scanner;

public class question1
{
    public final static int MAX = 100;
    public static int[] stack = new int[MAX];
    public static int top = -1;

    public static void push(int t)
    {
        if (top > MAX - 1)
        {
            System.out.println("Stack overflow");
            return;
        }

        stack[++top] = t;
    }

    public static int pop()
    {
        if (top == -1)
        {
            System.out.println("Stack underflow");
            return -1;
        }

       return stack[top--];
    }

    public static void parenthesis(char arr[])
    {
        int i = 0;
        for (char a : arr)
        {
           

            i++;
        }
    }

    public static void main(String[] args)
    {
        char[] arr = new char[100];
        Scanner sc = new Scanner(System.in);
        arr = sc.nextLine().toCharArray();

        parenthesis(arr);
    }
}