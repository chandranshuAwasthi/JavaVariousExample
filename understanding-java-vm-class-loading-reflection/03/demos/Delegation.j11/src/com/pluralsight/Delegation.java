package com.pluralsight;

import java.net.URL;
import java.net.URLClassLoader;

public class Delegation {
	public static void main(String[] args) {
		ClassLoader classLoader =  ClassLoader.getSystemClassLoader();
		do {
			System.out.println(classLoader.getName());
        } while ((classLoader =  classLoader.getParent()) != null);
        System.out.println("Bootstrap classloader");
	}
}