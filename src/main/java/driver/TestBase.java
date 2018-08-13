package driver;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.TestConfiguration;

import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
public class TestBase {

    protected String user1 = TestConfiguration.getUser1();
    protected String user2 = TestConfiguration.getUser2();
    protected String serverAdress = TestConfiguration.getServerAdress();
    protected String password = TestConfiguration.getPassword();

    @BeforeTest
    public void setUp(ITestContext testContext) throws IOException, InterruptedException {
        AppiumDriverSingleton.getDriver();
        log.info("Initializing driver");
    }

    @AfterTest
    public void tearDown() throws MalformedURLException {
        AppiumDriverSingleton.getDriver().quit();
        log.info("Shutting down driver");
    }

}
