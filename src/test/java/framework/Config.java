package framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Config {

    private static HashMap<String, String> data = new HashMap<String, String>();
    private static Properties prop = new Properties();

    protected Config()    {
        String sConfigFilePath = "src\\main\\resources\\config.properties";
        try (InputStream input = new FileInputStream(sConfigFilePath)) {

            prop.load(input);
            Set<Object> keys = prop.keySet();

            for(Object k:keys)  {
                String key=(String) k;
                String value=prop.getProperty(key);
                data.put(key, value);
            }
        }
        catch (Exception e) {
            System.out.println("Error reading config file: " + e);
        }
    }

    public static String getProperty(String key)    {
        return data.getOrDefault(key, "");
    }

    protected static String getReportConfigPath(){
        String reportConfigPath = prop.getProperty("reportConfigPath");
        if(reportConfigPath!= null)
            return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file");
    }
}
