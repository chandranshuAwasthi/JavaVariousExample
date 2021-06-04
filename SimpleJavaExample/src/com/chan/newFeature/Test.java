package com.chan.newFeature;

// Java program to find GCD of two numbers
public class Test
{
    // Recursive function to return gcd of a and b
	static int gcd(int a, int b) 
	{ 
	if (b == 0) 
		return a;
	int d=a % b;
	System.out.println(d);
	return gcd(b, a % b); 
	} 
	
	// Driver method 
	public static void main(String[] args) 
	{ 
		int a = 98, b = 56; 
		System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b)); 
	} 
} 
