package driver;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
public class TestBase {

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        AppiumDriverSingleton.getDriver();
        log.info("Initializing driver");
    }

    @AfterTest
    public void tearDown() throws MalformedURLException {
        AppiumDriverSingleton.getDriver().quit();
        log.info("Shutting down driver");
    }

}
