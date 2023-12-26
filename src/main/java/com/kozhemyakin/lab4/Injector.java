package com.kozhemyakin.lab4;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author n.s.kozhemyakin
 */
public class Injector {
    /**
     * Constructs a new `Injector` object.
     */
    public Injector() {}
    /**
     * Injects dependencies into the specified object based on annotations and configuration properties.
     *
     * @param object The object into which dependencies will be injected.
     * @param path   The file path to the configuration properties file.
     * @param <T>    The type of the object being injected.
     * @return The object with injected dependencies.
     * @throws IOException If an I/O error occurs while reading the configuration properties file.
     */
    public <T> T inject(T object, String path) throws IOException {
        // Create a PropertyLoader to load configuration properties from the specified path.
        PropertyLoader propertyLoader = new PropertyLoader();
        propertyLoader.loadProperties(path);

        // Get the declared fields of the object.
        Field[] fields = object.getClass().getDeclaredFields();

        // Iterate through the fields and inject dependencies based on annotations.
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                // Retrieve the class name of the field type.
                String fieldClassName = field.getType().getName();

                // Get the injected class name from the configuration properties.
                String injectedClassName = propertyLoader.getProperty(fieldClassName);

                // If a class name is found, set the field value with an instance of the injected class.
                if (injectedClassName != null) {
                    field.setAccessible(true);

                    try {
                        // Load the injected class and create an instance.
                        Class<?> injectedClass = Class.forName(injectedClassName);
                        Object classObject = injectedClass.getDeclaredConstructor().newInstance();

                        // Set the field value with the created instance.
                        field.set(object, classObject);
                    } catch (ClassNotFoundException | InstantiationException |
                             IllegalAccessException | NoSuchMethodException |
                             java.lang.reflect.InvocationTargetException e) {
                        // Handle exceptions that may occur during class loading and instantiation.
                        e.printStackTrace();
                    }
                }
            }
        }
        return object;
    }
}