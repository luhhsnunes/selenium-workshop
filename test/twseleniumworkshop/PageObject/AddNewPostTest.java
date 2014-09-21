package twseleniumworkshop.PageObject;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewPostTest {
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
		AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.login();
		
		AllPostsPage allPostsPage = PageFactory.initElements(driver, AllPostsPage.class);
		allPostsPage.addNewPost("My First Post", "This is a description.");
		
		Boolean titleExists = driver.getPageSource().contains("My First Post");
		assertThat(titleExists, equalTo(Boolean.TRUE));
	}
}
