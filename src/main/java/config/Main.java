//package config;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        Properties props = new Properties();
//        FileInputStream fileInput = new FileInputStream("RestApiConfig.properties");
//        props.load(fileInput);
//        Config config = new Config(props);
//        System.out.println(config.properties.getProperty("flow.v1.path"));
//  //      System.out.println(config.isMandatory("flow.v1.path"));
//    }
//}
