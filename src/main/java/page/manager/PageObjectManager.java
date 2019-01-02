package page.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.nike.all_pages.HomePage;

public class PageObjectManager {
	WebDriver driver;
	
	private HomePage homePage;
	
	/*----------Constructor---------*/
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}/*----------End of Constructor---------*/
	
	public HomePage getHomePage() {
	     return (homePage == null) ? new HomePage(driver) : homePage;
	}


}
