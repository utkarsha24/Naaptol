package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveElement {
	
	@FindBy (xpath = "(//a[text()='Remove'])[1]")private List<WebElement> remove;
	@FindBy (xpath = "//a[@title='Close']")private WebElement close;
	
	public RemoveElement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnRemove(WebDriver driver,int product) throws InterruptedException
	{
	
		Thread.sleep(1000);
	
		remove.get(product).click();
}
	
	public void clickOnClose()
	{
		close.click();
	}
}
