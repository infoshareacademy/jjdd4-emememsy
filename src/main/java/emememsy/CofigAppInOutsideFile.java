package emememsy;

import java.io.*;
import java.util.Properties;

public class CofigAppInOutsideFile {


    /*  private static void savePropertiesFileWriter(Properties properties, String filename) {
          try (Writer writer = new FileWriter(filename)) {
              properties.store(writer, null);
          } catch (IOException e) {
              e.printStackTrace();
          }


      }


      */
    public static Properties main(String[] args) {


        Properties getProperties;
        String resourceName = "myconf.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
        } catch (Exception e) {
            System.out.println("Błąd pobrania pliku");
        }

        return props;


    }


}