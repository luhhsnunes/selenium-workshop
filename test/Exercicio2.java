/**
 * Created by bborges on 9/18/14.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.findElementById("signup-email").sendKeys("pedro@gmail.com");
        driver.findElementById("signup-password").sendKeys("Tartaruga01");
        driver.findElementByName("repeat-password").sendKeys("Tartaruga01");
        driver.findElement(By.cssSelector("input[value = 'Sign Up Now!']")).click();
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }

    @Test
    public void editAccount(){
        driver.get("http://www.flipkart.com/account");
        driver.findElementById("login_email_id1").sendKeys("bruno@gmail.com");
        driver.findElementById("login_password1").sendKeys("Tartaruga01");
        driver.findElementById("login-cta").click();
        String result = driver.findElementByClassName("fk-font-verybig").getText();
        assertThat(result, containsString("Personal Information"));
    }

}
