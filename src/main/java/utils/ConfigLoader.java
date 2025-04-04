package utils;

import io.cucumber.java.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();
    static {
        setUp();
    }


    @BeforeAll
    public static void setUp()
    {
//        String configFilePath = System.getProperty("spring.config.location");
        String configFilePath="application-UATB.properties";
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(configFilePath)) {
            if (input == null) {
                throw new RuntimeException("Properties file not found: " + configFilePath);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + configFilePath, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
