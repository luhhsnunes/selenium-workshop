package twseleniumworkshop.PageObject;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import twseleniumworkshop.PageObject.Pages.AdminLoginPage;
import twseleniumworkshop.PageObject.Pages.AllPostsPage;

public class EditPostTest {
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
	public void editPost() {
		AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.login();
		
		AllPostsPage allPostsPage = PageFactory.initElements(driver, AllPostsPage.class);
		allPostsPage.editPost("My First Post", "This is a NEW description.");
		
		String updatedPostMessage = allPostsPage.getUpdatedPostMessage();
		assertThat(updatedPostMessage, is("Post updated. View post"));
	}
}
