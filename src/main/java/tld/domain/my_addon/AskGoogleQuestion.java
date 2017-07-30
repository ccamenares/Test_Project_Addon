package tld.domain.my_addon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.testproject.java.enums.ExecutionResultType;
import io.testproject.java.sdk.generated.codeblocks.Action;

public class AskGoogleQuestion extends Action {
	
	private String question = "How can I best test my software?";
	@Override
	protected ExecutionResultType execute() throws Exception {
		// Get Driver
		WebDriver driver = this.getWebDriver();
		
		// Assuming that we are on Google's page
		if (!driver.getCurrentUrl().toLowerCase().contains("google")
		    && !driver.getTitle().toLowerCase().contains("google")) 
		{
			this.setMessage("Are you on Google Search page ?");
			return ExecutionResultType.Failed;
		}
		
		// Find search box element
		WebElement searchBox = driver.findElement(By.name("q"));
		// Clear any previous text
		searchBox.clear();
		// Type question
		searchBox.sendKeys(this.question);
		// Submit search
		searchBox.submit();
		
		return null;
		
		
	}

}
