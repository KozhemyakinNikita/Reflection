package com.kozhemyakin.lab4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author n.s.kozhemyakin
 */
public class PropertyLoader {
    /**
     * The Properties object to store loaded properties.
     */
    private Properties properties;
    /**
     * Loads properties from the specified file path into the `properties` object.
     *
     * @param path The file path to the properties file.
     * @throws IOException If an I/O error occurs while loading properties from the file.
     */
    public void loadProperties(String path) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            // Initialize the Properties object and load properties from the input stream.
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            // Propagate the exception with a more descriptive message.
            throw new IOException("Error loading properties from " + path, e);
        }
    }
    /**
     * Retrieves the property value associated with the specified key.
     *
     * @param key The key of the property.
     * @return The value associated with the specified key, or null if the key is not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}