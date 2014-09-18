/**
 * Created by bborges on 9/18/14.
 */
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Exercicio2 {
    public FirefoxDriver driver;

    @Before
    public void setup() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void createAccount(){
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName(("signup-link")).click();
        driver.findElementById("signup-email").sendKeys("1111222345@gmail.com");
        driver.findElementById("signup-password").sendKeys("Tartaruga01");
        driver.findElementByName("repeat-password").sendKeys("Tartaruga01");
        driver.findElement(By.cssSelector("input[value = 'Sign Up Now!']")).click();
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result,equalTo(Boolean.TRUE));
    }


}
