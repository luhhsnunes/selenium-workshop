package twseleniumworkshop;

/**
 * Created by lnunes on 9/23/14.
 */

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BonusAndroid {

        private WebDriver driver;

        @Before
        public void setUp() throws Exception {
            // Choose the browser, version, and platform to test
            DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//            capabilities.setCapability("version", "");
            capabilities.setCapability("device", "iphone");
//            capabilities.setCapability("platform", Platform.ANY);
            // Create the connection to Sauce Labs to run the tests
            this.driver = new RemoteWebDriver(
                    new URL("http://usuario:chaveprivada@ondemand.saucelabs.com:80/wd/hub"),
                    capabilities);
        }

        @Test
        public void webDriver() throws Exception {
            // Make the browser get the page and check its title
            driver.get("http://www.amazon.com/");
            assertThat("Amazon.com", equalTo(driver.getTitle()));
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
        }

    }

