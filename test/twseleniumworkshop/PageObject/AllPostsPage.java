package twseleniumworkshop.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllPostsPage {
	WebDriver driver;

	@FindBy(id="title")
	WebElement postTitle;
	
	@FindBy(id="tinymce")
	WebElement postBody;
	
	@FindBy(id="publish")
	WebElement publish;
	
	public AllPostsPage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://twseleniumworkshop.wordpress.com/wp-admin/edit.php");
	}

	public void addNewPost(String postTitle, String postBody) {
		WebElement addNewPost = driver.findElement(By.linkText("Add New"));
		addNewPost.click();
		
		driver.switchTo().frame("content_ifr");
		this.postBody.sendKeys(postBody);
		driver.switchTo().defaultContent();
		this.postTitle.sendKeys(postTitle);
		
		publish.click();
	}
	
	public void editPost(String newPostTitle, String newPostBody) {
		
	}
	
	public void deletePost(String title) {
		
	}
}
