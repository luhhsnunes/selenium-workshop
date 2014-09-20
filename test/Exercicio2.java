import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Exercicio2 {
    WebDriver driver;

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
        driver.findElement(By.className("signup-link")).click();
        driver.findElement(By.id("signup-email")).sendKeys("pedro-" + generateRandomNumber() + "@gmail.com");
        driver.findElement(By.id("signup-password")).sendKeys("Tartaruga01");
        driver.findElement(By.name("repeat-password")).sendKeys("Tartaruga01");
        driver.findElement(By.cssSelector("input[value = 'Sign Up Now!']")).click();
        boolean result = driver.findElement(By.className("greeting-link")).isEnabled();
        
        assertThat(result, equalTo(Boolean.TRUE));
    }

    @Test
    public void editAccount(){
        driver.get("http://www.flipkart.com/account");
        driver.findElement(By.id("login_email_id1")).sendKeys("bruno@gmail.com");
        driver.findElement(By.id("login_password1")).sendKeys("Tartaruga01");
        driver.findElement(By.id("login-cta")).click();
        String message = driver.findElement(By.className("fk-font-verybig")).getText();
        
        assertThat(message, is("Personal Information"));
    }
    
    public int generateRandomNumber() {
    	Random random = new Random();
    	return random.nextInt(9999);
    }
}
