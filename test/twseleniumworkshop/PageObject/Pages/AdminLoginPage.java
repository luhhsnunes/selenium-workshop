package twseleniumworkshop.PageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	WebDriver driver;
	
	@FindBy(id="user_login")
	WebElement email;
	
	@FindBy(id="user_pass")
	WebElement password;
	
	@FindBy(id="wp-submit")
	WebElement submit;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin");
	}
	
	public void login() {
		email.sendKeys("twseleniumworkshop");
		password.sendKeys("twseleniumworkshop!");
		submit.click();
	}
}