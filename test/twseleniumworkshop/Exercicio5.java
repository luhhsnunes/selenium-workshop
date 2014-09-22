package twseleniumworkshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Exercicio5 {
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void demoTest(){
        driver.get("http://bit.ly/watir-webdriver-demo");
        driver.findElement(By.id("entry_0")).sendKeys("Rodrigo Tolledo");
        selectOptionInDropBox("entry_1", "Ruby");
        driver.findElement(By.id("group_2_1")).click();
        driver.findElement(By.id("group_3_3")).click();
        driver.findElement(By.name("submit")).click();
        String message = driver.findElement(By.className("ss-custom-resp")).getText();

        assertThat(message, is("Thank you for playing with Watir-WebDriver"));

    }

    public void selectOptionInDropBox(String id, String value){
        WebElement dropDownListBox = driver.findElement(By.id(id));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(value);
    }
}