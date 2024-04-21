package StepDefination;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.shaded.messages.types.StepDefinition;

public class CommonStepDef extends BaseClass{


	
	@And("Close the browser")
	public void close_the_browser() {
		System.out.println("browser will terminate from hook");
		log.info("close the browser");
	}
}
