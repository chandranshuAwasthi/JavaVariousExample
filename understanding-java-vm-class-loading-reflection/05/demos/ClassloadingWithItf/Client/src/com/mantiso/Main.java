package com.mantiso;

//import com.pluralsight.IQuote;
//import com.pluralsight.Quote;

import com.pluralsight.IQuote;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by kevinj.
 */
public class Main {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
            URLClassLoader ucl1 = new URLClassLoader(new URL[]{url1});
            Class clazz1 = Class.forName("com.pluralsight.Quote", true, ucl1);
            IQuote quote1 = (IQuote) clazz1.getDeclaredConstructor().newInstance();

            URL url2 = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
            URLClassLoader ucl2 = new URLClassLoader(new URL[]{url2});
            Class clazz2 = Class.forName("com.pluralsight.Quote", true, ucl2);
            IQuote quote2 = (IQuote) clazz2.getDeclaredConstructor().newInstance();

            System.out.printf("clazz1 == clazz2? %b\n", clazz1 == clazz2);
            System.out.printf("quote1.class == quote2.class? %b\n", quote1.getClass() == quote2.getClass());

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
