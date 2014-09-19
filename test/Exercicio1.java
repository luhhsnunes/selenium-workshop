import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercicio1 {
	public FirefoxDriver driver;

	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(){
		driver.close();
	}

	@Test
	public void realizaBusca() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.findElementById("gbqfq").sendKeys("Pão de Queijo Mineiro");
		driver.findElementById("gbqfb").click();
		WebElement link = driver.findElementByLinkText("Pão de Queijo Mineiro");
		
		assertThat(link.isDisplayed(), equalTo(Boolean.TRUE));
	}
}
