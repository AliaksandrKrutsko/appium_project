package utilities;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class TestConfiguration {

    public enum TestProperties {

        USER_ONE("user1"),
        USER_TWO("user2"),
        SERVER_ADRESS("serverAdress"),
        PASSWORD("password");

        private String property;

        TestProperties(String myProperty) {
            this.property = myProperty;
        }

        public String get() {
            return property;
        }

    }

    private static Properties config = new Properties();
    private static String fileName = "/testConfig222.properties";

    private static InputStream is = TestConfiguration.class.getResourceAsStream(fileName);

    static {
        try {
            config.load(is);
        } catch (Exception e) {
            log.info("Error reading from property file");
        }
    }

    public static String getUser1() {
        return config.getProperty(TestProperties.USER_ONE.get());
    }

    public static String getUser2() {
        return config.getProperty(TestProperties.USER_TWO.get());
    }

    public static String getServerAdress() {
        return config.getProperty(TestProperties.SERVER_ADRESS.get());
    }

    public static String getPassword() {
        return config.getProperty(TestProperties.PASSWORD.get());
    }

}
