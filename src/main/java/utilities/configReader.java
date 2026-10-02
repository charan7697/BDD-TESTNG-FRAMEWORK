package utilities;

import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = configReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }
    // A -D command-line value overrides the file (useful for Jenkins)
    public static String get(String key) {
        String sys = System.getProperty(key);
        return (sys != null && !sys.isBlank() && !sys.startsWith("${")) ? sys : props.getProperty(key);
    }

}
