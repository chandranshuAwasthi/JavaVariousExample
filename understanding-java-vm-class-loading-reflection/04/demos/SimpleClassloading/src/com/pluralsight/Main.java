package com.pluralsight;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
	public static void main(String[] args) {
        URL url;
        try {
            url = new URL("file:///c:/demos/lib/quoter.jar");
            URLClassLoader ucl = new URLClassLoader(new URL[]{url});
            Class clazz = ucl.loadClass("com.mantiso.Quote");
            Object o = clazz.getDeclaredConstructor().newInstance();
            System.out.println(o.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}