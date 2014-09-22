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

public class DeletePostTest {
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
	public void deletePost() {
		AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.login();
		
		AllPostsPage allPostsPage = PageFactory.initElements(driver, AllPostsPage.class);
		allPostsPage.deletePost("My First Post");
		
		String deletedPostMessage = allPostsPage.getDeletedPostMessage();
		assertThat(deletedPostMessage, is("1 post moved to the Trash. Undo"));
	}
}
