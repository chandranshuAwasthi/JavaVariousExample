package com.mantiso;

import com.pluralsight.IQuote;

import java.lang.reflect.InvocationTargetException;

// run with -Djava.library.path=path-to-quth-DLL (e,g, C:\demos\LoadingFromDb\Client\lib\x64

public class Main {
    public static void main(String[] args) {
        try {
            SqlServerClassLoader cl = new SqlServerClassLoader("jdbc:sqlserver://localhost;databaseName=classloading;integratedSecurity=true");
            Class clazz = cl.findClass("com.pluralsight.Quote");
            IQuote quote = (IQuote) clazz.getDeclaredConstructor().newInstance();
            System.out.println(quote.getQuote());
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
