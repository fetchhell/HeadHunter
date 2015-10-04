/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofpartitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author FetchheLL
 */
public class NumberOfPartitions {

    private static long[][][] numberOfPartitions;
    
    private static void calculateNumberOfPartitions(int n, int k) {
                    
        numberOfPartitions[0][0][0] = 1;
        
        for(int i = 1; i <= n; i++) { 
            for(int j = 1; j <= k; j++) { 
                for(int m = 0; m <= i; m++) { 
                    for(int a = 0; a <= m; a++) { 
                        numberOfPartitions[i][j][m] += numberOfPartitions[i - m][j - 1][a];
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        int n = 0, k = 0;
        
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        
        try {                 
            String delim = " ";           
            String[] input = bufferRead.readLine().split(delim);  
            
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);                 
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        numberOfPartitions = new long[n + 1][k + 1][n + 1];
        
        calculateNumberOfPartitions(n, k);
        
        int summaryNumberOfPartitions = 0;
        for(int i = 0; i <= n; i++) {
            summaryNumberOfPartitions += numberOfPartitions[n][k][i];
        }
        
        System.out.println(summaryNumberOfPartitions);
    }
    
}
