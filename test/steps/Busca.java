package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by lnunes on 9/18/14.
 */
public class Busca {
    public FirefoxDriver driver;


    @Before
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){

        driver.close();
    }

    @Test
    public void realizaBusca() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.findElementById("gbqfq").sendKeys("Pão de Queijo Mineiro");
        driver.findElementById("gbqfb").click();
        WebElement result = driver.findElementByLinkText("Pão de Queijo Mineiro");
        assertThat(result.isDisplayed(), equalTo(Boolean.TRUE));

    }
}
