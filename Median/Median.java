/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author FetchheLL
 */
public class Median {
    
    private static int N;
    
    private static void mergeSort(int[] firstArray, int[] secondArray, int rightAndLeftMedianElements[]) { 
        
        int idx = 0, idy = 0;
        for(int i = 0; i <= N; i++) {   
            
            if(idx != N && (idy == N || firstArray[idx] < secondArray[idy])) {
                if(i == (N - 1) || i == N) {
                    rightAndLeftMedianElements[i & 1] = firstArray[idx]; 
                }               
                idx++;
            }
            else {
                if(i == (N - 1) || i == N) {
                    rightAndLeftMedianElements[i & 1] = secondArray[idy]; 
                }                
                idy++;
            }
        }
    }
    
    public static void main(String[] args) {
       
        int[][] inputArrays = new int[2][];
        
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        
        try {           
            String delim = " ";
            
            String[] input = null;          
            for(int i = 0; i < 2; i++) {                     
                input = bufferRead.readLine().split(delim);  
                
                inputArrays[i] = new int[input.length];
                for(int j = 0; j < input.length; j++) {
                    inputArrays[i][j] = Integer.parseInt(input[j]);
                }             
            }   
            N = input.length;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        int[] rightAndLeftMedianElements = new int[2];
        
        // merge sort, time : O(N)           
        mergeSort(inputArrays[0], inputArrays[1], rightAndLeftMedianElements);        
        
        int leftFromMedianElement = Math.max(rightAndLeftMedianElements[0], rightAndLeftMedianElements[1]);
        int rightFromMedianElement = Math.min(rightAndLeftMedianElements[0], rightAndLeftMedianElements[1]);
            
        float diff = (leftFromMedianElement - rightFromMedianElement) / 2.0f;
            
        float medianElement = rightFromMedianElement + diff;
        
        System.out.println(medianElement);
    }
}