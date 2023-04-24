package com.axa.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileSetup {
    public static Properties properties;
    public static void propertyFileSetup() throws Exception {
        try{
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/axaData.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
            throw new Exception("Property file is missing",e);
        }
    }









}
