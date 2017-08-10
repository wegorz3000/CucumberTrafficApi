//package config;
//
//import java.util.Properties;
//
//public class Config implements Methods{
//
//    Properties properties;
//    public Config(Properties properties){
//        this.properties = properties;
//    }
//
//    public Config() {
//    }
//
//
//    public void isMandatory(String name) {
//        properties.getProperty(name).length();
//    }
//
//
//    @Override
//    public void isOptional() {
//        properties.getProperty("dupa");
//    }
//}
//
//
////    Properties properties;
////    FlowConfig flowConfig;
////    IncidentsConfig incidentsConfig;
////    TilesConfig tilesConfig;
//
////    List<BaseTypeConfig> trafficProperties;
////
////    public Config(Properties properties) {
////        this.properties = properties;
////
////        flowConfig = new FlowConfig(this.properties);
////    }
////  /*  String str = System.getProperty("PROPERTIES_PATH");
////    try{
////        Properties props = new Properties();
////    } catch(FileNotFoundException e){
////        logger.error('file wa snot foound');
////        try {
////            throw new FrameworkExceptions(FrameworkExceptions.ExceptionType.NoHeaders, e.getMessage());
////        } catch (FrameworkExceptions frameworkExceptions) {
////            frameworkExceptions.printStackTrace();
////        }
////    }
////
////*/
////
////}
////
////public interface BaseTypeConfig{
////    getConfig
////    setConfig
////}