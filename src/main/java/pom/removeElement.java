package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class removeElement {
	
	@FindBy (xpath = "(//a[text()='Remove'])[1]")private WebElement remove;
	
	public removeElement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnRemoveElements()
	{
		remove.click();
	}
}
