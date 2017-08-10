package config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PropertyCollection {
    File pathPropertyFile;

    List<Property> propertyCollection = new ArrayList<>();

    public PropertyCollection(File pathPropertyFile) {
        this.pathPropertyFile = pathPropertyFile;
    }

    public PropertyCollection(){};

    public void addProperty(Property property) {
        propertyCollection.add(property);
    }

    public Property getProperty(String name) {
        Property returnProperty = null;
        for (Property property : propertyCollection) {
           if (property.getName().equals(name)){
                returnProperty = property;
            }
        }
        return returnProperty;
    }


}
