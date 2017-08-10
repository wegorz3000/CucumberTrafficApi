package config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class FlowProperties {

    public static void main(String[] args) throws IOException {

        String propertiesFileName = "test.properties";
        FlowProperties flowProperties = new FlowProperties();
        //  System.out.println(flowProperties.readingPropertyFile(propertiesFileName, "incidents").getProperty("incidents.v1.z").getDefaultValue());
        //PropertyCollection tilesCollection = flowProperties.readingPropertyFile(propertiesFileName, "tiles");
        try {
            System.out.println(flowProperties.readingPropertyFile(propertiesFileName, "flow").getProperty("flow.v1.x").getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(flowProperties.readingPropertyFileTwo(flowProperties.readingPropertyFileWithMultiParameters(propertiesFileName),"flow").getProperty("flow.v1.x").getDefaultValue());
    }

    public PropertyCollection readingPropertyFile(String propertiesFileName, String patternName) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.load(new FileInputStream(propertiesFileName));
        PropertyCollection collection = new PropertyCollection();
        for (String propertyName : defaultProperties.stringPropertyNames()) {
            if (Pattern.matches("" + patternName + ".*", propertyName)) {
                Property prop = new Property(propertyName, defaultProperties.getProperty(propertyName), true, false, false);
                collection.addProperty(prop);
            }
        }
        return collection;
    }

    public Map<String, List<String>> readingPropertyFileWithMultiParameters(String propertiesFileName) throws FileNotFoundException {
        Map<String, List<String>> parametersMap = new HashMap<>();
//todo oddzielenie przy =
        //todo zrobienie dla tiles/flow/incidents osobnych
        //todo zrobienie z propertiesow a nie z pliku txt
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\int_miwg\\Desktop\\test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = content.split("\\r?\\n"); // split on new lines
        for (int i = 0; i < lines.length; i++) {
            List tempListParametersValue = new LinkedList();
            String keyValue = "";
            String[] temp = lines[i].split(","); // split on comma
            for (int j = 0; j < temp.length; j++) {
                keyValue = temp[0];
                if (j > 0)
                    tempListParametersValue.add(temp[j]);
            }
            parametersMap.put(keyValue, tempListParametersValue);
        }
        return parametersMap;
    }
    public PropertyCollection readingPropertyFileTwo(Map<String,List<String>> propertiesMap, String patternName) throws IOException {

        PropertyCollection collection = new PropertyCollection();
        for (String propertyName : propertiesMap.keySet()) {
            if (Pattern.matches("" + patternName + ".*", propertyName)) {
                Property prop = new Property(propertyName, propertiesMap.get(propertyName).get(0), Boolean.parseBoolean(propertiesMap.get(propertyName).get(1)), false, false);
                collection.addProperty(prop);
            }
        }
        return collection;
    }

}
