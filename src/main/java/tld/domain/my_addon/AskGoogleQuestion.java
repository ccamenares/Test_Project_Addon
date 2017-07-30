package tld.domain.my_addon;

import org.openqa.selenium.WebDriver;

import io.testproject.java.enums.ExecutionResultType;
import io.testproject.java.sdk.generated.codeblocks.Action;

public class AskGoogleQuestion extends Action {

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
		
		return null;
		
		
	}

}
