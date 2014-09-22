package twseleniumworkshop.PageObject.Pages;

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
	
	public void editPost(String title, String newPostBody) {
		WebElement post = driver.findElement(By.linkText(title));
		post.click();
		driver.switchTo().frame("content_ifr");
		postBody.clear();
		postBody.sendKeys(newPostBody);
		driver.switchTo().defaultContent();
		publish.click();
	}
	
	public void deletePost(String title) {
		WebElement post = driver.findElement(By.linkText(title));
		post.click();
		WebElement deletePost = driver.findElement(By.linkText("Move to Trash"));
		deletePost.click();
	}
	
	public Boolean verifyIfPostWasAdded(String post) {
		return driver.getPageSource().contains(post);
	}
	
	public String getUpdatedPostMessage() {
		return driver.findElement(By.cssSelector("#message p")).getText();
	}
	
	public String getDeletedPostMessage() {
		return driver.findElement(By.cssSelector("#message p")).getText();
	}
}
