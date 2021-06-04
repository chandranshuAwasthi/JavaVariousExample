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
//            URL url = new URL("file:///C:/demos/ClassloadingWithItf/out/artifacts/Implementations_jar/Implementations.jar");
            URL url = new URL("http://localhost:8080/Implementations.jar");
            URLClassLoader ucl = new URLClassLoader(new URL[]{url});
            Class clazz = ucl.loadClass("com.pluralsight.Quote");
            IQuote quote = (IQuote) clazz.getDeclaredConstructor().newInstance();
            System.out.println(quote.getQuote());
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
