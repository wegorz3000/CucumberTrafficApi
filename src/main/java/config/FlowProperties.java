package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

public class FlowProperties {

    public static void main(String[] args) throws IOException {

        String propertiesFileName = "RestApiConfig.properties";
        FlowProperties flowProperties = new FlowProperties();
        System.out.println(flowProperties.readingPropertyFile(propertiesFileName, "incidents").getProperty("incidents.v1.z").getDefaultValue());
        //PropertyCollection tilesCollection = flowProperties.readingPropertyFile(propertiesFileName, "tiles");
        try {
            System.out.println(flowProperties.readingPropertyFile(propertiesFileName,"tiles").getProperty("tiles.v1.x").getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PropertyCollection readingPropertyFile(String propertiesFileName, String patternName) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.load(new FileInputStream(propertiesFileName));
        PropertyCollection collection = new PropertyCollection();
        for (String propertyName : defaultProperties.stringPropertyNames()) {
            if (Pattern.matches(""+patternName+".*", propertyName)){
                Property prop = new Property(propertyName,defaultProperties.getProperty(propertyName),true,false,false);
                collection.addProperty(prop);
            }
        }
        return collection;
    }

}
