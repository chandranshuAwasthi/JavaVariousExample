package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by kevinj.
 */


public class Container {
    Map<Class, Registration> registrations;
    Map<Class, Converter> converters = new HashMap<Class, Converter>();

    interface Converter<T> {
        T convert(String valueAsString);
    }

    public Container(String configuratonPath) throws IoCException {

        File file = new File(configuratonPath);
        if (!file.exists()) {
            throw new IoCException(new FileNotFoundException());
        }

        Loader loader = new Loader();

        registrations = loader.loadConfiguration(configuratonPath);

        registerConverters();
    }


    public <T> T resolve(Class<T> type) throws IoCException {
        // find type in registrations map
        Registration registration = registrations.get(type);
        List<com.pluralsight.Constructor> constructorParams = registration.getConstructorParams();
        T instance;
        try {
            Class cls = Class.forName(registration.getMapTo());
            // find biggest ctor
            Constructor longestConstructor = getLongestConstructor(cls);
            // resolve all the ctor params

            Parameter[] parameters = longestConstructor.getParameters();

            // apply any ctor args from map by name
            List<Object> parameterInstances = new ArrayList<Object>();
            for (Parameter parameter : parameters) {
                Class parameterClass = parameter.getType();
                if (parameterClass.isPrimitive() || parameterClass.isAssignableFrom(String.class)) {
                    getNonReferenceParameters(constructorParams, parameterInstances, parameter, parameterClass);
                } else {
                    getConfiguredParameters(parameterInstances, parameterClass);
                }
            }
            // create type
            instance = createInstance(longestConstructor, parameterInstances);
        } catch (Exception e) {
            throw new IoCException(e);
        }
        return instance;
    }

    private void getConfiguredParameters(List<Object> parameterInstances, Class parameterClass) throws IoCException {
        Object resolvedInstance = resolve(parameterClass);
        parameterInstances.add(resolvedInstance);
    }

    private void getNonReferenceParameters(List<com.pluralsight.Constructor> constructorParams, List<Object> parameterInstances, Parameter parameter, Class parameterClass) {
        Object value = null;
        for (com.pluralsight.Constructor ctor : constructorParams) {
            if (ctor.getName().equals(parameter.getName())) {
                value = ctor.getValue();
                break;
            }
        }
        Converter c = converters.get(parameterClass);

        parameterInstances.add(c.convert(value.toString()));
    }

    private <T> T createInstance(Constructor longestConstructor, List<Object> parameterInstances) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        T instance;
        Parameter[] parameterTypes = longestConstructor.getParameters();

        Object[] parameters = new Object[parameterTypes.length];
        for (int ndx = 0; ndx < parameterTypes.length; ndx++) {
            Class argumentClass = parameterInstances.get(ndx).getClass();
            Class parameterClass = parameterTypes[ndx].getType();
            if (parameterClass.isPrimitive() || argumentClass.isPrimitive()) {
                if (primitivesMatch(argumentClass, parameterClass)) {
                    parameters[ndx] = parameterInstances.get(ndx);
                }
            }
            if (parameterClass.isAssignableFrom(argumentClass)) {
                parameters[ndx] = parameterInstances.get(ndx);
            }
        }
        instance = (T) longestConstructor.newInstance(parameters);
        return instance;
    }

    private Constructor getLongestConstructor(Class cls) {
        Constructor[] constructors = cls.getConstructors();
        Constructor longestConstructor = constructors[0];
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() > longestConstructor.getParameterCount()) {
                longestConstructor = constructor;
            }
        }
        return longestConstructor;

    }

    private boolean primitivesMatch(Class argumentClass, Class parameterClass) {
        if ((argumentClass == int.class || argumentClass == Integer.class) && (parameterClass == int.class || parameterClass == Integer.class)) {
            return true;
        }
        if ((argumentClass == byte.class || argumentClass == Byte.class) && (parameterClass == byte.class || parameterClass == Byte.class)) {
            return true;
        }
        if ((argumentClass == short.class || argumentClass == Short.class) && (parameterClass == short.class || parameterClass == Short.class)) {
            return true;
        }
        if ((argumentClass == long.class || argumentClass == Long.class) && (parameterClass == long.class || parameterClass == Long.class)) {
            return true;
        }
        if ((argumentClass == char.class || argumentClass == Character.class) && (parameterClass == char.class || parameterClass == Character.class)) {
            return true;
        }
        if ((argumentClass == double.class || argumentClass == Double.class) && (parameterClass == double.class || parameterClass == Double.class)) {
            return true;
        }
        if ((argumentClass == float.class || argumentClass == Float.class) && (parameterClass == float.class || parameterClass == Float.class)) {
            return true;
        }
        if ((argumentClass == boolean.class || argumentClass == Boolean.class) && (parameterClass == boolean.class || parameterClass == Boolean.class)) {
            return true;
        }
        if ((argumentClass == int.class || argumentClass == Integer.class) && (parameterClass == int.class || parameterClass == Integer.class)) {
            return true;
        }
        return false;
    }

    private void registerConverters() {
        converters.put(int.class, Integer::parseInt);
        converters.put(float.class, Float::parseFloat);
        converters.put(double.class, Double::parseDouble);
        converters.put(byte.class, Byte::parseByte);
        converters.put(long.class, Long::parseLong);
        converters.put(short.class, Short::parseShort);
        converters.put(boolean.class, Boolean::parseBoolean);
        converters.put(String.class, s -> s);
        converters.put(Character.class, c -> c);
    }

}
