package problem.maxmin;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void sort(int[] a)
    {
        quickSort(a, 0, a.length-1);
    }
    
    public static void quickSort(int[] q, int start, int end)
    {
        if(start >= end)    
        {
            return;
        }
        
        int pIndex = partition(q, start, end);
        
        quickSort(q, start, pIndex-1);
        
        quickSort(q, pIndex+1, end);
        
    }
    
    public static int partition(int[] p, int start, int end)
    {
        int pivot = p[end];
        
        int pIndex = start;
        
        for(int i=start; i<end; i++)
        {
            if(p[i] >= pivot)
            {
                swap(p, i, pIndex);
                pIndex++;
            }
        }
        swap(p, end, pIndex);
        
        return pIndex;
    }
    
    public static void swap(int[] s, int a, int b)
    {
        int temp=0;
        temp= s[a];
        s[a] = s[b];
        s[b]= temp;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++)
        {
            arr[arr_i] = in.nextInt();
        }
        
        sort(arr);
        
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}

