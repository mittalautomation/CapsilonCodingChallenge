package com.capsilon.qa.javaprogram;

public class PermutationsOfNo {

	static int level = -1; 
	  
	static void print(int perm[], int N) 
	{ 
	    for (int i = 0; i < N; i++) 
	        System.out.print(" " + perm[i]); 
	    System.out.println(); 
	} 
	  
	// A function implementing  // Alexander Bogomolyn algorithm. 
	static void AlexanderBogomolyn(int perm[], int N, int k) 
	{ 
	  
	    // Assign level to zero at start. 
	    level = level + 1; 
	    perm[k] = level; 
	  
	    if (level == N) 
	        print(perm, N); 
	    else
	    	
	        for (int i = 0; i < N; i++) 
	            // Assign values to the array if it is zero. 
	            if (perm[i] == 0) 
	                AlexanderBogomolyn(perm, N, i); 
	    level = level - 1;    
	    perm[k] = 0; 
	} 
	
	
	public static void main(String[] args) {
		
		int i, N = 3; 
	    int perm[] = new int[N]; 
	    AlexanderBogomolyn(perm, N, 0); 
	} 
	}

