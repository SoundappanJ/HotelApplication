package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderUtil {

    private static final Properties pro= new Properties();
    static{
        try{
            FileInputStream file= new FileInputStream("src/main/resources/config.properties");

            pro.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return pro.getProperty(key);
    }
}
