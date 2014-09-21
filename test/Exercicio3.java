import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


// Silly implementation with lots of code duplication.
// The implementation below is just for basic learning purposes.
// For a decent implementation (using Page Object pattern), please see Exercicio4.java

public class Exercicio3 {
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
		WebElement postTitle = driver.findElement(By.id("title"));
		postTitle.sendKeys("My First Post");
		
		WebElement publish = driver.findElement(By.id("publish"));
		publish.click();
		
		Boolean titleExists = driver.getPageSource().contains("My First Post");
		
		assertThat(titleExists, equalTo(Boolean.TRUE));
	}
	
	@Test
	public void editPost() {
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin");
		WebElement email = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		email.sendKeys("twseleniumworkshop");
		password.sendKeys("twseleniumworkshop!");
		submit.click();
		
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin/edit.php");
		WebElement post = driver.findElement(By.linkText("My First Post"));
		post.click();
		driver.switchTo().frame("content_ifr");
		WebElement newPostBody = driver.findElement(By.id("tinymce"));
		newPostBody.clear();
		newPostBody.sendKeys("This is a NEW description.");
		driver.switchTo().defaultContent();
		WebElement update = driver.findElement(By.id("publish"));
		update.click();
		
		String updatedPostMessage = driver.findElement(By.cssSelector("#message p")).getText();
		
		assertThat(updatedPostMessage, is("Post updated. View post"));
	}
	
	@Test
	public void deletePost() {
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin");
		WebElement email = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		email.sendKeys("twseleniumworkshop");
		password.sendKeys("twseleniumworkshop!");
		submit.click();
		
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin/edit.php");
		WebElement post = driver.findElement(By.linkText("My First Post"));
		post.click();
		WebElement deletePost = driver.findElement(By.linkText("Move to Trash"));
		deletePost.click();
		
		String deletedPostMessage = driver.findElement(By.cssSelector("#message p")).getText();
		
		assertThat(deletedPostMessage, is("1 post moved to the Trash. Undo"));
	}
}
