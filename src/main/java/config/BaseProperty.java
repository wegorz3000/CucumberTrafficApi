package config;

import java.util.ArrayList;
import java.util.List;

public class BaseProperty {



    public PropertyCollection ApiCollection(){

        List<Property> trafficApi = new ArrayList<>();

        Property baseUrl = new Property("baseUrl");
        trafficApi.add(baseUrl);
        Property resource = new Property("resource");
        trafficApi.add(resource);
        Property path = new Property("path");
        trafficApi.add(path);




        PropertyCollection propertyCollection = new PropertyCollection();
        propertyCollection.addPropoerties(trafficApi);

        return propertyCollection;
    }
}
