import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


// Silly implementation without using Page Object pattern.
// The implementation below is just for basic learning purposes.
// For a decent implementation, please see Exercicio4.java

public class Exercicio3 {
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void addNewPost() {
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin");
		WebElement email = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		email.sendKeys("twseleniumworkshop");
		password.sendKeys("twseleniumworkshop!");
		submit.click();
		
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin/edit.php");
		WebElement addNewPost = driver.findElement(By.linkText("Add New"));
		addNewPost.click();
		
		driver.switchTo().frame("content_ifr");
		WebElement postBody = driver.findElement(By.id("tinymce"));
		postBody.sendKeys("This is a description.");
		driver.switchTo().defaultContent();
		WebElement title = driver.findElement(By.id("title"));
		title.sendKeys("My First Post");
		
		WebElement publish = driver.findElement(By.id("publish"));
		publish.click();
		
		Boolean titleExists = driver.getPageSource().contains("My First Post");
		
		assertThat(titleExists, equalTo(Boolean.TRUE));
	}
}
